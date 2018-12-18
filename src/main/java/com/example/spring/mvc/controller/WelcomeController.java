package com.example.spring.mvc.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring.mvc.model.Person;

@Controller
@RequestMapping("/")
public class WelcomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(HttpServletRequest request, HttpServletResponse response, Model model) {

		return "index";
	}
	
	@GetMapping(value = "/getperson")
	public String getPerson(Model model) {
		Person person = new Person();
		person.setFirstName("Supratim");
		person.setLastName("Bhattacharyya");
		model.addAttribute("person", person);
		return "person";
	}
	
	@PostMapping(value = "/addperson")
	public String addPerson(Model model, @ModelAttribute Person person) {
		
		System.out.println(person.getFirstName());
		System.out.println(person.getLastName());
		model.addAttribute("firstName", person.getFirstName());
		return "message";
	}
	
	@GetMapping(value = "/uploadfile")
	public String uploadFile(Model model) {
		//model.addAttribute("file1", "kdvbdsf"); 
		return "uploadFile";
	}
	
	@PostMapping(value = "/uploadfile")
	public String uploadFileHandler(@RequestParam MultipartFile file, Model model) throws IOException {
		System.out.println(file.getName());
		String line;
		List<String> result = new ArrayList<>();
		InputStream is = file.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			result.add(line);
		}
		System.out.println(result);
		
		model.addAttribute("fileName", file.getName());
		if(true) {
			throw new IOException();
		}
		
		return "index";
	}
}
