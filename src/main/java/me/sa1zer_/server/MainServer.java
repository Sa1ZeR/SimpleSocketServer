package me.sa1zer_.server;

import me.sa1zer_.server.configuration.ServerConfig;
import me.sa1zer_.server.response.ServerSocketHandler;
import me.sa1zer_.server.utils.LoggerUtils;

public class MainServer {

    public static MainServer instance;

    private ServerConfig serverConfig;
    private ServerSocketHandler serverSocketHandler;

    public MainServer() {
        instance = this;

        serverConfig = new ServerConfig();
        serverSocketHandler = new ServerSocketHandler(this);
        serverSocketHandler.start();
    }

    public static void main(String[] args) {
        new MainServer();
    }

    public ServerConfig getServerConfig() {
        return serverConfig;
    }
}
