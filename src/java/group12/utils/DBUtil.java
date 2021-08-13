/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group12.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ASUS-PC
 */
public class DBUtil{
    public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
        Connection conn = null;
        Context context = new InitialContext();
        Context end = (Context)context.lookup("java:comp/env");
        DataSource ds = (DataSource)end.lookup("DBCon");
        conn = ds.getConnection();       
        return conn;
    }
}
