package br.com.cafglass.purchaseorder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "purchaseorder/dist/index";
	}

	@RequestMapping("/a")
	public String indexA() {
		return "purchaseorder/dist/index";
	}	
	
	@RequestMapping("/app")
	public String app() {
		return "index";
	}
}
