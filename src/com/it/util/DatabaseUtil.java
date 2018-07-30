package com.it.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.*;
import javax.sql.DataSource;

/**
 * 数据库连接与关闭工具类。
 * 
 * @author 北大青鸟
 */
public class DatabaseUtil {
    /**
     * 获取数据库连接对象。
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
        // 获取连接并捕获异常
        Connection conn = null;
    	try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/shoe");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}      
        return conn;// 返回连接对象
    }

    /**
     * 关闭数据库连接。
     * 
     * @param conn
     *            数据库连接
     * @param stmt
     *            Statement对象
     * @param rs
     *            结果集
     */
    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        // 若结果集对象不为空，则关闭
        try {
            if (rs != null && !rs.isClosed())
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 若Statement对象不为空，则关闭
        try {
            if (stmt != null && !stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 若数据库连接对象不为空，则关闭
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
