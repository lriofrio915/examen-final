package com.grupo2.examenfinal.service;

import com.grupo2.examenfinal.domain.Student;
import com.grupo2.examenfinal.domain.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto create(StudentDto dto);

    List<StudentDto> getAll();

    StudentDto getById(Long id);

    void delete(Long id);

    Student getEntityById(Long id);
}
