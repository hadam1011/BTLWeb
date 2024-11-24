package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Star;
import com.example.demo.service.StarService;

@RestController
@CrossOrigin
public class StarController {
	@Autowired
	StarService starService;
	
	@GetMapping("/stars")
	public List<Star> getAllStar() {
		return starService.getAll();
	}
	
	@GetMapping("/stars/{bookid}")
	public List<Star> getAllStarByBookid(@PathVariable String bookid){
		return starService.getAllByBookid(Integer.valueOf(bookid));
	}
	
	@PostMapping("/star")
	public Star createStar(@RequestBody Star star) {
		return starService.save(star);
	}
	
	@PutMapping("/star/{id}")
	public Star updateStar(@RequestBody Star star, @PathVariable String id) {
		star.setStarid(Integer.valueOf(id));
		return starService.save(star);
	}
	
	@DeleteMapping("/star/{id}")
	public void deleteStar(@PathVariable String id) {
		starService.delete(Integer.valueOf(id));
	}
}
