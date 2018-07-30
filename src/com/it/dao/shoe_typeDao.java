package com.it.dao;

import java.sql.ResultSet;
import java.util.List;

import com.it.entity.shoe;
import com.it.entity.shoe_type;

public interface shoe_typeDao {
	List<shoe> select(shoe_type st);
}
