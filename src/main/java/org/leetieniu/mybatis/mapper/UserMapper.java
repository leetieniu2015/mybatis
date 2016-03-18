package org.leetieniu.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.leetieniu.mybatis.model.User;

public interface UserMapper {
	
	@Select("SELECT memberId, mobile, userName FROM user WHERE memberId = #{memberId}")
	public User getUserByMemberId(@Param("memberId") Integer memberId);
	
	@Select("SELECT memberId, mobile, userName FROM user ")
	public List<User> getUserList();
	
	@Insert("insert into user values(#{memberId}, #{mobile}, #{userName})")
	public int addUser(User user);
	
	@Delete(value = "delete from user where memberId = #{memberId}")
	public int deleteUserByMemberId(@Param("memberId") Integer memberId);
	
	@Update(value = "update user set mobile = #{mobile}, userName = #{userName} where memberId = #{memberId}")
	public int updateUserByMemberId(User user);
	
}
