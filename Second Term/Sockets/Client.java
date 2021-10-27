import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Client {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", Port.number);
            System.out.println("Connected to server.");
        } catch (IOException e) {
            System.err.println("Could not connect to localhost:" + Port.number);
            System.exit(1);
        }

        BufferedReader fromServer = null;
        PrintWriter toServer = null;
        BufferedReader fromUser = null;
        int exitCode = 0;

        try {
            fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            fromUser = new BufferedReader(new InputStreamReader(System.in));
            toServer = new PrintWriter(socket.getOutputStream());

            System.out.println("Ready to enter commands.");
            while (true) {
                String command = fromUser.readLine();

                if (Command.QUIT.equals(command)) {
                    toServer.println(command);
                    toServer.flush();

                    /*
                    We break out of the while loop so that later we don't end up
                    waiting for a response from the server.
                     */
                    break;
                }

                if (Command.INSERT.equals(command) || Command.QUERY.equals(command)) {
                    String word = fromUser.readLine();
                    toServer.println(command);
                    toServer.println(word);
                } else if (Command.LIST.equals(command)) {
                    toServer.println(command);
                } else {
                    System.err.println("Unknown command: " + command);
                    continue;
                }

                // Flush any buffered bytes, i.e. actually send the data to the server
                toServer.flush();

                String response = fromServer.readLine();
                if (response == null) {
                    System.out.println("End of stream reached for server.");
                    break;
                } else {
                    System.out.println("Response from server: " + response);
                }
            }

            /*
            The while loop only exits normally when either null has been read,
            indicating the server has died, or the user has entered "quit",
            meaning we should shut down.
             */
            System.out.println("Shutting down ...");
        } catch (IOException e) {
            System.err.println("Error communicating with server: " + e.getMessage());

            /*
            We set an exit code rather than running System.exit(1) here,
            since this would circumvent the finally block.
             */
            exitCode = 1;
        } finally {
            try {
                fromUser.close();
                fromServer.close();
                toServer.close();
                socket.close();
            } catch (Exception e) {
                System.err.println("Could not close socket/streams");
                exitCode = 1;
            } finally {
                System.exit(exitCode);
            }
        }
    }

}
