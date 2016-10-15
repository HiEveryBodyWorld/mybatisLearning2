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
		// ����SqlSessionFactory
		String resource = "SqlMapConfig.xml";

		// �������ļ����س���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����������mybatis�����ļ�����Ϣ
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����UserMapper�������
		Mapper userMapper = sqlSession.getMapper(Mapper.class);

		// ����userMapper�ķ���
		List<OrdersCustom> oc = userMapper.findOrdersUser();

		for(OrdersCustom orc:oc){
			
			System.out.println(orc.getUserId()+"----"+orc.getUsername());
		}
		sqlSession.close();
	}

}