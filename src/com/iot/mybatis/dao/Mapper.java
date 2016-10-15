package com.iot.mybatis.dao;

import java.util.List;

import com.iot.mybatis.po.OrdersCustom;

public interface Mapper {
	
	public List<OrdersCustom> findOrdersUser()throws Exception;
}
