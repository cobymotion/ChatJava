package cliente;

import java.net.Socket;

public class Cliente {
    
    public static void main(String[] args) {
         try
         {
             Socket socket = new Socket("127.0.0.1",5005);
             Ventana ventana = new Ventana(socket); 
             ventana.setVisible(true);
         }
         catch(Exception e) {
             System.out.println("Error al conectar con el Serv");
         }
    }
    
}
