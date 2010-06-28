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

package Ctrl;

import java.io.*;

/**
 *
 * @author hangfeifei
 */
public class ImportBSQL implements  Ctrl.CtrlInterface {

    public boolean Fire() { return true; }
    public static boolean Import( javax.swing.JTextArea TextArea_BSQL ) {
        try {
            javax.swing.JFileChooser chooser = new javax.swing.JFileChooser( "." );
            chooser.setDialogTitle( "Import..." );
            chooser.setFileSelectionMode( javax.swing.JFileChooser.FILES_ONLY );
            int result = chooser.showOpenDialog( null );
            if( result == javax.swing.JFileChooser.APPROVE_OPTION ) {
                TextArea_BSQL.setText( null );
                BufferedReader reader = new BufferedReader( new FileReader( chooser.getSelectedFile().getAbsolutePath() ) );
                String line = null;
                while( ( line = reader.readLine() ) != null ) {
                    TextArea_BSQL.setText( TextArea_BSQL.getText() + line + "\n" );
                }
                reader.close();
            }
        } catch ( Exception excpt ) {
            return false;
        }
        return true;
    }

}
