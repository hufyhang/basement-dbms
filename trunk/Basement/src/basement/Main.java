/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package basement;

/**
 *
 * @author HANG Feifei
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UI.WelcomeScreen main = new UI.WelcomeScreen();
        Ctrl.ShowDialog.ShowDialog( main );
    }
}
