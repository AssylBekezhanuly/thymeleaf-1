// ExamController.java
package bitlab.TO.G1.thymeleaf1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

import bitlab.TO.G1.thymeleaf1.Student;

@Controller
public class ExamController {

    private List<Student> students = new ArrayList<>();


    @GetMapping("/students")
    public String showStudents(Model model) {
        model.addAttribute("students", students);
        return "students";
    }

    // @GetMapping("/addStudent")
  //  public String showAddStudentForm(Model model) {
     //   model.addAttribute("student", new Student());
   //     return "addStudent";
  //  }
    @GetMapping("/addStudent")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student("", "", 0, "")); // Передайте значения по умолчанию или используйте другие данные
        return "addStudent";
    }
    @PostMapping("/addStudent")
    public String addStudent(Student student) {
        // Выставляем оценку на основе результатов экзамена
        calculateMark(student);
        students.add(student);
        return "redirect:/students";
    }

    @GetMapping("/error")
    public String handleError() {
        // Отображаем кастомное представление для ошибок
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        // Отображаем кастомное представление для исключений
        model.addAttribute("error", e.getMessage());
        return "error";
    }

    private void calculateMark(Student student) {
        int examResult = student.getExam();
        if (examResult >= 90) {
            student.setMark("A");
        } else if (examResult >= 75) {
            student.setMark("B");
        } else if (examResult >= 60) {
            student.setMark("C");
        } else if (examResult >= 50) {
            student.setMark("D");
        } else {
            student.setMark("F");
        }
    }
}
