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
public class Server_Java extends Thread {

    private UI.Panel.Panel_Template panel = null;
    private UI.HomeScreen home = null;

    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private BufferedReader input = null;
    private PrintWriter output = null;

    // Server configurations
    private String database_container = null;
    private int port = -1;

    public Server_Java( UI.HomeScreen home, String database_container, int port ) {
        this.home = home;
        this.database_container = database_container;
        this.port = port;
    }

    public void run() {
        this.listen();
    }

    public void setCurrentPanel( UI.Panel.Panel_Template panel ) {
        this.panel = panel;
    }

    protected void listen() {
        String database = null;
        try{
            serverSocket = new ServerSocket( this.port );
            while( true ) {
                socket = serverSocket.accept();
                database = this.database_container;
                input = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
                output = new PrintWriter( socket.getOutputStream(), true );
                String line = null;
                String bsql = new String();
                boolean grabDatabase = true;
                while( !( line = input.readLine() ).equals( "\0"  ) ) {
                    System.out.println("LINE: " + line);
                    if( grabDatabase ) {
                        database += "/" + line;
                        grabDatabase = false;
                    }
                    else {
                        bsql += line + "\n";
                    }
                }
                if ( BSQL.BSQL_Core.BSQL_Expresion( database, bsql ) ) {
                    ArrayList list = BSQL.BSQL_Core.getFeedback();
                    for( int index = 0; index != list.size(); ++index ) {
                        output.println( list.get( index ).toString() );
                    }
                    this.panel.updateContents( database.substring( 0, database.lastIndexOf( "/" ) ) );
                }
                else {
                    output.print( "BSQL Failure" );
                }
                output.close();
                input.close();
                socket.close();

            }
        } catch ( java.net.BindException excpt ) {
            new javax.swing.JOptionPane().showMessageDialog( this.home, "Address already in use.", "Address Bind...", 0 );
            UI.WelcomeScreen main = new UI.WelcomeScreen();
            Ctrl.ShowDialog.ShowDialog( main );
            this.home.dispose();
        } catch ( IOException excpt ) {
            excpt.printStackTrace();
        }
    }

}
