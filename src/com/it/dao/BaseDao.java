package com.it.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.it.util.DatabaseUtil;

/**
 * 通用的增删改查方法的公共类
 * 
 * @author Administrator
 * 
 */
public class BaseDao {
	private Connection conn;
    
    public BaseDao(Connection conn) {
        this.conn = conn;
    }
    public BaseDao(){
    	
    }
	/**
	 * 增删改通用方法
	 * 
	 * @return
	 */
	public int executeUpdate(String sql, Object... params) {// 根据你传入的sql参数来执行不同不同的sql操作
		// 返回单条受影响的行数
		int result = 0;
		// 执行sql语句的对象
		PreparedStatement pstm = null;//执行sql语句的对象
		try {
			pstm = conn.prepareStatement(sql);// 执行sql
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pstm.setObject(i + 1, params[i]);// 拼接sql参数的
				}
			}
			result = pstm.executeUpdate();//执行更新语句
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 通用的查询方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet executeQuery(String sql, Object... params){
		ResultSet rs = null;//结果集对象
		// 执行sql语句的对象
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);// 执行sql
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pstm.setObject(i + 1, params[i]);// 拼接sql参数的
				}
			}
			rs = pstm.executeQuery();//执行更新语句
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
