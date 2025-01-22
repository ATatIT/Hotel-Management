package com.motel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.motel.entity.UserEntity;
import com.motel.repository.UserRepository;

@RestController
public class UserController {

	private PasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	UserRepository userRepository;

	/*
	 * @GetMapping("newuser") public String newUser(){ return "NewUser"; }
	 */

	/*
	 * @PostMapping("/saveuser") public String saveUser(UserEntity userEntity, Model
	 * model) {
	 * 
	 * if (!userEntity.getPassword().equals(userEntity.getConfirmPassword())) {
	 * model.addAttribute("passerror", "Passeord & ConfirmPasseord must be same!");
	 * return "NewUser"; }
	 * 
	 * //set plain text String plainText = userEntity.getPassword();
	 * 
	 * //ecode the plain text String encodePass = encoder.encode(plainText);
	 * 
	 * //set password userEntity.setPassword(encodePass);
	 * 
	 * userRepository.save(userEntity);
	 * 
	 * return "redirect:/login"; }
	 */
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/saveuser")
	public ResponseEntity<String> saveUser(@RequestBody UserEntity userEntity) {
		if (!userEntity.getPassword().equals(userEntity.getConfirmPassword())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password & ConfirmPasseord must be same!");
		}
		
		String plainText = userEntity.getPassword();
		
		String encodePass = encoder.encode(plainText);
		
		userEntity.setPassword(encodePass);
		userRepository.save(userEntity);
		
		return ResponseEntity.ok("User Registerd Sucsessfully");	
	}
}
