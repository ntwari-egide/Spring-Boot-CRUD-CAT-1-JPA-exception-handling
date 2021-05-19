package rw.ac.rca_student_ms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 * @author : ntwari egide
 * @Description: Entity of student tbl
 */

@Entity
public class Student {
    @Id

    @GeneratedValue

    private Long id;

    private String name;

    private String email;

    private String gender;

    private Integer age;

    public Student() {
    }

    public Student(String name, String email, String gender, Integer age) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //    names, email, gender and age
}
