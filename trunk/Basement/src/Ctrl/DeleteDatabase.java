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
