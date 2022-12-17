package com.example.lab2.teacher;

import com.example.lab2.lesson.Lesson;
import com.example.lab2.lesson.LessonRepository;
import com.example.lab2.student.Student;
import com.example.lab2.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeacherControllers {
    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    StudentService studentService;

    @GetMapping("/teacher/createStudent")
    String createStudent(){
        return "student/create";
    }

    @GetMapping("/teacher/studentCreated")
    @ResponseBody
    String studentCreated(int id, String name, Model model) {
        studentService.addStudent(new Student(id, name));
        return "Student Created";
    }

    @GetMapping("/teacher/createLesson")
    String createGrade() {
        return "createLesson";
    }

    @GetMapping("/teacher/lessonCreated")
    @ResponseBody
    String lessonCreated(int id, String date, Model model) {
        Lesson lesson = new Lesson(id, date);
        lessonRepository.store(lesson);
        model.addAttribute("id", id);
        return "Lesson created";
    }
}
