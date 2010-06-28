/* Copyright (C) 2009, 2010 HANG Feifei.
   This file is part of the Basement DBMS.

   The Basement DBMS is free software; you can redistribute it and/or
   modify it under the terms of the GNU General Public License as 
   published by the Free Software Foundation; either version 2.1 
   of the License, or (at your option) any later version.

   The Basement DBMS is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU 
   General Public License for more details.

   You should have received a copy of the GNU General Public
   License along with the Basement DBMS; if not, write to the Free
   Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
   02111-1307 USA.  */

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
