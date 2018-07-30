package com.it.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.it.dao.BaseDao;
import com.it.dao.shoe_typeDao;
import com.it.entity.shoe;
import com.it.entity.shoe_type;
import com.it.util.DatabaseUtil;

public class shoe_typeImpl extends BaseDao implements shoe_typeDao{
	public shoe_typeImpl(){}
	public shoe_typeImpl(Connection conn){
		super(conn);
	}
	@Override
	public List<shoe> select(shoe_type st) {
		List<shoe> list = new ArrayList<shoe>();
		ResultSet rs = null;
		String sql = "select s_t_typeid from shoe_type where s_t_typename=?";
		rs = this.executeQuery(sql, st.getName());
		try {
			while(rs.next()){
				shoe s = new shoe();
				s.setTtypeid(rs.getInt(1));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}	
}
