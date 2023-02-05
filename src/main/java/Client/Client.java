package Client;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import org.json.simple.JSONObject;
import com.google.gson.Gson;

public class Client {

	public static void SearchMessage(int socketno) throws FileNotFoundException, IOException {
		String search_message="";
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Search the message containing the Hashtag: ");
		search_message=myObj.next();

		try (BufferedReader br = new BufferedReader(new FileReader("..\\Supplements\\"+socketno+".txt"))) {
			String line;
			boolean check=false;
			while ((line = br.readLine()) != null) {
				if(line.contains(search_message)) { 
					System.out.println(line);
					check=true;
				} 
			}
			if (check==false) {
				System.out.println("No Message with HashTag '"+search_message+"'found");
			}
		}
	}
	static FileWriter fr =null;
	public static void main(String[] args) throws IOException {
		String name = "empty";
		String reply = "empty";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name (Please enter your name to join the chat): ");
		reply = sc.nextLine();
		name = reply;
		int portno=12345;
		try (Socket socket = new Socket("localhost", portno)) {
			while(true) {
				fr = new FileWriter("J:\\Eclipse_Workspace\\Supplements\\"+portno+".txt", true);        	
				System.out.println("\n1) Do you want to join chat?");
				System.out.println("2) Do you want to search messages?");
				int options;
				options=sc.nextInt();
				if(options==1) {
					PrintWriter cout = new PrintWriter(socket.getOutputStream(), true);
					ThreadClient threadClient = new ThreadClient(socket);
					new Thread(threadClient).start(); // start thread to receive message
					fr.write(reply + ": has joined Sheffield Hallam University Community Chat Server.\n");
					cout.println(reply + ": has joined Sheffield Hallam University Community Chat Server.");
					do {  	
						JSONObject obj = new JSONObject();
						reply = sc.nextLine();
						if (reply.equals("logout")) {
							cout.println("logout");
							break;
						}
						String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());
						obj.put("from", new String(name));
						obj.put("when", new String(timeStamp));
						obj.put("body",new String( reply));
						Gson gson1 = new Gson(); 
						String json1 = gson1.toJson(obj); 
						fr.write(json1+"\n");
						cout.println(json1);
					} while (!reply.equals("logout"));
					fr.close();
				}else if (options==2) {
					SearchMessage(portno);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}