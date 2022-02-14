package com.springtraining.dto.rest.api.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.springtraining.dto.rest.api.dto.StudentDto;
import com.springtraining.dto.rest.api.entity.Student;

@Component
public class StudentConverter {

	
	public StudentDto entityToDto(Student st) {
		//StudentDto dto = new StudentDto();
//		dto.setId(st.getId());
//		dto.setName(st.getName());
//		dto.setUsername(st.getUsername());
//		dto.setPassword(st.getPassword()); 
		ModelMapper mapper = new ModelMapper();
		StudentDto map = mapper.map(st, StudentDto.class);
		return map;
	}
	
	public List<StudentDto> entityToDto(List<Student> student){
		return student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	public Student dtoToEntity(StudentDto dto) {
//		Student st = new Student();
//		st.setId(dto.getId());
//		st.setName(dto.getName());
//		st.setUsername(dto.getUsername());
//		st.setPassword(dto.getPassword());
		ModelMapper mapper = new ModelMapper();
		Student map = mapper.map(dto, Student.class);
		return map;
	} 
	
	public List<Student> dtoToEntity(List<StudentDto> dto) {
		return dto.stream()
				.map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	
}
