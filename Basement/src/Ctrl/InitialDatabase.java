/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Ctrl;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author hangfeifei
 */
public class InitialDatabase implements Ctrl.CtrlInterface {

    public boolean Fire() { return true; }

    public static ArrayList getDatabase( String DBContainer ) {
        ArrayList list = new ArrayList<String>();
        File dir = new File( DBContainer );
        for( File item : dir.listFiles() ) {
            if( item.isDirectory() ) {
                list.add( item.getName() );
            }
        }
        return list;
    }
}
