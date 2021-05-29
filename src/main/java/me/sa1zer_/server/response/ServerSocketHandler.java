package me.sa1zer_.server.response;

import me.sa1zer_.server.MainServer;
import me.sa1zer_.server.utils.LoggerUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketHandler extends Thread {

    private MainServer mainServer;
    private int socketPort;

    public ServerSocketHandler(MainServer mainServer) {
        this.mainServer = mainServer;
        socketPort = mainServer.getServerConfig().socketPort;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(socketPort);

            LoggerUtils.log(LoggerUtils.LogType.LOG_INFO, "Server socket thread successfully started");
            while (serverSocket.isBound()) {
                Socket socket = serverSocket.accept();
                ClientSession clientSession = new ClientSession(socket);
                clientSession.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
