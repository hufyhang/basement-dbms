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

/**
 *
 * @author hangfeifei
 */
public class UpdateDocument implements Ctrl.CtrlInterface {

    public boolean Fire() { return true; }
    public static boolean Fire( javax.swing.JTable table_document, String current_database, String current_table ) {
        try {
            String rawData = current_database + "/" + current_table;
            int length = new Ctrl.GetTableData( rawData ).getColumnLength();
            table_document.setModel( new javax.swing.table.DefaultTableModel(
                                        new Ctrl.GetTableData( rawData ).getData( length ),
                                        new Ctrl.GetTableData( rawData ).getHeader() ) );
        } catch( Exception excpt ) {
            return false;
        }
        return true;
    }

}
