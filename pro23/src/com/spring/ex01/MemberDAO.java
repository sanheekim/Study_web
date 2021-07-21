package com.spring.ex01;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	private static SqlSessionFactory sqlMapper=null;
	
	public static SqlSessionFactory getInstance() {
		if(sqlMapper==null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper=new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	public List<HashMap<String, String>> selectAllMemberList(){
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		// List<MemberVO> memlist = null;
		List<HashMap<String, String>> memlist = null;
		memlist=session.selectList("mapper.member.selectAllMemberList");
		return memlist;
	}
}
