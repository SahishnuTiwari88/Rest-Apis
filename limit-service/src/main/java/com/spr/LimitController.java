package com.spr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {
	
	
	@RequestMapping("/limit")
	public Limit getLimits() {
		return new Limit(10,100);
	}

}
