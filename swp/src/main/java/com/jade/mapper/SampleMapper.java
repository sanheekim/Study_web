package com.jade.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.jade.swp.domain.User;

public interface SampleMapper {
	
	@Select("select now()")
	public String getTime() throws Exception;;

	@Select("select uname from User where uid = #{uid}")
	public String getUname(@Param("uid") String uid) throws Exception;;
	
	public User getLoginInfo(@Param("uid") String uid) throws Exception;
	
	@SelectProvider(type=SampleProvider.class, method="searchUser")
	public List<User> searchUser(@Param("searchCol") String searchCol,
			@Param("searchStr") String searchStr) throws Exception;

	@Update("update User set loginip=#{ip}, lastlogin=now() where uid = #{uid}")
	public void updateLogin(@Param("uid") String uid, @Param("ip") String ip) throws Exception;
}
