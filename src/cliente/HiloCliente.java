package cliente;

import java.io.DataInputStream;
import java.net.Socket;
import javax.swing.JTextArea;

public class HiloCliente implements Runnable{
    
    DataInputStream entrada; 
    JTextArea mensajes; 
    
    public HiloCliente(Socket socket, JTextArea area)
    {
        mensajes=area;
        try {
            entrada = new DataInputStream
                      (socket.getInputStream());
            Thread hilo = new Thread(this);
            hilo.start();
        } catch (Exception e) {
            System.out.println("Error en el constructor");
        }
    }
    
    @Override
    public void run() {
        try {
            while(true)
            {
                String cad = entrada.readUTF(); 
                mensajes.insert(cad+"\n",0);                
            }
        } catch (Exception e) {
            System.out.println("Error en el hilo");
        }
    }
    
}









