package rw.ac.rca_student_ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import rw.ac.rca_student_ms.exceptions.StudentNotFoundException;
import rw.ac.rca_student_ms.model.Student;
import rw.ac.rca_student_ms.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        Optional<Student> studentFound = studentRepository.findById(id);

        if (!studentFound.isPresent())
            throw new StudentNotFoundException("Not Found, Student with id :  "+id);

        return studentFound.get();
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student studentToCreate){
        Student createdStudent =  studentRepository.save(studentToCreate);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student studentToUpdate,@PathVariable Long id){
        Optional<Student> studentFound =  studentRepository.findById(id);

        if (!studentFound.isPresent())

            throw new StudentNotFoundException("Not Found, Student with id :  "+id);

        studentToUpdate.setId(studentFound.get().getId());

        studentRepository.save(studentToUpdate);

        return studentToUpdate;
    }


    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){

        Optional<Student> studentFound =  studentRepository.findById(id);

        if (!studentFound.isPresent())

            throw new StudentNotFoundException("Not Found, Student with id :  "+id);

        studentRepository.deleteById(id);

        return "Deleted Not Found, student with id : "+id;
    }
}
