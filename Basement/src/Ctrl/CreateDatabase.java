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
public class CreateDatabase implements Ctrl.CtrlInterface {
    public boolean Fire() { return true; }
    public boolean Fire( String database ) {
        if( !this.createDatabase( database ) ) { return false; }
        if( !this.createDatabase( database + "/Tables" ) ) { return false; }
        if( !this.createDatabase( database + "/Views" ) ) { return false; }
        if( !this.createDatabase( database + "/Queries" ) ) { return false; }
        return true;
    }

    protected boolean createDatabase( String path ) {
        File dir = new File( path );
        if( !dir.mkdir() ) { return false; }
        return true;
    }
}
