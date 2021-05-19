package rw.ac.rca_student_ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.ac.rca_student_ms.exceptions.CourseNotFoundException;
import rw.ac.rca_student_ms.model.Course;
import rw.ac.rca_student_ms.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id){
        Optional<Course> courseFound = courseRepository.findById(id);

        if (!courseFound.isPresent())
            throw new CourseNotFoundException("Not found ,course  with id : "+id);

        return courseFound.get();
    }

    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody Course courseToCreate){
        Course createdCourse =  courseRepository.save(courseToCreate);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public Course updateCourse(@RequestBody Course courseToUpdate,@PathVariable Long id){
        Optional<Course> courseFound =  courseRepository.findById(id);

        if (!courseFound.isPresent())
            throw new CourseNotFoundException("Not found ,course  with id : "+id);

        courseToUpdate.setId(courseFound.get().getId());

        courseRepository.save(courseToUpdate);

        return courseToUpdate;
    }


    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id){

        Optional<Course> courseFound =  courseRepository.findById(id);

        if (!courseFound.isPresent())
            throw new CourseNotFoundException("Not found ,course  with id : "+id);

        courseRepository.deleteById(id);

        return "Deleted Course with id : "+id;
    }
}
