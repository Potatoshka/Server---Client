package potato;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(3345);
        Socket client = server.accept();
        System.out.print("Connection accepted.");

        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        DataInputStream in = new DataInputStream(client.getInputStream());

        while (!client.isClosed()){
            String entry = in.readUTF();
            out.writeUTF("Connection Established");
            if(entry.equalsIgnoreCase("Hi server")){
                out.writeUTF("yes,master");
                helloClient(entry);
            }
            else if(entry.equalsIgnoreCase("exit")){
                System.out.println("GoodBye!");
                break;

            }
            else {
                System.out.println("I don't know what to say");
            }
        }
        in.close();
        out.close();


        client.close();

    }

 public static void helloClient(String entry){
     System.out.println("Hello Client!");

 }


}
