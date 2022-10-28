package com.project.hm.controller;


import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.hm.customExceptions.UserNotValidException;
import com.project.hm.entity.Authorities;
import com.project.hm.entity.Details;
import com.project.hm.entity.JwtToken;
import com.project.hm.entity.LoginRequest;
import com.project.hm.entity.UserRegistration;
import com.project.hm.jwt.JwtTokenString;
import com.project.hm.jwt.JwtUtil;
import com.project.hm.repository.UserRepository;
import com.project.hm.service.UserService;

import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	JwtUtil jwtUtil;


	@Autowired
	AuthenticationManager authenticationManager;
@Autowired
UserRepository userRepository;
	
	
	@Autowired
private UserService userService;
	
	@PostMapping("user/registration")
  public ResponseEntity<UserRegistration> saveUser(@Valid @RequestBody UserRegistration userRegistration)
  {
	  System.out.println("Save User>>>>>>>>>>>>>>>>>>>>>>");
  return new ResponseEntity(userService.addReg( userRegistration), HttpStatus.CREATED);

  }
  @GetMapping("/getAllUsers")
  public ResponseEntity<List<UserRegistration>> allUsers(){
		List<UserRegistration> allUsers= userService.findAll();
		return new ResponseEntity<List<UserRegistration>>(allUsers, HttpStatus.ACCEPTED);
	
  }
  @PostMapping("/login")
  public ResponseEntity<Details> login(@RequestBody LoginRequest loginrequest,
            Details details) throws Exception {
    
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginrequest.getUsername(), loginrequest.getPassword()));
        } catch (Exception ex) {
            throw new UserNotValidException("invalid username/password");
        }
        JwtToken jwtToken = new JwtToken();
        jwtToken.setToken(jwtUtil.generateToken(loginrequest.getUsername()));
        UserRegistration userregistration= userRepository.findByUsername(loginrequest.getUsername());
        details.setUsername(userregistration.getUsername());



        Iterator iterator=userregistration.getAuthorities().iterator();
        
         
             Authorities authorities=(Authorities) iterator.next();
            
            details.setRole(authorities.getRole());
            details.setToken(jwtToken);
            return new ResponseEntity<Details>(details, HttpStatus.OK);



      
    }
  @GetMapping("/hello")
  public String hello()
  {
	  return "Hello";
  }

	
}
