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
                    """.formatted(socket.getLocalPort()));

        try {
            var inputStream = socket.getInputStream();
            int bytea;
            while ((bytea = inputStream.read()) != -1) {
                System.out.print(new String(new byte[]{(byte)bytea}));
            }

            socket.close();
            System.out.println("Socket closed.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
