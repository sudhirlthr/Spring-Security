/**
 * 
 */
package com.sudhir.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhir.model.Courses;
import com.sudhir.service.StudentService;

/**
 * @author sudhirk
 *
 */
@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping(path="/student/{studentid}/courses")
	public List<Courses> getStudentCourseList(@PathVariable("studentid") String studentid, Principal principal) {
		System.out.println("LoggedIn User = "+principal.getName());
		return studentService.retrieveCourses(studentid);
	}
}
