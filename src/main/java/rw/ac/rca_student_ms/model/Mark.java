package rw.ac.rca_student_ms.model;

import javax.persistence.*;

/**
 * @author : ntwari egide
 * @Description: Entity of marks tbl
 */

@Entity
public class Mark {

    @Id

    @GeneratedValue

    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    private Float score;

    private Float maximum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Float getMaximum() {
        return maximum;
    }

    public void setMaximum(Float maximum) {
        this.maximum = maximum;
    }
}
