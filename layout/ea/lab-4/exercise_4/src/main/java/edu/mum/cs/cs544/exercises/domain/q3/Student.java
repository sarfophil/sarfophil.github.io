package edu.mum.cs.cs544.exercises.domain.q3;

import edu.mum.cs.cs544.exercises.domain.q1.Laptop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "student_tbl")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String firstname,lastname;

    public Student(){}

    public Student(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj.getClass() != getClass()) return false;
        Student student = (Student) obj;
        return firstname.equals(student.firstname) && lastname.equals(student.lastname);
    }


    @Override
    public int hashCode() {
        return Objects.hash(firstname,lastname);
    }
}
