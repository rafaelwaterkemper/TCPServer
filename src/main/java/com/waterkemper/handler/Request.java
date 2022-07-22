package com.waterkemper.handler;

import java.net.Socket;
import java.util.Scanner;

public class Request implements Runnable {
    private Socket socket;

    public Request(Socket socket) {
        this.socket = socket;
    }

    public void run()  {
        System.out.println("""
                    Running task for socket %s
                    """.formatted(socket.getPort()));

        try {
            var buffer = new Scanner(socket.getInputStream());
            while (buffer.hasNextLine()) {
                System.out.println(buffer.nextLine());
            }
            Thread.sleep(10000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Finishing task from port %s".formatted(socket.getPort()));

    }
}
