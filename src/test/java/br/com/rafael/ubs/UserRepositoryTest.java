package br.com.rafael.ubs;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.rafael.ubs.model.User;
import br.com.rafael.ubs.repository.UserRepository;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void FindExistingUserTest() {
		Optional<User> user = userRepository.findByEmail("bionexo@email.com");
		assertTrue(user.isPresent());
		assertEquals("Bionexo", user.get().getName());
	}
	
	@Test
	public void FindNonExistingUserTest() {
		Optional<User> user = userRepository.findByEmail("rafael@email.com");
		assertFalse(user.isPresent());
	}
}
