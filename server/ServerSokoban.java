import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSokoban {
    private ServerSocket serverSocket;
    private static final Object object = new Object();

    public ServerSokoban(int portNumber) {
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException ioe) {
            // To log Here
            System.out.println("Error: " + ioe);
        }
    }

    public void go() {
        System.out.println("The Server has been started");
        while (true) {
            synchronized (object) {
                Socket clientSocket;
                try {
                    clientSocket = serverSocket.accept();
                } catch (IOException ioe) {
                    // To log here
                    System.out.println("Error: " + ioe);
                    clientSocket = null;
                }
                if (clientSocket != null) {
                    MyClient client = new MyClient(clientSocket);
                    client.start();
                }
            }
        }
    }
}