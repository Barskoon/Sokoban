import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyClient extends Thread {
    private Socket socket;
    public MyClient(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        System.out.println("socket = " + socket);

        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            Imambek imambek = new Imambek();
            out.writeObject(imambek);

            socket.close();
        } catch (IOException ioe) {
            //To log here
            System.out.println("Error: " + ioe);
        }
    }
}
