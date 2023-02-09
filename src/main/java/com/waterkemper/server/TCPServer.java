package com.waterkemper.server;

import com.waterkemper.handler.Request;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Logger;

public class TCPServer {

    private static final Logger logger = Logger.getLogger("TCPServer");

    public static void main(String[] args) throws IOException {
        var server = new ServerSocket(8888);

        logger.info("Starting server TCP on port %s".formatted(server.getLocalPort()));

        while (true) {
            var socket = server.accept();
            System.out.println("local port -> " + socket.getLocalPort());
            System.out.println("remote port -> " + socket.getPort());
            System.out.println("local socket address -> " + socket.getLocalSocketAddress());
            System.out.println("remote socket address -> " + socket.getRemoteSocketAddress());
            System.out.printf("""
                    Accepting new socket on port %s
                    """, socket.getLocalPort());
            new Thread(new Request(socket), "thread-rafa".concat(""+socket.getPort())).start();
        }
    }
}
