package com.motel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.motel.entity.UserEntity;
import com.motel.repository.UserRepository;


@RestController
public class LoginController {
	
	@Autowired
	UserRepository userRepository;
	
	private PasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@GetMapping("login")
	public String loginPage() {
		return "LoginPage";
	}
	
	/*
	 * @PostMapping("/authenticate") public String authenticateUser(UserEntity
	 * userEntity,Model model) { UserEntity loggedUser =
	 * userRepository.findByEmail(userEntity.getEmail());
	 * 
	 * if(loggedUser == null) { model.addAttribute("invalidemail",
	 * "Invalid Email please enter correct one"); return "LoginPage"; }else {
	 * boolean pass = encoder.matches(userEntity.getPassword(),
	 * loggedUser.getPassword()); if (pass == false) {
	 * model.addAttribute("invalidpass", "Please Enter Correct Passwoord"); return
	 * "LoginPage"; }else { model.addAttribute("name", loggedUser.getFirstName());
	 * return "Hello"; } } }
	 */
	
	//for react 
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/authenticate")
	public ResponseEntity<String> authUser(@RequestBody UserEntity userEntity){
		UserEntity loggUser = userRepository.findByEmail(userEntity.getEmail());
		System.out.println("Received Email: " + userEntity.getEmail());
		System.out.println("Received Password: " + userEntity.getPassword());

		if(loggUser == null) {
			System.out.println("Invalid");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid email");
		}else {
			boolean pass = encoder.matches(userEntity.getPassword(),loggUser.getPassword());
			if(pass == false) {
				System.out.println("Incorrect");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please enter correct password");
			}else {
				System.out.println("Successfully");
				return ResponseEntity.ok("Login Successfully");
			}
		}
	}
}
