/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BSQL;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author hangfeifei
 */
public class Client_Java {

    private Socket socket = null;
    private BufferedReader input = null;
    private PrintWriter output = null;

    private String server = null;
    private int port = -1;

    public Client_Java( String server, int port ) {
        this.server = server;
        this.port = port;
        System.out.println( "Server: " + this.server );
        System.out.println( "Port: " + this.port );
    }

    public void BSQL_Table( String database, String bsql ) {
        try {
            String lines = database + "/Tables\n" + bsql;
            socket = new Socket( this.server, this.port );
            output = new PrintWriter( socket.getOutputStream() );
            output.println( lines );
            output.println( "\0" );
            output.flush();
            System.out.println( "Sent database: " + database );
            System.out.println( "Sent BSQL:\n" + bsql );
            String line = null;
            input = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
            while( ( line = input.readLine() ) != null ) {
                System.out.println( line );
            }
            output.close();
            input.close();
            socket.close();
        } catch ( Exception excpt ) {
            // handle exception
        }
    }

}
