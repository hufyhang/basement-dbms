/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basement;

/**
 *
 * @author hangfeifei
 */
public class Client_Test {

    public static void main( String[] args ) {
//        String BSQL = "INSERT My_Basement_Table :\n666,\nHANG Feifei,\nMale,\nFeb/23/1988,\n86-13488839832,\nJames Cook University;\n";
        String BSQL = "SELECT Personal_Info.Name :\nAge>20;\n";
        String server = "192.168.1.100";
        int port = 10123;
        String database = "My_Basement_DB";

        new BSQL.Client_Java( server, port ).BSQL_Table( database, BSQL );
    }

}
