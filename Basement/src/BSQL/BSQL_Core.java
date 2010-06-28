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

package BSQL;

import java.util.*;
import java.io.*;

/**
 *
 * @author hangfeifei
 */
public class BSQL_Core {
    private static final String EXPRESSION_OPERATORS = "[=<>#]";

    private static final int OPERATION_NULL = -1;
    private static final int OPERATION_CREATE = 0;
    private static final int OPERATION_INSERT = 1;
    private static final int OPERATION_REMOVE = 2;
    private static final int OPERATION_UPDATE = 3;
    private static final int OPERATION_SELECT = 4;

    private static ArrayList selectFeedback = new ArrayList<String>();

    public static boolean BSQL_Expresion( String path, String BSQL ) {
        boolean result = false;
        String[] SQLs = BSQL.split( "\n" );
        String[] operation = SQLs[0].split( " " );
        switch( getOperation( operation[0] ) ) {
            case OPERATION_CREATE:
                result = new BSQL_Core().create_table( path, operation[2], SQLs );
                break;

            case OPERATION_INSERT:
                result = new BSQL_Core().insert_record( path, operation[1], SQLs );
                break;

            case OPERATION_REMOVE:
                result = new BSQL_Core().remove_record( path, operation[1], SQLs );
                break;
            
            case OPERATION_UPDATE:
                result = new BSQL_Core().update_record( path, operation[1], SQLs );
                break;

            case OPERATION_SELECT:
                result = new BSQL_Core().select_record( path, operation[1], SQLs );
                break;

            default:
                break;
        }
        return result;
    }

    protected static int getOperation( String operation ) {
        int result = OPERATION_NULL;
        String line = operation.toUpperCase();
        if( line.equals( "CREATE" ) ) {
             result = OPERATION_CREATE;
        } else if( line.equals( "INSERT" ) ) {
            result = OPERATION_INSERT;
        }
        else if( line.equals( "REMOVE" ) ) {
            result = OPERATION_REMOVE;
        }
        else if( line.equals( "UPDATE" ) ) {
            result = OPERATION_UPDATE;
        }
        else if( line.equals( "SELECT" ) ) {
            result = OPERATION_SELECT;
        }
        return result;
    }

