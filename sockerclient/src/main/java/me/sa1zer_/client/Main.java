package me.sa1zer_.client;

import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        Socket socket = null;
        try {
             socket = new Socket("127.0.0.1", 5555);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            dataOutputStream.writeUTF("qq server");
            System.out.println(dataInputStream.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
