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
