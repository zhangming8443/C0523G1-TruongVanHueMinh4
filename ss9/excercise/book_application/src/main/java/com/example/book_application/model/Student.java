package com.example.book_application.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "student_name")
    private String studentName;
    @ManyToMany
    @JoinTable(name = "student")
    @JoinColumn(columnDefinition = "student_id",
            referencedColumnName = "book_id")
    private List<Book> bookList;

    public Student() {
    }

    public Student(int studentId, String studentName, List<Book> bookList) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.bookList = bookList;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
