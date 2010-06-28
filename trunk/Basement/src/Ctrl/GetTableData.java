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

import java.util.*;
import java.io.*;

/**
 *
 * @author hangfeifei
 */
public class GetTableData implements Ctrl.CtrlInterface {
    private String rawData = null;
    private String separator = "-//-";

    public GetTableData( String rawData ) {
        this.rawData = rawData;
    }

    public boolean Fire(){ return true; }

    public int getColumnLength() {
        int index = 0;
        try{
            BufferedReader reader = new BufferedReader( new FileReader( rawData + "/header.bsmt" ) );
            while( reader.readLine() != null ) {
                ++index;
            }
            reader.close();
        } catch( Exception excpt ) {
            return -1;
        }
        return index;
    }

    public Object[][] getData( int columnLength ) {
        String[][] data = null;
        String line = null;
        int counter = columnLength;
        int rows = 0;
        ArrayList items = new ArrayList<String>();
        ArrayList col = new ArrayList<String>();
        try{
            BufferedReader reader = new BufferedReader( new FileReader( rawData + "/data.bsmt" ) );
            while( ( line = reader.readLine() ) != null ) {
                ++rows;
                items.add( line );
            }
            reader.close();
        } catch( Exception excpt ) {
            return null;
        }
        rows = rows / counter;
        data = new String[rows][counter];
        int total = 0;
        for( int index = 0; index != rows; ++index ) {
            for( int subIndex = 0; subIndex != counter; ++subIndex ) {
                data[index][subIndex] = items.get( total++ ).toString();
            }
        }
        return data;
    }

    public String[] getHeader() {
        String[] data = null;
        String line = null;
        ArrayList list = new ArrayList<String>();
        try{
            BufferedReader reader = new BufferedReader( new FileReader( rawData + "/header.bsmt" ) );
            while( ( line = reader.readLine()) != null ) {
                list.add( line );
            }
            reader.close();
            data = new String[ list.size() ];
            for( int index = 0; index != data.length; ++index ) {
                data[index] = list.get( index ).toString();
            }
        } catch( Exception excpt ) {
            return null;
        }
        return data;
    }
}
