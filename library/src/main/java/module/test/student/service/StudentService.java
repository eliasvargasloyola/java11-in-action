package module.test.student.service;

import module.test.student.model.Student;

public interface StudentService {
    Student getStudent();

    String getStudentTime(Student student);
}
