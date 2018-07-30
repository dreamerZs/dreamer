package com.it.dao;

import java.util.List;

import com.it.entity.shoe;

public interface shoeDao {
	int insert(shoe s);//插入数据
	List<shoe> select(shoe s);//查询数据
	int update(shoe s);//更新人气
	List<shoe> selectMoods(shoe s);//查询人气
}
