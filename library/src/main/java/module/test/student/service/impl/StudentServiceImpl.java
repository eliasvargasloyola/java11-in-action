package module.test.student.service.impl;

import module.test.student.model.Student;
import module.test.student.service.StudentService;
import module.test.student.util.DateUtil;

public class StudentServiceImpl implements StudentService {
    @Override
    public Student getStudent() {
        return new Student("Juan", "Vargas");
    }

    @Override
    public String getStudentTime(Student student) {
        return "The time is " + DateUtil.getCurrentTime() + " by the student " + student.getFullName();
    }
}
