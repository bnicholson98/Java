import java.io.*;
import java.net.*;

class Server{
	
	public static void main(String[] args){
		
		//server socket bound to specific port
		ServerSocket serverSocket = null;
		try{
			serverSocket = new ServerSocket(Port.number);
		}catch(IOException e){
			System.err.println("Couldn't listen on port: " + Port.number);
			System.exit(1);
		}
		
		WordService wordService = new WordService();
		BufferedReader fromClient = null;
		PrintWriter toClient = null;
		Socket clientSocket = null;
		int exitCode = 0;
		
		try{
			System.out.println("Waiting for client to connect ...");
			clientSocket = serverSocket.accept();
			System.out.println("Client connected.");
			
			fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			toClient = new PrintWriter(clientSocket.getOutputStream());
			
			String command;
			while (true){
				command = fromClient.readLine();
				
				if (command == null){
					System.out.println("End of stream reched for client.");
					break;
				}
				
				if (Command.QUIT.equals(command)){
					System.out.println("Client requested to quit.");
					break;
				}
				
				if (Command.INSERT.equals(command)){
					String word = fromClient.readLine();
					toClient.println(wordService.insert(word));
				} else if (Command.QUERY.equals(command)){
					String word = fromClient.readLine();
					toClient.println(wordService.query(word));
				} else if (Command.LIST.equals(command)){
					toClient.println(wordService.allWords());
				} else {
					System.err.println("Unknown command " + command);
				}
				
				//flush any buffered bytes
				toClient.flush();
			}
			
			System.out.println("Shutting down ...");
		} catch (IOException e){
			System.err.println("Error communicating with client: " + e.getMessage());
			
			exitCode = 1;
			
		} finally {
			try {
				toClient.close();
				fromClient.close();
				clientSocket.close();
				serverSocket.close();
			} catch(Exception e){
				System.err.println("Couldn't clean up sockets: " + e.getMessage());
				exitCode = 1;
			} finally{
				System.exit(exitCode);
			}
		}
	}
}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				