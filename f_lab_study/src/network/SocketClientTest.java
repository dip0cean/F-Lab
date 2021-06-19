package network;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClientTest {
    public static void main(String[] args) {
        SocketClientTest test = new SocketClientTest();
    }

    public void sendSocket() {
        for (int i = 0; i < 3; i++) {
            sendSocket("I Love Java : " + i);
        }
        sendSocket("EXIT");
    }

    public void sendSocket(String data) {
        Socket socket = null;

        try {
            System.out.println("Client : Connecting");
            socket = new Socket("127.0.0.1", 9999);
            System.out.println("Client : Connect Status : " + socket.isConnected());

            Thread.sleep(1000);
            OutputStream         stream = socket.getOutputStream();
            BufferedOutputStream out    = new BufferedOutputStream(stream);

            byte[] bytes = data.getBytes();
            out.write(bytes);
            System.out.println("Client : send Data!");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
