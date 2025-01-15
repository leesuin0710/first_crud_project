//WebController.java
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

	@GetMapping("/")
	public String vue() {
		return "vue/index";
	}
}
