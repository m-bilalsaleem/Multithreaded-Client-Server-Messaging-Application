package Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;


public class ThreadClient implements Runnable {

    private Socket socket;
    private BufferedReader cin;
    
    public ThreadClient(Socket socket) throws IOException {
        this.socket = socket;
        this.cin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
        	System.out.println("Start communicating with other peoples");
        		while (true) {
                    String message = cin.readLine();
                    System.out.println(message);
                }	
        } catch (SocketException e) {
            System.out.println("You left the Sheffield Hallam University Community Chat Server");
        } catch (IOException exception) {
            System.out.println(exception);
        } finally {
            try {
                cin.close();
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }
}