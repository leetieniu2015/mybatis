package org.leetieniu.mybatis.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.leetieniu.mybatis.mapper.UserMapper;
import org.leetieniu.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "spring-mybatis.xml")
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapperDao;
	
	@Test
	public void testGetUserByMemberId() {
		final int memberId = 2;
		
		final User user = userMapperDao.getUserByMemberId(memberId);
		System.out.println(user);
	}
	
	@Test
	public void testGetUserList() {
		final List<User> list = userMapperDao.getUserList();
		
		for(User user : list) {
			System.out.println(user);
		}
	}
	
	@Test 
	public void addUser() {
		final User user = new User();
		user.setMemberId(3l);
		user.setMobile("15650728483");
		user.setUserName("leetieniu");
		
		Assert.assertTrue(userMapperDao.addUser(user) > 0);
	}
	
	@Test
	public void testUpdateUserByMemberId() {
		final User user = new User();
		user.setMemberId(1l);
		user.setMobile("15650728482");
		user.setUserName("leetieniu");
		Assert.assertTrue(userMapperDao.updateUserByMemberId(user) > 0);
	}
	
	@Test 
	public void testDeleteUserByMemberId() {
		final int memberId = 1;
		Assert.assertTrue(userMapperDao.deleteUserByMemberId(memberId) > 0);
	}
	
}