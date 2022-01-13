/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package java11in.action;

import module.test.student.model.Student;
import module.test.student.service.impl.StudentServiceImpl;

public class App {
    public String getGreeting(Student student) {
        return "Hello World! " + student.getFullName();
    }

    public static void main(String[] args) {
        var student = new Student("Elias", "Vargas");
        App app = new App();
        System.out.println(app.getGreeting(student));
        var serviceStudent = new StudentServiceImpl();
        var storedStudent = serviceStudent.getStudent();
        System.out.println(app.getGreeting(storedStudent));
        System.out.println(serviceStudent.getStudentTime(student));
    }
}
