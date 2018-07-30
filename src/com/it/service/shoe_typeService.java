package com.it.service;
import java.sql.ResultSet;
import java.util.List;

import com.it.entity.shoe;
import com.it.entity.shoe_type;

public interface shoe_typeService {
	List<shoe> select(shoe_type st);
}
