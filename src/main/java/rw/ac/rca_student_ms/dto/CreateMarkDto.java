package rw.ac.rca_student_ms.dto;

import com.sun.istack.NotNull;

public class CreateMarkDto {
    @NotNull
    private Long studentId;

    @NotNull
    private Long courseId;

    @NotNull
    private Float score;

    @NotNull
    private Float maximum;

    public CreateMarkDto(Long studentId, Long courseId, Float score, Float maximum) {
        this.studentId = studentId;

        this.courseId = courseId;

        this.score = score;

        this.maximum = maximum;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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
