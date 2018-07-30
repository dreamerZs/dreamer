package com.it.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.it.dao.BaseDao;
import com.it.dao.shoeDao;
import com.it.entity.shoe;
import com.it.util.DatabaseUtil;

public class shoeImpl extends BaseDao implements shoeDao{
	public shoeImpl(Connection conn){
		super(conn);
	}
	public shoeImpl(){}
	@Override
	public int insert(shoe s) {
		String sql ="";
		return 0;
	}

	@Override
	public List<shoe> select(shoe s) {
		ResultSet rs = null;
		List<shoe> list = new ArrayList<shoe>();
		String sql = "SELECT i_name,i_price,i_moods,i_path FROM shoe_info WHERE s_t_typeid=? and s_s_id = 3";
		rs = this.executeQuery(sql, s.getTtypeid());
		try {
			while(rs.next()){
				shoe ss = new shoe();
				ss.setName(rs.getString(1));
				ss.setPrice(rs.getDouble(2));
				ss.setMoods(rs.getInt(3));
				ss.setPath(rs.getString(4));
				list.add(ss);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int update(shoe s) {
		int result =0;
		String sql= "update shoe_info set i_moods = ?+1 where i_name = ?";
		result = this.executeUpdate(sql, s.getMoods(),s.getName());
		return result;
	}
	@Override
	public List<shoe> selectMoods(shoe s) {
		List<shoe> list = new ArrayList<shoe>();
		String sql = "select i_moods from shoe_info where i_name = ?";
		ResultSet rs = this.executeQuery(sql,s.getName());
		try {
			while(rs.next()){
				shoe ss = new shoe();
				ss.setMoods(rs.getInt(1));
				list.add(ss);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
