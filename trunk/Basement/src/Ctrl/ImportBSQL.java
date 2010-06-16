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
