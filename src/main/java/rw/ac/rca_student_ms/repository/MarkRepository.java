package rw.ac.rca_student_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.ac.rca_student_ms.model.Mark;

/**
 * @author : ntwari egide
 * @description: mark repository
 */


@Repository
public interface MarkRepository extends JpaRepository<Mark,Long> {
}
