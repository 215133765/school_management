package za.ac.cput.Repository.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Student;
import za.ac.cput.Repository.Interfaces.IStudentRepository;
import java.util.HashSet;
import java.util.Set;

@Repository
public class StudentRepository implements IStudentRepository {

    private Set<Student> students;
    private static StudentRepository studentRepository;

    private StudentRepository() {this.students = new HashSet<>();}

    public static StudentRepository getStudentRepository() {
        if (studentRepository == null) studentRepository = new StudentRepository();
        return studentRepository;
    }
            @Override
            public Student create(Student student) {
                this.students.add(student);
                return student;
            }

            @Override
            public Student read(String s) {
            Student student = this.students.stream()
                .filter(e -> e.getEmail().equalsIgnoreCase(s))
                .findAny().orElse(null);
                return student;
            }

            @Override
            public Student update(Student student) {
            Student stu = read(student.getEmail());
            if (stu != null) {
             Student updated = new Student.Builder().copy(stu)
             .studentId(student.getStudentId())
             .build();
             delete(stu.getEmail());
             this.students.add(updated);
             stu = updated;
            }
            return stu;
    }

            @Override
            public boolean delete(String s) {
            Student student = read(s);
            this.students.remove(student);
            return true;

            }
}
