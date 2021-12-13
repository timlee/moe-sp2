package nknu.lab_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * Test query class for all users
 *
 */
public class DBQueryAll {
    private String database_server = "127.0.0.1";
    
    public void testQueryAll(){
        Connection conn= null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1.Registration driver
            Class.forName("com.mysql.jdbc.Driver");
            //2.Get connection
            String url ="jdbc:mysql://"+database_server+":3306/mybase";
            String username="root";
            String password="root";
            conn = DriverManager.getConnection(url,username,password);
            //3.Get execution sql Statement object
            stmt = conn.createStatement();
            //4.To write sql Sentence
            String sql = "select * from user";
            //5.implement sql Sentence
            rs = stmt.executeQuery(sql);
            //6.Process result set
            while(rs.next()){
                System.out.println("user name:"+rs.getString(2)+" password:"+rs.getString("upassword"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(stmt!=null)
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if(conn!=null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}