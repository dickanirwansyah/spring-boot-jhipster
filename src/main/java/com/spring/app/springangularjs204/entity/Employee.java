package com.spring.app.springangularjs204.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "salary", nullable = false)
    private int salary;

    /**Many to one**/
    @ManyToOne
    @JoinColumn(name = "departement_id", referencedColumnName = "id")
    private Departement departement;

    public Employee(){}

    public Employee(String name, int salary, Departement departement){
        super();
        this.name = name;
        this.salary = salary;
        this.departement = departement;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement){
        this.departement = departement;
    }
}
