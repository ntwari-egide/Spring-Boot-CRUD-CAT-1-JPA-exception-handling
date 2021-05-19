package rw.ac.rca_student_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.ac.rca_student_ms.model.Course;

/**
 * @author : ntwari egide
 * @description: student repository
 */

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
