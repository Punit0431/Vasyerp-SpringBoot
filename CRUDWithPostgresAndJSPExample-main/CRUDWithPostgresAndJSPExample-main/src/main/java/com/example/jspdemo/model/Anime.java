package com.example.jspdemo.model;

import javax.persistence.*;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="ANIME")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private int year;
    

    public Anime() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    @JsonBackReference
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_id", referencedColumnName  = "salary_id")
//    @Query(nativeQuery =true ,value = "select * from anime where salary_id in (select salary_id from salary)")
    private Salary salary;


	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}
}
