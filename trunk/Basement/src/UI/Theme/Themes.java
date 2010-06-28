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
