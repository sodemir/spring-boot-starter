package com.example.controller;


import com.example.controller.UserController;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserRepository userRepository;

    @Test
	public void getUser() throws Exception {
		when(userRepository.findById((long) 1)).thenReturn(Optional.of(new User("user1")));

		this.mockMvc
				.perform(get("/user/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json("{id:null, name:'user1'}")).andDo(print());
	}

	@Test
	public void userNotFound() throws Exception {
		when(userRepository.findById(1L)).thenReturn(Optional.empty());
		this.mockMvc.perform(get("/user/1")).andExpect(status().isNotFound());
	}

	@Test
	public void getPosts_UserNotFound() throws Exception {
		when(userRepository.findById(1L)).thenReturn(Optional.empty());
		this.mockMvc.perform(get("/user/1/posts")).andExpect(status().isNotFound());
	}

//	@Test
//	public void getPosts() throws Exception {
//		when(userRepository.findById(1L)).thenReturn(Optional.of(new User("user1")));
//		this.mockMvc
//				.perform(get("/user/1/posts")
//				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
//				.andExpect(status().isOk())
//				.andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(jsonPath("$.size", is(2)));
//	}
}
