package com.it.service;

import java.util.List;

import com.it.entity.shoe;

public interface shoeService {
	int insert(shoe s);
	List<shoe> select(shoe s);
	int update(shoe s);//更新人气
	List<shoe> selectMoods(shoe s);//查询人气
}
