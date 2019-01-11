package NetworkTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Scanner;

public class ThreadedEchoServer {
    public static void main(String[] args) {
        System.out.println("You need to use telnet to access this application.\nThis is MULTI THREAD.");
        /*
         * Create a server socket with particular port
         */
        try (var s = new ServerSocket(8189)) {
            /*
             * waits for a connection.
             * close() to close the server socket.
             */
            int i = 1;
            while (true) {
                Socket incoming = s.accept();
                System.out.println("Spawning " + i);
                Runnable r = new ThreadedEchoHandler(incoming);
                var t = new Thread(r);
                t.start();
                i++;
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

class ThreadedEchoHandler implements Runnable {
    private Socket incoming;

    public ThreadedEchoHandler(Socket incomingSocket){
        incoming = incomingSocket;
    }

    public void run() {
        try(
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                var in = new Scanner(inStream, StandardCharsets.UTF_8);
                var out = new PrintWriter(
                    new OutputStreamWriter(
                            outStream, StandardCharsets.UTF_8), true))
        {
            out.println("Enter BYE to exit.");

            var done = false;
            while (!done && in.hasNextLine()) {
                String line = in.nextLine();
                out.println("Echo: " + line);
                if (line.trim().equals("BYE")) {
                    done = true;
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
