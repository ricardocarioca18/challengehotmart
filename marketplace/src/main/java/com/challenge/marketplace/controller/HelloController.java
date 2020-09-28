package com.challenge.marketplace.controller;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Começando desafio Hotmart!";
	}
	
	public static void main(String[] args) {
		LocalDateTime d = LocalDateTime.now();
		String stringDate = d.toString().substring(0, 10);
		System.out.println("D1: "+stringDate);
		
		
		String d2 = "2020-09-26T11:07:17.4879399Z";
		String substringD2 = d2.substring(0, 10);
		
		System.out.println("\nD2: "+substringD2);
		boolean r = false;
		int i = stringDate.compareTo(substringD2); 
		if(i == 0) {
			r = true;
		}
		System.out.println("Resposta: "+r);
	}
	
//	public static void main(String[] args) {
//		System.out.println(new BCryptPasswordEncoder().encode("123456"));
//	}
}
