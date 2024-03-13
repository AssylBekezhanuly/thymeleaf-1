// Ваш класс Student
package bitlab.TO.G1.thymeleaf1;

import java.util.concurrent.atomic.AtomicLong;

public class Student {

    private static long idCounter = 1L;

    private Long id;
    private String name;
    private String surname;
    private int exam;
    private String mark;

    // Конструктор с автоматическим установлением ID
    public Student(String name, String surname, int exam, String mark) {
        this.id = idCounter++ - 1;
        this.name = name;
        this.surname = surname;
        this.exam = exam;
        this.mark = mark;
    }

    // Конструкторы

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getExam() {
        return exam;
    }

    public void setExam(int exam) {
        this.exam = exam;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
