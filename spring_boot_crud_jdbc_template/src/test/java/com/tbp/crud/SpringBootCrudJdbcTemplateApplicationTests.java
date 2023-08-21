package com.tbp.crud;

import com.tbp.crud.controller.UserController;
import com.tbp.crud.dao.UserRepository;
import com.tbp.crud.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest
class SpringBootCrudJdbcTemplateApplicationTests {

	@InjectMocks
	private UserController controller;
	@Mock
	private UserRepository repository;

//	@Test
//	public void getAllUsersTest() {
//		when(repository.allUsers()).thenReturn(Stream.of(new User(111, "Brent", "Rivera", 28, "brent@gmail.com"),
//				new User(222, "Ayesha", "Ravath", 23, "ayesha02@gmail.com")).collect(Collectors.toList()));
//		assertEquals(2, controller.getUser().size());
//	}

	@Test
	public void getAllUsersTest() {
	List<User> myUser = new ArrayList<>();
	myUser.add(new User(1,"amritha","kavya",23,"ahahha"));
	myUser.add(new User(2,"atha","kav",23,"ahaffchha"));
	when(repository.allUsers()).thenReturn(myUser);
		assertEquals(2,controller.getUser().size());
	}

		@Test
		public void addUserTest() {
			User user = new User(444, "Kavya", "Amritha", 23, "kavyaAmritha@gmail.com");
			List.of(user);
			Collections.singleton(user);
			when(repository.saveUser(user)).thenReturn(user);
			assertEquals(user, controller.addUser(user));
		}
//		@Test
//		public void getUserByIdTest() {
//			User user = new User(444, "Kavya", "Amritha", 23, "kavyaAmritha@gmail.com");
//			when(repository.getById(anyInt())).thenReturn(user);
//			assertEquals(user, controller.getUser(anyInt()));
//		}

		@Test
	public void deleteUserTest(){
			User user = new User(444, "Kavya", "Amritha", 23, "kavyaAmritha@gmail.com");
			controller.deleteUser(anyInt());
			verify(repository,times(1)).deleteById(anyInt());
		}
	}