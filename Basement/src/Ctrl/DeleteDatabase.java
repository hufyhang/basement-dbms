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
public class DeleteDatabase implements Ctrl.CtrlInterface {
    public boolean Fire() { return true; }
    public boolean Fire( String database ) {
        if( this.deleteDatabase( database ) ) {
            return true;
        }
        else {
            return false;
        }
    }

    protected boolean deleteDatabase( String path ) {
        try{
            File dir = new File( path );
            for( File item : dir.listFiles() ) {
                if( item.isFile() ) { 
                    item.delete(); 
                }
                else {
                    this.deleteDatabase( item.getAbsolutePath() );
                    item.delete();
                }
            }
            dir.delete();
        } catch( Exception excpt ) {
            return false;
        }
        return true;
    }
}
