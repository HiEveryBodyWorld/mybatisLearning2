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
		ResultMapMapper userMapper = sqlSession.getMapper(ResultMapMapper.class);

		// ����userMapper�ķ���
		List<Orders> oc = userMapper.findOrdersAndOrderDetailResultMap();

		for(Orders orc:oc){
			
			System.out.println(orc.getId()+"-----"+orc.getNote()+"--------"+orc.getUser().getUsername()+"--------"+orc.getOrderdetails().size());
		}
		sqlSession.close();
	}

}