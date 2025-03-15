import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.scene.control.ListView;
/*
 * Clicker: A: I really get it    B: No idea what you are talking about
 * C: kind of following
 */

public class Server{

	int count = 1;	
	ArrayList<ClientThread> clients = new ArrayList<ClientThread>();
	TheServer server;
	private Consumer<Serializable> callback;
	
	Server(Consumer<Serializable> call){
	
		callback = call;
		server = new TheServer();
		server.start();
	}
	
	
	public class TheServer extends Thread{
		
		public void run() {
		
			try(ServerSocket mysocket = new ServerSocket(5555);){
		    System.out.println("Server is waiting for a client!");
		  
			
		    while(true) {
		
				ClientThread c = new ClientThread(mysocket.accept(), count);
				callback.accept("client has connected to server: " + "client #" + count);
				clients.add(c);
				c.start();
				
				count++;
				
			    }
			}//end of try
			catch(Exception e) {
				callback.accept("Server socket did not launch");
			}
		}//end of while
	}
	

		class ClientThread extends Thread{
			
		
			Socket connection;
			int count;
			ObjectInputStream in;
			ObjectOutputStream out;
			
			ClientThread(Socket s, int count){
				this.connection = s;
				this.count = count;	
			}
			
			public synchronized void updateClients(MessageInfo message) {
				for(int i = 0; i < clients.size(); i++) {
					ClientThread t = clients.get(i);
					try {
					 t.out.writeObject(message);
					}
					catch(Exception e) {}
				}
			}
			
			public synchronized void updateClients(MessageInfo message, ArrayList<Integer> goesTo) {
				for(int i = 0; i < clients.size(); i++) {
					ClientThread t = clients.get(i);
					try {
						if (goesTo.contains(t.count))
							t.out.writeObject(message);
					}
					catch(Exception e) {}
				}
			}
			
			
			public synchronized String clientsOnServer(String message) {
				for(int i = 0; i < clients.size() - 1; i++) {
					ClientThread t = clients.get(i);
					message += "#" + t.count + ", ";
				}
				ClientThread t2 = clients.get(clients.size()-1);
				message += "#" + t2.count;

				return message;
			}
			
			public void run(){
					
				try {
					in = new ObjectInputStream(connection.getInputStream());
					out = new ObjectOutputStream(connection.getOutputStream());
					connection.setTcpNoDelay(true);	
				}
				catch(Exception e) {
					System.out.println("Streams not open");
				}
				/*
				updateClients("new client on server: client #"+count);
				clientsOnServer("clients on server: ");
				*/
				MessageInfo m1 = new MessageInfo();
				m1.message = "new client on server: client #"+count;
				m1.clients = clientsOnServer("clients on server: ");
				updateClients(m1);
				while(true) {
					try {
						/*
						String data = in.readObject().toString();
					    callback.accept("client: " + count + " sent: " + data);
					    updateClients("client #"+count+" said: "+data);
					    	*/
						MessageInfo data = (MessageInfo) in.readObject();
						
						callback.accept("client: " + count + " sent: " + data.message);
						data.message = "client #"+count+" said: "+data.message;
						data.clients = clientsOnServer("clients on server: ");
						if (!data.sendAll) {
							try {
								int[] temp = Arrays.asList(data.recipients.split(",")).stream()
									.map(String::trim).mapToInt(Integer::parseInt).toArray();
								ArrayList<Integer> goesTo = new ArrayList<Integer>();
								for (int i : temp) {
									goesTo.add(i);
								}
								updateClients(data, goesTo);
							
							} catch (Exception e) {
								//data.message = "message did not send: try again";
								//System.out.println("problem");
							}
						} else {
							updateClients(data);
						}
						
					}
					catch(Exception e) {
						callback.accept("OOOOPPs...Something wrong with the socket from client: " + count + "....closing down!");
					    /*
						updateClients("Client #"+count+" has left the server!");
					    clients.remove(this);
					    if (clients.size() > 0)
					    	clientsOnServer("clients on server: ");
					    break;
					    */
						synchronized(clients) {
							MessageInfo m2 = new MessageInfo();
							m2.message = "Client #"+count+" has left the server!";
							clients.remove(this);
							if (clients.size() > 0)
								m2.clients = clientsOnServer("clients on server: ");
							updateClients(m2);
						}
						break;
					}
				}
			}//end of run
			
		}//end of client thread
}


	
	

	
