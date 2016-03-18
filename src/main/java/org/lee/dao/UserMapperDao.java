package org.lee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.lee.model.pojo.User;

public interface UserMapperDao {
	
	@Select("SELECT memberId, mobile, userName FROM user WHERE memberId = #{memberId}")
	public User getUserByMemberId(@Param("memberId") int memberId);
	
	@Select("SELECT memberId, mobile, userName FROM user ")
	public List<User> getUserList();
	
	@Insert("insert into user values(#{memberId}, #{mobile}, #{userName})")
	public int addUser(User user);
	
}
