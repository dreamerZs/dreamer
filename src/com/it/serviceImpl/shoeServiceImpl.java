package com.it.serviceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.it.dao.shoeDao;
import com.it.daoImpl.shoeImpl;
import com.it.entity.shoe;
import com.it.service.shoeService;
import com.it.util.DatabaseUtil;

public class shoeServiceImpl implements shoeService{
	Connection conn = null;
	@Override
	public int insert(shoe s) {
		int result = 0;
		try {
			conn = DatabaseUtil.getConnection();
			shoeDao pd= new shoeImpl(conn);
			result = pd.insert(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(conn, null, null);
		}
		return result;
	}

	@Override
	public List<shoe> select(shoe s) {
		List<shoe> list = new ArrayList<shoe>();
		try {
			conn = DatabaseUtil.getConnection();
			shoeDao pd= new shoeImpl(conn);
			list = pd.select(s);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DatabaseUtil.closeAll(conn, null, null);
		}		
		return list;
	}

	@Override
	public int update(shoe s) {
		int result = 0;
		try {
			conn = DatabaseUtil.getConnection();
			shoeDao pd= new shoeImpl(conn);
			result = pd.update(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(conn, null, null);
		}
		return result;
	}

	@Override
	public List<shoe> selectMoods(shoe s) {
		List<shoe> list = new ArrayList<shoe>();
		try {
			conn = DatabaseUtil.getConnection();
			shoeDao pd= new shoeImpl(conn);
			list = pd.selectMoods(s);
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(conn, null, null);
		}		
		return list;
	}

}
