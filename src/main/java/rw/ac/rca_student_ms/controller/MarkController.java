package rw.ac.rca_student_ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rw.ac.rca_student_ms.dto.CreateMarkDto;
import rw.ac.rca_student_ms.exceptions.CourseNotFoundException;
import rw.ac.rca_student_ms.exceptions.MarksNotFoundException;
import rw.ac.rca_student_ms.exceptions.StudentNotFoundException;
import rw.ac.rca_student_ms.model.Course;
import rw.ac.rca_student_ms.model.Mark;
import rw.ac.rca_student_ms.model.Student;
import rw.ac.rca_student_ms.repository.CourseRepository;
import rw.ac.rca_student_ms.repository.MarkRepository;
import rw.ac.rca_student_ms.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api/marks")

public class MarkController {
    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Mark> getAllMarks(){

        return markRepository.findAll();

    }

    @GetMapping("/{id}")
    public Mark getMarksById(@PathVariable Long id){

        Optional<Mark> marksFound = markRepository.findById(id);

        if (!marksFound.isPresent())

            throw new MarksNotFoundException("Not found, marks with id : "+id);

        return marksFound.get();
    }

    @PostMapping
    public Mark recordMarks(@RequestBody CreateMarkDto createMark){

        Optional<Student> studentFound = studentRepository.findById(createMark.getStudentId());

        Optional<Course> courseFound = courseRepository.findById(createMark.getCourseId());

        if (!studentFound.isPresent())

            throw new StudentNotFoundException("Not Found, Student with id : "+createMark.getStudentId());

        if (!courseFound.isPresent())

            throw new CourseNotFoundException("Not Found, course with id : "+createMark.getCourseId());


        Mark newMarks = new Mark();

        newMarks.setScore(createMark.getScore());

        newMarks.setMaximum(createMark.getMaximum());

        newMarks.setStudent(studentFound.get());

        newMarks.setCourse(courseFound.get());

        markRepository.save(newMarks);

        return newMarks;

    }

    @PutMapping("/{id}")
    public Mark updateMarks(@RequestBody CreateMarkDto createMark,@PathVariable Long id){

        Optional<Mark> markFound = markRepository.findById(id);

        if (!markFound.isPresent())

            throw new CourseNotFoundException("Not Found, marks with id : "+id);

        Optional<Student> studentFound = studentRepository.findById(createMark.getStudentId());

        Optional<Course> courseFound = courseRepository.findById(createMark.getCourseId());

        if (!studentFound.isPresent())

            throw new StudentNotFoundException("Not Found, Student with id : "+createMark.getStudentId());

        if (!courseFound.isPresent())

            throw new CourseNotFoundException("Not Found, course with id : "+createMark.getCourseId());



        Mark newMarks = new Mark();

        newMarks.setScore(createMark.getScore());

        newMarks.setMaximum(createMark.getMaximum());

        newMarks.setStudent(studentFound.get());

        newMarks.setCourse(courseFound.get());

        newMarks.setId(id);

        markRepository.save(newMarks);

        return newMarks;

    }


    @DeleteMapping("/{id}")
    public String deleteMarks(@PathVariable Long id){

        Optional<Mark> markFound =  markRepository.findById(id);

        if (!markFound.isPresent())

            return "Marks with id "+id+" not found ";

        markRepository.deleteById(id);

        return "Deleted Marks with id : "+id;
    }
}
