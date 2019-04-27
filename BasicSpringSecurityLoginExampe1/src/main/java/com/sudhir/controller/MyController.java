/**
 * 
 */
package com.sudhir.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudhirk
 *
 */
@RestController
public class MyController {

	@RequestMapping(path="/greeting", method = RequestMethod.GET)
	public String greeting(ModelMap modelMap) {
		modelMap.put("name", "Sudhir kUmar");
		return "welcome";
	}
	
	@RequestMapping("/")
	public String defaultMessage() {
		return "DefaultPage";
	}
}
