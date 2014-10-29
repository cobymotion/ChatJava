
package servidor;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    
    // constructor 
    public Servidor()
    {
        System.out.println("Iniciando construccion de obj");
         try{
             ServerSocket server = new ServerSocket(5005);
             //provisional
             Socket socket = server.accept();
             DataInputStream entrada = 
                     new DataInputStream(socket.getInputStream());
             while(true)
             {                 
                     String cad1 = entrada.readUTF(); 
                     System.out.println("Texto: " + cad1);              
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
