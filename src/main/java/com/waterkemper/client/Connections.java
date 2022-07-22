package com.waterkemper.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

public class Connections {
    private static final Logger logger = Logger.getLogger("Connections");

    public static void main(String[] args) throws IOException {
        var socket = new Socket("localhost", 8888);
        logger.info("Connecting to %s".formatted(socket.getPort()));

        var writable = new PrintStream(socket.getOutputStream());
        writable.println("command 1");

        var scanner = new Scanner(System.in);

        var command = scanner.nextLine();

        scanner.close();
        writable.close();
        socket.close();
    }
}
