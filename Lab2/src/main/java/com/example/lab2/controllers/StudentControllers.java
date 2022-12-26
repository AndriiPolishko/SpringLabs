package com.example.lab2.controllers;

import com.example.lab2.entities.Activity;
import com.example.lab2.entities.Student;
import com.example.lab2.services.ActivityService;
import com.example.lab2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentControllers {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ActivityService activityService;

    @GetMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public String studentForm(Model model) {
        model.addAttribute("student", new Student());
        return "forms/studentForm";
    }

    @PostMapping("/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String studentCreate(@Valid @ModelAttribute Student student) {
        studentService.addStudent(student);
        return "Student " + student.getName() + "created with email: " + student.getEmail();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String studentInfo(@Valid @PathVariable int id, Model model) {
        Student student = studentService.getStudent(id);
        ArrayList<Activity> allActivities = activityService.getAllActivities();
        List<Activity> filteredActivities = allActivities.stream().filter(activity -> activity.getStudentId() == id).toList();
        model.addAttribute("name", student.getName());
        model.addAttribute("activities", filteredActivities);
        return "other/info";
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String updateStudent(@PathVariable int id, HttpServletRequest request,
                                HttpServletResponse response, Model model) {
        String reqId = request.getParameter("id");
        String reqName = request.getParameter("name");
        Student oldStudent = studentService.getStudent(id);
        Student newStudent = new Student();
        if (reqId == null) {
            newStudent.setId(id);
        } else {
            newStudent.setId(Integer.parseInt(reqId));
        }
        if (reqName == null) {
            newStudent.setName(oldStudent.getName());
        } else {
            newStudent.setName(reqName);
        }
        studentService.updateStudent(id, newStudent);
        return "Student with id: " + id + " was updated";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student with id: " + id + " was deleted";
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    String getSome(@RequestParam int page,
                   @RequestParam int size,
                   Model model) {

        List<Student> students = this.studentService.findAll(page, size);

        model.addAttribute("students", students);
        return "other/students";
    }

    @GetMapping("/email")
    @ResponseBody
    String getStudentByTheEmail(@RequestParam String email) {
        Student student = studentService.getStudentByTheEmail(email);
        return "Student " + student.getName() + " with email: " + email + "is found";
    }
}
