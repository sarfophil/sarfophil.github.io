package edu.mum.cs.cs544.exercises.domain.q3;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity(name = "school_tbl")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "school_student",
        joinColumns = {@JoinColumn(columnDefinition = "School_id")},
        inverseJoinColumns = {@JoinColumn(columnDefinition = "Student_id")})
    @MapKey
    Map<Long,Student> studentMap = new HashMap<>();

    public School(){}

    public Long getId() {
        return id;
    }

    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Long, Student> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(Map<Long, Student> studentMap) {
        this.studentMap = studentMap;
    }
}
