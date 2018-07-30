package com.it.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.it.dao.shoe_typeDao;
import com.it.daoImpl.shoe_typeImpl;
import com.it.entity.shoe;
import com.it.entity.shoe_type;
import com.it.service.shoe_typeService;
import com.it.util.DatabaseUtil;

public class shoe_typeServiceImpl implements shoe_typeService{
	Connection conn = null;
	@Override
	public List<shoe> select(shoe_type st) {
		List<shoe> list = new ArrayList<shoe>();
		try {
			conn = DatabaseUtil.getConnection();
			shoe_typeDao stype = new shoe_typeImpl(conn);
			list = stype.select(st);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(conn, null, null);
		}
		return list;
	}
}
