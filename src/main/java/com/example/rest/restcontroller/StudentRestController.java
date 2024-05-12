package com.example.rest.restcontroller;

import com.example.rest.entity.Book;
import com.example.rest.entity.Game;
import com.example.rest.entity.Student;
import com.example.rest.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class StudentRestController {
    private List<Student> students;

    @PostConstruct
    public void loadData() {

        //Creat an arraylist of game object
        ArrayList<Game> listGame = new ArrayList<>();
        listGame.add(new Game(1, new int[]{3, 3, 1, 4}));
        listGame.add(new Game(2, new int[]{5, 6, 71, 84}));

        //Create a book object and adding the list of game
        Book firstBook = new Book(1, new String[]{"natur", "chamestry"}, listGame);

        students = new ArrayList<>();
        students.add(new Student(1, "hiba", "mohammad", "female", 25, true, 95.7f, firstBook));
        students.add(new Student(2, "basel", "dery", "male", 30, true, 98.2f, firstBook));
        students.add(new Student(3, "najim", "dery", "male", 27, false, 99.1f, firstBook));
        students.add(new Student(4, "abd", "alabrash", "male", 27, false, 81.3f, firstBook));
        students.add(new Student(5, "mahmoud", "abouhashem", "male", 26, false, 90.8f, firstBook));
        students.add(new Student(6, "nour", "nawara", "female", 22, true, 99.9f, firstBook));
    }

    @GetMapping("/")
    public String welcomeSchool() {
        return "Welcome to School!";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }


    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId > students.size()) {
            throw new StudentNotFoundException("Student " + studentId + " is not found! The maximal Student Numbers are " + students.size());
        } else if (studentId <= 0) {
            throw new StudentNotFoundException("Student " + studentId + " is not found! Please insert the id between 1 and " + students.size());
        } else {
            return students.get(studentId - 1);
        }
    }
}
