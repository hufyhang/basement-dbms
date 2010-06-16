/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WelcomeScreen.java
 *
 * Created on Jun 8, 2010, 3:11:22 PM
 */

package UI;

/**
 *
 * @author hangfeifei
 */
public class WelcomeScreen extends javax.swing.JFrame {

    /** Creates new form WelcomeScreen */
    public WelcomeScreen() {
        this.setDefaultCloseOperation( javax.swing.JFrame.EXIT_ON_CLOSE );
        UI.Theme.Themes.setLookAndFeel( javax.swing.UIManager.getSystemLookAndFeelClassName() );
        initComponents();
        this.TextField_Database.setText( this.getDefaultPath() );
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ComboBox_LookFeel = new javax.swing.JComboBox();
        Button_Fire = new javax.swing.JButton();
        Button_Cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TextField_Database = new javax.swing.JTextField();
        Button_Folder_Selector = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Spinner_Port = new javax.swing.JSpinner();
        CheckBox_Workoffline = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome to Basement");
        setResizable(false);

        jLabel1.setText("Look & Feel:");

        ComboBox_LookFeel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GTK+", "Metal", "Motif", "Nimbus", "MS Windows", "System" }));
        ComboBox_LookFeel.setSelectedIndex(3);

        Button_Fire.setText("Fire");
        Button_Fire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_FireActionPerformed(evt);
            }
        });

        Button_Cancel.setText("Exit");
        Button_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CancelActionPerformed(evt);
            }
        });

        jLabel2.setText("Database Container:");

        Button_Folder_Selector.setText("...");
        Button_Folder_Selector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_Folder_SelectorActionPerformed(evt);
            }
        });

        jLabel3.setText("Connections Port:");

        Spinner_Port.setModel(new javax.swing.SpinnerNumberModel(10123, 3000, 50000, 1));

        CheckBox_Workoffline.setText("Work Offline");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Button_Fire, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextField_Database, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_Folder_Selector, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Spinner_Port, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(ComboBox_LookFeel, javax.swing.GroupLayout.Alignment.TRAILING, 0, 156, Short.MAX_VALUE)))
                    .addComponent(CheckBox_Workoffline, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextField_Database, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Folder_Selector))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Spinner_Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox_LookFeel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CheckBox_Workoffline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Fire)
                    .addComponent(Button_Cancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected String getDefaultPath() {
        return System.getProperty( "user.dir" )  + "/MyBasement";
    }

    protected String getLookAndFeel( int index ) {
        String lookFeel = null;
        switch ( index ) {
            case 0:
                lookFeel = UI.Theme.Themes.getGtk();
                break;

            case 1:
                lookFeel = UI.Theme.Themes.getMetal();
                break;

            case 2:
                lookFeel = UI.Theme.Themes.getMotif();
                break;

            case 3:
                lookFeel = UI.Theme.Themes.getNimbus();
                break;

            case 4:
                lookFeel = UI.Theme.Themes.getWindows();
                break;

            default:
                lookFeel = javax.swing.UIManager.getSystemLookAndFeelClassName();
                break;
        }
        return lookFeel;
    }

    private void Button_Folder_SelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_Folder_SelectorActionPerformed
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser( "." );
        chooser.setFileSelectionMode( javax.swing.JFileChooser.DIRECTORIES_ONLY );
        chooser.setDialogTitle( "Please identify database container for Basement..." );
        int result = chooser.showOpenDialog( null );
        if( result == javax.swing.JFileChooser.APPROVE_OPTION ) {
            this.TextField_Database.setText( chooser.getSelectedFile().getAbsolutePath() );
        }
    }//GEN-LAST:event_Button_Folder_SelectorActionPerformed

    private void Button_FireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_FireActionPerformed
        UI.HomeScreen home = new UI.HomeScreen( this.getLookAndFeel( this.ComboBox_LookFeel.getSelectedIndex() ),
                                                    this.TextField_Database.getText(),
                                                    Integer.parseInt( this.Spinner_Port.getValue().toString() ),
                                                    this.CheckBox_Workoffline.isSelected() );
        home.setExtendedState( javax.swing.JFrame.MAXIMIZED_BOTH );
        Ctrl.ShowDialog.ShowDialog( home );
        this.dispose();
    }//GEN-LAST:event_Button_FireActionPerformed

    private void Button_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CancelActionPerformed
        System.exit( 0 );
    }//GEN-LAST:event_Button_CancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Cancel;
    private javax.swing.JButton Button_Fire;
    private javax.swing.JButton Button_Folder_Selector;
    private javax.swing.JCheckBox CheckBox_Workoffline;
    private javax.swing.JComboBox ComboBox_LookFeel;
    private javax.swing.JSpinner Spinner_Port;
    private javax.swing.JTextField TextField_Database;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

}