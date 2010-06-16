/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Ctrl;

/**
 *
 * @author hangfeifei
 */
public class ShowDialog implements Ctrl.CtrlInterface {
    public boolean Fire() { return true; }
    public static void ShowDialog( javax.swing.JFrame Dialog ) {
        Dialog.setIconImage( Dialog.getToolkit().getDefaultToolkit().getImage( "ico/icon.png" ) );
        Dialog.setLocation( Dialog.getToolkit().getScreenSize().width/2-Dialog.getWidth()/2,
                Dialog.getToolkit().getScreenSize().height/2-Dialog.getHeight()/2 );
        Dialog.setVisible( true );
        Dialog.pack();
    }
}