    protected String[] getContentsFromFile( String path, int grabLinesFrom ) {
        String[] lines = null;
        ArrayList list = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader( new FileReader( path ) );
            String line = null;
            while( ( line = reader.readLine() ) != null ) {
                list.add( line );
            }
            reader.close();

            lines = new String[ list.size() ];
            for( int index = grabLinesFrom; index != lines.length; ++index ) {
                lines[index] = list.get( index ).toString();
            }
        } catch ( Exception excpt ) {
            excpt.printStackTrace();
            return null;
        }
        return lines;
    }

    protected boolean processExpression( char operator, String current_string, String target ) {
        boolean result = false;
        try {
            switch( operator ) {
                case '=':
                    if( current_string.equals( target ) ) { result = true; }
                    break;
                
                case '#':
                    if( !current_string.equals( target ) ) { result = true; }
                    break;

                case '<':
                    if(  Float.parseFloat( current_string ) < Float.parseFloat( target )) { return result = true; }
                    break;

                case '>':
                    if( Float.parseFloat( current_string ) > Float.parseFloat( target ) ) { return result = true; }
                    break;

                default:
                    break;
            }
        } catch ( java.lang.NumberFormatException excpt ) {
            // handle exception
        }
        return result;
    }

    public static ArrayList getFeedback() {
        return selectFeedback;
    }

    protected boolean select_record( String path, String tableName, String[] BSQL ) {
        String BSQL_Header = BSQL[0].substring( BSQL[0].indexOf( " " ) + 1, BSQL[0].lastIndexOf( " " ) );
        BSQL_Header = BSQL_Header.substring( BSQL_Header.indexOf( "." ) + 1 );
        tableName = tableName.substring( 0, tableName.lastIndexOf( "." ) );
        String[] targetColumns = BSQL_Header.split( "[,]" );
        for( int index = 0; index != targetColumns.length; ++index ) {
            while( targetColumns[index].charAt(0) == ' ' ) {
                targetColumns[index] = targetColumns[index].substring( 1 );
            }
            while( targetColumns[index].charAt(targetColumns[index].length() - 1) == ' ' ) {
                targetColumns[index] = targetColumns[index].substring( 0, targetColumns[index].length() - 2 );
            }
        }
        ArrayList targetColumnIDs = new ArrayList<Integer>();
        for( String column : targetColumns ) {
            targetColumnIDs.add( this.getColumnID( path + "/" + tableName, column ) );
        }
        selectFeedback.clear();
        try{
            String data = path + "/" + tableName + "/data.bsmt";
            String[][] rawData = null;
            String[] lines = this.getContentsFromFile( data, 0 );

            for( int BSQLIndex = 1; BSQLIndex != BSQL.length; ++BSQLIndex ) {
                String[] SQL = new String[2];
                SQL = BSQL[BSQLIndex].split( EXPRESSION_OPERATORS );
                char operator = BSQL[BSQLIndex].charAt( SQL[0].length() );
                int targetExpressionItemID = this.getColumnID( path + "/" + tableName, SQL[0] );

                String header = path + "/" + tableName;
                int columns = this.getColumnNumber( header );
                int rows = lines.length / columns;
                rawData = new String[rows][columns];
                int total = 0;
                ArrayList targets = new ArrayList<String>();
                for( int index = 0; index != rows; ++index ) {
                    for( int subIndex = 0; subIndex != columns; ++ subIndex ) {
                        rawData[index][subIndex] = lines[total++];
                        if( subIndex == targetExpressionItemID && this.processExpression( operator,
                                                    rawData[index][subIndex], SQL[1].substring( 0, SQL[1].length() - 1 ) ) ) {
                            targets.add( String.valueOf( index ) );
                        }
                    }
                }

                total = 0;
                for( int index = 0; index != targets.size(); ++index ) {
                    for( int subIndex = 0; subIndex != targetColumnIDs.size(); ++subIndex ) {
                        selectFeedback.add( rawData[ Integer.parseInt( targets.get( index ).toString() ) ]
                                [ Integer.parseInt( targetColumnIDs.get( subIndex ).toString() ) ] );
                    }
                }

            }
        } catch ( Exception excpt ) {
            excpt.printStackTrace();
            return false;
        }
        return true;
    }

    protected boolean update_record( String path, String tableName, String[] BSQL ) {
        String[] values = BSQL[0].split( " " );
        String value = new String();
        for( int index = 3; index != values.length - 1; ++index ) {
                value += values[index] + " ";
        }
        value = value.substring( 0, value.length() - 1 );
        String[] args = tableName.split( "\\." ); // eg: UPDATA My_Table.ID : ...
        tableName = args[0];

        try {
            String data = path + "/" + tableName + "/data.bsmt";
            String[][] rawData = null;
            String[] lines = this.getContentsFromFile( data, 0 );

            int targetColumnID = this.getColumnID( path + "/" + tableName, args[1] );

            for( int BSQLIndex = 1; BSQLIndex != BSQL.length; ++BSQLIndex ) {
                String[] SQL = new String[2];
                SQL = BSQL[BSQLIndex].split( EXPRESSION_OPERATORS );
                char operator = BSQL[BSQLIndex].charAt( SQL[0].length() );
                int targetExpressionItemID = this.getColumnID( path + "/" + tableName, SQL[0] );

                String header = path + "/" + tableName;
                int columns = this.getColumnNumber( header );
                int rows = lines.length / columns;
                rawData = new String[rows][columns];
                int total = 0;
                ArrayList targets = new ArrayList<String>();
                for( int index = 0; index != rows; ++index ) {
                    for( int subIndex = 0; subIndex != columns; ++ subIndex ) {
                        rawData[index][subIndex] = lines[total++];
                        if( subIndex == targetExpressionItemID && this.processExpression( operator,
                                                    rawData[index][subIndex], SQL[1].substring( 0, SQL[1].length() - 1 ) ) ) {
                            targets.add( String.valueOf( index ) );
                        }
                    }
                }

                total = 0;
                ArrayList list = new ArrayList<String>();
                for( int index = 0; index != rows; ++index ) {
                    for( int subIndex = 0; subIndex != columns; ++subIndex ) {
                        if( subIndex == targetColumnID && targets.contains( String.valueOf( index ) ) ) {
                            list.add( value );
                        }
                        else {
                            list.add( rawData[index][subIndex] );
                        }

                    }
                }

                lines = new String[ list.size() ];
                for( int index = 0; index != lines.length; ++index ) {
                    lines[index] = list.get(index).toString();
                }

                BufferedWriter writer = new BufferedWriter( new FileWriter( data ) );
                for( int index = 0; index != lines.length; ++index ) {
                    writer.write( lines[index] + "\n" );
                }
                writer.close();
            }
        } catch ( Exception excpt ) {
            excpt.printStackTrace();
            return false;
        }
        return true;

    }

    protected boolean remove_record( String path, String tableName, String[] BSQL ) {
        try {
            String data = path + "/" + tableName + "/data.bsmt";
            String[][] rawData = null;
            String[] lines = this.getContentsFromFile( data, 0 );

            for( int BSQLIndex = 1; BSQLIndex != BSQL.length; ++BSQLIndex ) {
                String[] SQL = new String[2];
                SQL = BSQL[BSQLIndex].split( EXPRESSION_OPERATORS );
                int targetExpressionItemID = this.getColumnID( path + "/" + tableName, SQL[0] );
                char operator = BSQL[BSQLIndex].charAt( SQL[0].length() );

                String header = path + "/" + tableName;
                int columns = this.getColumnNumber( header );
                int rows = lines.length / columns;
                rawData = new String[rows][columns];
                int total = 0;
                ArrayList targetRow = new ArrayList<Integer>();
                for( int index = 0; index != rows; ++index ) {
                    for( int subIndex = 0; subIndex != columns; ++ subIndex ) {
                        rawData[index][subIndex] = lines[total++];
                        if( subIndex == targetExpressionItemID && this.processExpression( operator,
                                                rawData[index][subIndex], SQL[1].substring( 0, SQL[1].length() - 1 ) ) ) {
                            targetRow.add( index );
                        }
                    }
                }
                
                total = 0;
                ArrayList list = new ArrayList<String>();
                for( int index = 0; index != rows; ++index ) {
                    if( !targetRow.contains( index ) ) {
                        for( int subIndex = 0; subIndex != columns; ++subIndex ) {
                            list.add( rawData[index][subIndex] );
                        }
                    }
                }

                lines = new String[ list.size() ];
                for( int index = 0; index != lines.length; ++index ) {
                    lines[index] = list.get(index).toString();
                }

                BufferedWriter writer = new BufferedWriter( new FileWriter( data ) );
                for( int index = 0; index != lines.length; ++index ) {
                    writer.write( lines[index] + "\n" );
                }
                writer.close();
            }
        } catch ( Exception excpt ) {
            excpt.printStackTrace();
            return false;
        }
        return true;
    }

    protected int getColumnNumber( String path ) {
        path += "/header.bsmt";
        String[] lines = this.getContentsFromFile( path, 0 );
        return lines.length;
    }

    protected int getColumnID( String path, String content ) {
        int result = -1;
        path += "/header.bsmt";
        String[] lines = this.getContentsFromFile( path, 0 );
        for( int index = 0; index != lines.length; ++index ) {
            if( lines[index].equals( content ) ) {
                result = index;
            }
        }
        return result;
    }

    protected boolean insert_record( String path, String tableName, String[] BSQL ) {
        path += "/" + tableName + "/data.bsmt";
        try{
            BufferedWriter writer= new BufferedWriter( new FileWriter( path, true ) );
            for( int index = 1; index != BSQL.length; ++index ) {
                writer.write( BSQL[index].substring( 0, BSQL[index].length() - 1 ) + "\n" );
            }
            writer.close();
        } catch ( Exception excpt ) {
            excpt.printStackTrace();
            return false;
        }
        return true;
    }

    protected boolean create_table( String path, String tableName, String[] BSQL ) {
        path += "/" + tableName;
        try {
            File dir = new File( path );
            if( !dir.mkdir() ){ return false; }
            String header = path + "/header.bsmt";
            dir = new File( header );
            if( !dir.createNewFile() ) { return false; }
            String data = path + "/data.bsmt";
            dir = new File( data );
            if( !dir.createNewFile() ) { return false; }
            BufferedWriter writer = new BufferedWriter( new FileWriter( header ) );
            for( int index = 1; index != BSQL.length; ++index ) {
                String line = BSQL[index].substring( 0, BSQL[index].length() - 1 ) + "\n";
                writer.write( line );
            }
            writer.close();
        } catch ( Exception excpt ) {
            excpt.printStackTrace();
            return false;
        }
        return true;
    }

}
