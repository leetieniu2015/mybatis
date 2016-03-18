package org.lee.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lee.model.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserMapperDaoTest {
	
	@Autowired
	private UserMapperDao userMapperDao;
	
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
		user.setMemberId(2l);
		user.setMobile("15650728483");
		user.setUserName("leetieniu");
		
		System.out.println(userMapperDao.addUser(user));
	}
	
}