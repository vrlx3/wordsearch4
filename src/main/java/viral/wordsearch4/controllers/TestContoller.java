package viral.wordsearch4.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import viral.wordsearch4.models.Grid;

@RestController
public class TestContoller {

	@GetMapping("/hello")

	public String sayHello() {
		System.out.println("Say Hello triggered");
		return "NamohArihantanam";
	}
	
	@PostMapping("/getgrid")

	public Grid Test5 () {
		Grid grid = new Grid(2,2);
		return grid;
	}
}
