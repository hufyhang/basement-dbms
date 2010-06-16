/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UI.Theme;

/**
 *
 * @author HANG Feifei
 */
public class Themes {

    private static final String windows = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    private static final String metal = "javax.swing.plaf.metal.MetalLookAndFeel";
    private static final String motif = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    private static final String gtk = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
    private static final String nimbus = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";

    public static void setLookAndFeel( String LookAndFeel ) {
        try {
            javax.swing.UIManager.setLookAndFeel( LookAndFeel );
        } catch( Exception excpt )
        {
            // handle exception
        }
    }

    public static String getWindows() { return windows; }
    public static String getMetal() { return metal; }
    public static String getMotif() { return motif; }
    public static String getGtk() { return gtk; }
    public static String getNimbus() { return nimbus; }

}
