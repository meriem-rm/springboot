package com.springtraining.dto.rest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springtraining.dto.rest.api.converter.StudentConverter;
import com.springtraining.dto.rest.api.dto.StudentDto;
import com.springtraining.dto.rest.api.entity.Student;
import com.springtraining.dto.rest.api.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired 
	StudentRepository studentRepository;
	
	@Autowired 
	StudentConverter  converter;
	
	public Page<StudentDto> 
    getStudentPagination(
   		  Integer pageNumber, 
   		 Integer pageSize,
   		  String sortProperty) {
   	 Pageable pageable = null;
        if(null!=sortProperty){
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,sortProperty);
        }else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,"name");
        }
		Page<Student> studentList =  studentRepository.findAll(pageable) ;
		return new PageImpl<StudentDto>(converter.entityToDto(studentList.getContent()));

	} 
}
