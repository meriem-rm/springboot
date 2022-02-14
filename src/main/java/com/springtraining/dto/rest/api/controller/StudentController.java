package com.springtraining.dto.rest.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springtraining.dto.rest.api.converter.StudentConverter;
import com.springtraining.dto.rest.api.dto.StudentDto;
import com.springtraining.dto.rest.api.entity.Student;
import com.springtraining.dto.rest.api.repo.StudentRepository;
import com.springtraining.dto.rest.api.service.StudentService;

@RestController
//@RequestMapping("/")
public class StudentController {
	
	@Autowired 
	StudentRepository studentRepository;
	
	@Autowired 
	StudentConverter  converter;
	
	@Autowired 
	StudentService  service;
	
	@GetMapping("all")
	public List<StudentDto> getStudent() {
		List<Student> findAll =  studentRepository.findAll() ;
		return converter.entityToDto(findAll);
	}
	
	@GetMapping("all/{ID}")
	public StudentDto findById(@PathVariable(value="ID") Long id) {
		Student student = studentRepository.findById(id).orElse(null); 
		return converter.entityToDto(student);
	}
	
	
	
     @PostMapping("/save") 
      public StudentDto save(@RequestBody StudentDto dto) {	
		Student student = converter.dtoToEntity(dto);
		student=  studentRepository.save(student);
		return converter.entityToDto(student);
	}
	
     @GetMapping("all/{pageNumber}/{pageSize}")
  	public Page<StudentDto> 
      getStudentPagination(
     		 @PathVariable Integer pageNumber, 
     		 @PathVariable Integer pageSize) {
     	return service.getStudentPagination(pageNumber, pageSize, null);
  	} 
     
     
     @GetMapping("all/{pageNumber}/{pageSize}/{sortProperty}")
 	public Page<StudentDto> 
     getStudentPaginationandSort(
    		 @PathVariable Integer pageNumber, 
    		 @PathVariable Integer pageSize,
    		 @PathVariable String sortProperty) {
    	return service.getStudentPagination(pageNumber, pageSize, sortProperty);
 	} 
     
}
