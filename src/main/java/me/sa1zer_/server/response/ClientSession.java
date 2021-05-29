package me.sa1zer_.server.response;

import java.io.*;
import java.net.Socket;

public class ClientSession extends Thread {

    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public ClientSession(Socket socket) {
        this.socket = socket;
        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println(dataInputStream.readUTF());
            dataOutputStream.writeUTF("Hellow client");
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
