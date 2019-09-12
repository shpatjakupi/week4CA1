/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Students;
import java.util.List;

/**
 *
 * @author shpattt
 */
public interface IstudentsFacade {
    List<Students> getAllStudents();
    List<Students> getStudentsByName(String name);
    Students getStudentsById(int id);
    List<Students> getStudentsByColor(String color);
    long getStudentCount();
    Students addStudents(Students student);
    void populateStudents();
}
