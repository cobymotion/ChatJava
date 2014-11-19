package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;


class ProcesoCliente 
implements Runnable, ListDataListener {

    private Socket socket; 
    private DefaultListModel listaUsuario;
    private DataInputStream entrada; 
    private DataOutputStream salida;

    public ProcesoCliente(Socket socket, DefaultListModel listaUsuario) {
        this.socket = socket;
        this.listaUsuario = listaUsuario;
        try{
              entrada = new DataInputStream
                   (socket.getInputStream());
              salida = new DataOutputStream
                    (socket.getOutputStream());
              listaUsuario.addListDataListener(this);
        }
        catch(Exception e){
            System.out.println("Error al tratar de comn");
        }
    }
    
    @Override
    public void run() {
         try {
            while(true){
                String texto = entrada.readUTF();
                synchronized(listaUsuario){
                    listaUsuario.addElement(texto);
                    System.out.println("Se envio: " + texto);
                }
            }
        } catch (Exception e) {
             System.out.println("Uno de los usuarios se fue");
        }
    }

    @Override
    public void intervalAdded(ListDataEvent e) {
         String texto = (String) listaUsuario.getElementAt
        (e.getIndex0());
         try {
            salida.writeUTF(texto);
        } catch (Exception ed) {
             System.out.println("Error al reenviar");
        }
    }

    @Override
    public void intervalRemoved(ListDataEvent e) {    }

    @Override
    public void contentsChanged(ListDataEvent e) {    }
    
}






