package com.illuminati.scnetapi.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class WelcomeController {
	public ModelAndView modelView(String mv) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(mv);
		return modelAndView;
	}
	@RequestMapping("/")
	public ModelAndView get(Model model) {
		return modelView("dashboard.html");
	}
}
