
package servidor;

import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.DefaultListModel;

public class Servidor {
    private DefaultListModel listaUsuarios = 
            new DefaultListModel();
    // constructor 
    public Servidor()
    {
        System.out.println("Iniciando construccion de obj");
         try{
             ServerSocket server = new ServerSocket(5005);
             //provisional
             while(true){
                    Socket socket = server.accept();
                    ProcesoCliente pCliente = 
                    new ProcesoCliente(socket,listaUsuarios);
                     Thread hilo1 = new Thread(pCliente);
                     hilo1.start();
             }
             // System.out.println("Alguien se conecto");
         }catch(Exception e){
             System.out.println("Error al conectarme");
         }
    }
    
    public static void main(String[] args) {
           System.out.println("Iniciando Servidor....");
           new Servidor(); 
    }
    
}
