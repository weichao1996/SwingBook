/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch09;
//--1导入包
import java.sql.*;
import java.util.*;

public class DBCon {
    //创建数据库连接的方法(JDBC)
    public static Connection JDBCon(){
        try{
            //--2 加载驱动程序
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // --3 创建连接
              String url="jdbc:sqlserver://localhost:1433; databaseName=BookDB";
              Connection conn=DriverManager.getConnection(url,"sa","123");
              System.out.println("数据库连接成功");
              return conn;
        }catch(ClassNotFoundException ex){
            System.out.println("数据库驱动程序找不到");
            return null;
        }catch(SQLException ex){
            System.out.println("数据库连接失败");
            ex.printStackTrace();
            return null;
        }
    }
 /*    //--查询数据的方法
    public static Vector queryData(String sql){
        Connection conn=JDBCon();
        try{
            //创建会话对象
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            Vector data=new Vector();
            while(rs.next()){
                String BookID=rs.getObject(1).toString();
                String BookName=rs.getObject(2).toString();
                String Author=rs.getObject(3).toString();
                String Press=rs.getObject(4).toString();
                String PressDate=rs.getObject(5).toString();
                String Status=rs.getObject(6).toString();
                Book book=new Book(BookID,BookName,Author,Press,PressDate,Status);
                data.add(book);
            }
            rs.close();
            stmt.close();
            conn.close();
            return data;
        }catch(SQLException ex){
            System.out.println("数据访问失败");
            ex.printStackTrace();
            return null;
        }
    }

*/
    //--查询数据的方法(二维的Vector)
    public static Vector queryVectorData(String sql){
        Connection conn=JDBCon();
        try{
            //创建会话对象
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            Vector data=new Vector();
            while(rs.next()){
                Vector line=new Vector();
                for(int i=1; i<=6;i++){
                    line.add(rs.getString(i));
                }
                data.add(line);
            }
            //关闭
            rs.close();
            stmt.close();
            conn.close();
            return data;
        }catch(SQLException ex){
            System.out.println("数据访问失败");
            ex.printStackTrace();
            return null;
        }
    }
    
    //--更新数据的方法(insert,update,delete)
    public static boolean updateData(String sql){
        Connection conn=JDBCon();
        try{
            //创建会话对象
            Statement stmt=conn.createStatement();
            //执行SQL语句，返回受影响的行数
            int r=stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            if(r>0){
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println("数据更新失败");
            ex.printStackTrace();
            return false;
        }
    }
}
