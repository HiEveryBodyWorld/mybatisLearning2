package com.iot.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.iot.mybatis.dao.ResultMapMapper;
import com.iot.mybatis.po.Orders;

public class ResultMapMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setup() throws Exception {
		// 创建SqlSessionFactory
		String resource = "SqlMapConfig.xml";

		// 将配置文件加载成流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis配置文件的信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 创建UserMapper代理对象
		ResultMapMapper userMapper = sqlSession.getMapper(ResultMapMapper.class);

		// 调用userMapper的方法
		List<Orders> oc = userMapper.findOrdersAndOrderDetailResultMap();

		for(Orders orc:oc){
			
			System.out.println(orc.getId()+"-----"+orc.getNote()+"--------"+orc.getUser().getUsername()+"--------"+orc.getOrderdetails().size());
		}
		sqlSession.close();
	}

}