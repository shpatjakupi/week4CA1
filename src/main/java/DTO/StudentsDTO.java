/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import entities.Students;

/**
 *
 * @author Younes
 */
public class StudentsDTO {
    
    private int id;
    private String name;
    private String color;
    
    
    public StudentsDTO(Students students){
        this.id = students.getId();
        this.name = students.getName();
        this.color = students.getColor();
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
    
}
