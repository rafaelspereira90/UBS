package br.com.rafael.ubs.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rafael.ubs.controller.form.UserForm;
import br.com.rafael.ubs.model.User;
import br.com.rafael.ubs.repository.UserRepository;
import br.com.rafael.ubs.vo.UserVO;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<UserVO> createUser(@RequestBody @Valid UserForm form, UriComponentsBuilder uriBuilder) {
		
		User user = new User(form.getName(), form.getEmail(), form.getPassword());
		
		userRepository.save(user);
		
		URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
				
		return ResponseEntity.created(uri).body(new UserVO(user));
	}
}
