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
            System.out.printf("""
                    Accepting new socket on port %s
                    """, socket.getPort());
            new Thread(new Request(socket)).start();
        }
    }
}
