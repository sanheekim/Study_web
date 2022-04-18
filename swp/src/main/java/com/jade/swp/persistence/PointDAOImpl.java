package com.jade.swp.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO {
	@Inject
	SqlSession session;
	
	private static final String NS = "com.jade.swp.persistence.PointMapper";
	private static final String UPDATE_POINT = NS + ".updatePoint";

	@Override
	public void updatePoint(String uid, Integer point) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("uid", uid);
		paramMap.put("point", point);
		session.update(UPDATE_POINT, paramMap);
	}

}
