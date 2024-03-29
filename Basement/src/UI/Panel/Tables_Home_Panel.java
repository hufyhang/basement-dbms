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
 * Tables_Home_Panel.java
 *
 * Created on Jun 8, 2010, 3:48:14 PM
 */

package UI.Panel;

import java.util.*;
import java.io.*;

/**
 *
 * @author hangfeifei
 */
public class Tables_Home_Panel extends UI.Panel.Panel_Template {

    private String current_database_tables = null;

    /** Creates new form Tables_Home_Panel */
    public Tables_Home_Panel() {
        initComponents();
    }

    public Tables_Home_Panel( String database ) {
        this();
        try {
            this.getTables( database );
        } catch ( NullPointerException excpt ) {
            // handle exception.
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        Button_Create_Table_Design = new javax.swing.JButton();
        Button_Table_Viewer = new javax.swing.JButton();
        Button_Table_Remove = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        Label_Description = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        List_Tables = new javax.swing.JList();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_Document = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(158, 169, 191)));

        jSplitPane1.setDividerLocation(160);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Button_Create_Table_Design.setText("Create Table in Design View...");
        Button_Create_Table_Design.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button_Create_Table_DesignMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button_Create_Table_DesignMouseExited(evt);
            }
        });
        Button_Create_Table_Design.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_Create_Table_DesignActionPerformed(evt);
            }
        });

        Button_Table_Viewer.setText("View / Update the Selected Table...");
        Button_Table_Viewer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button_Table_ViewerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button_Table_ViewerMouseExited(evt);
            }
        });
        Button_Table_Viewer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_Table_ViewerActionPerformed(evt);
            }
        });

        Button_Table_Remove.setText("Remove the Selected Table...");
        Button_Table_Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button_Table_RemoveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button_Table_RemoveMouseExited(evt);
            }
        });
        Button_Table_Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_Table_RemoveActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        jLabel1.setText("Description");

        Label_Description.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel3.setBackground(new java.awt.Color(158, 169, 191));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("  Tasks");
        jLabel3.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Button_Create_Table_Design, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Table_Viewer, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Table_Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Label_Description, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Button_Create_Table_Design)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Table_Viewer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Table_Remove))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_Description, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        jSplitPane1.setTopComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        List_Tables.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        List_Tables.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                List_TablesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(List_Tables);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        Table_Document.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(Table_Document);

        jScrollPane3.setViewportView(jScrollPane2);

        jLabel4.setBackground(new java.awt.Color(158, 169, 191));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("  Tables");
        jLabel4.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void List_TablesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_List_TablesValueChanged
        try {
            this.setTable_Document();
        } catch ( Exception excpt ) {
            // handle excpetion
        }
    }//GEN-LAST:event_List_TablesValueChanged

    private void Button_Create_Table_DesignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_Create_Table_DesignActionPerformed
        UI.Popup.Table_Create_Designer popup = new UI.Popup.Table_Create_Designer( this, this.current_database_tables );
        Ctrl.ShowDialog.ShowDialog( popup );
    }//GEN-LAST:event_Button_Create_Table_DesignActionPerformed

    private void Button_Table_RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_Table_RemoveActionPerformed
        UI.Dialog.Dialog_DeleteDatabase dialog = new UI.Dialog.Dialog_DeleteDatabase( this, current_database_tables,
                                                                                    this.List_Tables.getSelectedValue().toString() );
        Ctrl.ShowDialog.ShowDialog( dialog );
    }//GEN-LAST:event_Button_Table_RemoveActionPerformed

    public javax.swing.JTable getTable_Document() { return this.Table_Document; }
    public void setTable_Document() {
        if( !Ctrl.UpdateDocument.Fire( this.Table_Document, this.current_database_tables,
                                                            this.List_Tables.getSelectedValue().toString() ) ) {
            new javax.swing.JOptionPane().showMessageDialog( this, "Unable to update document.", "Error", 0 );
        }
    }

    private void Button_Table_ViewerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_Table_ViewerActionPerformed
        try{
            UI.Popup.Table_Update_Viewer popup = new UI.Popup.Table_Update_Viewer( this, this.current_database_tables,
                                                        this.List_Tables.getSelectedValue().toString() );
            Ctrl.ShowDialog.ShowDialog( popup );
        } catch ( Exception excpt ) {
            // handle exception
        }
    }//GEN-LAST:event_Button_Table_ViewerActionPerformed

    private void Button_Create_Table_DesignMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_Create_Table_DesignMouseEntered
        this.Label_Description.setText( "Create a table by using BSQL language or with helps of BSQL Generator." );
    }//GEN-LAST:event_Button_Create_Table_DesignMouseEntered

    private void Button_Create_Table_DesignMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_Create_Table_DesignMouseExited
        this.Label_Description.setText( null );
    }//GEN-LAST:event_Button_Create_Table_DesignMouseExited

    private void Button_Table_ViewerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_Table_ViewerMouseEntered
        this.Label_Description.setText( "View a table in Data Viewer while you can update any record by using BSQL language." );
    }//GEN-LAST:event_Button_Table_ViewerMouseEntered

    private void Button_Table_ViewerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_Table_ViewerMouseExited
        this.Label_Description.setText( null );
    }//GEN-LAST:event_Button_Table_ViewerMouseExited

    private void Button_Table_RemoveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_Table_RemoveMouseEntered
        this.Label_Description.setText( "Remove the selected table from current database." );
    }//GEN-LAST:event_Button_Table_RemoveMouseEntered

    private void Button_Table_RemoveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_Table_RemoveMouseExited
        this.Label_Description.setText( null );
    }//GEN-LAST:event_Button_Table_RemoveMouseExited

    public void updateContents( String database ) {
        int currentSelection = this.List_Tables.getSelectedIndex();
        this.getTables( database );
        this.List_Tables.setSelectedIndex( currentSelection );
    }

    protected void getTables( String databaseTables ) {
        this.current_database_tables = databaseTables + "/Tables";
        this.List_Tables.removeAll();
        ArrayList list = new ArrayList<String>();
        File dir = new File( this.current_database_tables );
        for( File item : dir.listFiles() ) {
            if( item.isDirectory() ) {
                list.add( item.getName() );
            }
        }
        String[] data = new String[ list.size() ];
        for( int index = 0; index != data.length; ++index ) {
            data[index] = list.get( index ).toString();
        }
        this.List_Tables.setListData( data );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Create_Table_Design;
    private javax.swing.JButton Button_Table_Remove;
    private javax.swing.JButton Button_Table_Viewer;
    private javax.swing.JLabel Label_Description;
    private javax.swing.JList List_Tables;
    private javax.swing.JTable Table_Document;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables

}
