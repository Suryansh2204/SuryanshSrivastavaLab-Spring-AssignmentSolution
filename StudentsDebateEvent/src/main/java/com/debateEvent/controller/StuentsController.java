package com.debateEvent.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.debateEvent.entity.Student;
import com.debateEvent.service.StudentService;

//for 403
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@RequestMapping("/students")
public class StuentsController 
{
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/list")
	public String list(Model model)
	{
		List<Student> students=studentService.findAll();
		model.addAttribute("Students", students);
		return "list-Students";
	}
	
	@RequestMapping("/showForForAdd")
	public String showFormForAdd(Model model)
	{
		Student student=new Student();
		model.addAttribute("Student", student);
		return "Student-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model model)
	{
		Student student=studentService.findById(id);
		model.addAttribute("Student", student);
		return "Student-form";
	}
	@PostMapping("/save")
	public String save(@RequestParam("id") int id,
			@RequestParam("name") String name,@RequestParam("department") String department,@RequestParam("country") String country) {

		System.out.println(id);
		Student student;
		if(id!=0)
		{
			student=studentService.findById(id);
			student.setName(name);
			student.setCountry(country);
			student.setDepartment(department);
		}
		else
			student=new Student(name, department, country);
		// save the Book
		studentService.save(student);


		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";

	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		// delete the Book
		studentService.delete(theId);

		// redirect to /Books/list
		return "redirect:/students/list";

	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
}
