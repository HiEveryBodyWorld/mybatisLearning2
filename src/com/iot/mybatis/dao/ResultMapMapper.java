package com.iot.mybatis.dao;

import java.util.List;

import com.iot.mybatis.po.Orders;

public interface ResultMapMapper {
	
	public List<Orders> findOrdersUserResultMap()throws Exception;
	public List<Orders>  findOrdersAndOrderDetailResultMap()throws Exception;

}
