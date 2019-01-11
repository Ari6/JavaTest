package NetworkTest;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        System.out.println("You need to use telnet to access this application.\nAlso this is SINGLE THREAD.");
        /*
         * Create a server socket with particular port
         */
        try(var s = new ServerSocket(8189))
        {
            /*
             * waits for a connection.
             * close() to close the server socket.
             */
            try(Socket incoming = s.accept())
            {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                try (var in = new Scanner(inStream, StandardCharsets.UTF_8))
                {
                    var out = new PrintWriter(
                            new OutputStreamWriter(
                                    outStream, StandardCharsets.UTF_8), true);
                    out.println("Enter BYE to exit.");

                    var done = false;
                    while (!done && in.hasNextLine()){
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if (line.trim().equals("BYE")) {
                            done = true;
                        }
                    }
                    inStream.close();
                    outStream.close();
                }
            }
        }
    }
}
