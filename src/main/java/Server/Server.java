package Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {

    public static void main(String[] args) {
        ArrayList<Socket> clients = new ArrayList<>();
        HashMap<Socket, String> clientNameList = new HashMap<Socket, String>();
        int socketno=12345;
        try (ServerSocket serversocket = new ServerSocket(socketno)) {
            System.out.println("Server is started Successfully");
            System.out.println("Backing up.................................");
            
            File file = new File("..\\Supplements\\"+socketno+".txt"); 
            if (file.exists()){
    	        BufferedReader br= new BufferedReader(new FileReader(file));
       	        String st;
    	        while ((st = br.readLine()) != null)
    	            System.out.println(st);
            }
            else {
            	System.out.println("No message history found");
            }
            FileWriter fw = null;
            fw = new FileWriter(socketno+".txt", true);
            fw.close();
            while (true) {
                Socket socket = serversocket.accept();
                clients.add(socket);
                ThreadServer ThreadServer = new ThreadServer(socket, clients, clientNameList);
                ThreadServer.start();
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}