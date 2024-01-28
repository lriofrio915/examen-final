package com.grupo2.examenfinal.service.impl;

import com.grupo2.examenfinal.domain.Student;
import com.grupo2.examenfinal.domain.dto.StudentDto;
import com.grupo2.examenfinal.exceptions.EntityNotFoundException;
import com.grupo2.examenfinal.repository.StudentRepository;
import com.grupo2.examenfinal.service.StudentService;
import com.grupo2.examenfinal.util.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    public StudentDto create(StudentDto dto) {
        log.info("Init method create");
        Student client = convertDtoToEntity(dto);
        log.info("End method create");
        return convertEntityToDto(this.repository.save(client));
    }


    public List<StudentDto> getAll() {
        return repository.findAll().stream().map(this::convertEntityToDto).toList();
    }

    public StudentDto getById(Long id) {
        return convertEntityToDto(getEntityById(id));
    }

    public void delete(Long id) {
        Student student = getEntityById(id);
        repository.delete(student);
    }

    public Student getEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }

    private StudentDto convertEntityToDto(Student student) {
        return Mapper.modelMapper().map(student, StudentDto.class);
    }

    private Student convertDtoToEntity(StudentDto dto) {
        return Mapper.modelMapper().map(dto, Student.class);
    }

}
