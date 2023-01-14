package com.example.petition.controller;


import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/student")
public class studentController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private studentService studentService;

    @GetMapping("/{id:[\\d]+}")
    public ResponseEntity<studentDto> getstudentById(@PathVariable Long id) {
        return this.studentService.getstudentById(id)
                .map(student -> {
                    log.info("student with " + id + " id was found.");
                    return ResponseEntity.ok(this.modelMapper.map(student, studentDto.class));
                }).orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @GetMapping
    public List<studentDto> getstudents() {
        return this.studentService.getstudents().stream()
                .map(student -> this.modelMapper.map(student, studentDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<studentDto> getstudentsOrderedByEmail(@RequestParam Boolean orderByEmail) {
        if (orderByEmail) {
            return this.studentService.getstudentsOrderedByEmail().stream()
                    .map(student -> this.modelMapper.map(student, studentDto.class))
                    .collect(Collectors.toList());
        } else {
            return getstudents();
        }
    }

}