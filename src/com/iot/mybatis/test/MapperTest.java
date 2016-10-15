package com.iot.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.iot.mybatis.dao.Mapper;
import com.iot.mybatis.po.OrdersCustom;

public class MapperTest {

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
		Mapper userMapper = sqlSession.getMapper(Mapper.class);

		// 调用userMapper的方法
		List<OrdersCustom> oc = userMapper.findOrdersUser();

		for(OrdersCustom orc:oc){
			
			System.out.println(orc.getUserId()+"----"+orc.getUsername());
		}
		sqlSession.close();
	}

}