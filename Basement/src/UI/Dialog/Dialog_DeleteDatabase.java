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

/*
 * Dialog_DeleteDatabase.java
 *
 * Created on Jun 8, 2010, 10:49:42 PM
 */

package UI.Dialog;

/**
 *
 * @author hangfeifei
 */
public class Dialog_DeleteDatabase extends javax.swing.JFrame {
    private String dbContainer = null;
    private String database = null;
    private UI.HomeScreen main = null;
    private UI.Panel.Panel_Template panel = null;

    /** Creates new form Dialog_DeleteDatabase */
    public Dialog_DeleteDatabase( String database, String name ) {
        this.dbContainer = database;
        this.database = name;
        this.setResizable( false );
        initComponents();
        this.Label_Info.setText( this.Label_Info.getText() + name + "\"?" );
    }

    public Dialog_DeleteDatabase( javax.swing.JPanel panel, String database, String name ) {
        this( database, name );
        this.panel = (UI.Panel.Panel_Template)panel;
    }

    public Dialog_DeleteDatabase( UI.HomeScreen homeScreen, String database, String name ) {
        this( database, name );
        this.main = homeScreen;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label_Info = new javax.swing.JLabel();
        Button_Fire = new javax.swing.JButton();
        Button_Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Delete A Database...");

        Label_Info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Info.setText("Are you sure you want to remove \"");

        Button_Fire.setText("Fire");
        Button_Fire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_FireActionPerformed(evt);
            }
        });

        Button_Cancel.setText("Cancel");
        Button_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(Button_Fire, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Button_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Label_Info, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_Info, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Cancel)
                    .addComponent(Button_Fire))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_FireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_FireActionPerformed
        if( new Ctrl.DeleteDatabase().Fire( this.dbContainer + "/" + this.database ) ) {
            try {
                if( this.panel == null ) {
                    this.main.initialDatabase( this.dbContainer );
                }
                else {
                    this.panel.updateContents( this.dbContainer.substring( 0, this.dbContainer.lastIndexOf( "/" ) ) );
                }
            } catch( Exception excpt ) {
                // handle exception
            }
            this.dispose();
        }
        else {
            javax.swing.JOptionPane.showMessageDialog( this, "Unable to delete database.", "Error", 0 );
        }
    }//GEN-LAST:event_Button_FireActionPerformed

    private void Button_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_Button_CancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Cancel;
    private javax.swing.JButton Button_Fire;
    private javax.swing.JLabel Label_Info;
    // End of variables declaration//GEN-END:variables

}
