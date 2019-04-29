package com.pramati.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */

/**
 * @author sudhirk
 *
 */
@RestController
public class MyController {
	
	@RequestMapping("/**")
	public String handler(Model model, HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("uri", request.getRequestURI());
		model.addAttribute("username", authentication.getName());
		model.addAttribute("roles", authentication.getAuthorities());
		return "app";
	}
}
