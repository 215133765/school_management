package za.ac.cput.Services.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Student;
import za.ac.cput.Repository.impl.StudentRepository;
import za.ac.cput.Services.Interfaces.IStudentService;

@Service
public class StudentService implements IStudentService {

    private static StudentService studentService;
    private StudentRepository studentRepository;

    private StudentService() {this.studentRepository = StudentRepository.getStudentRepository();}

    public static StudentService getStudentService() {
        if (studentService == null) studentService = new StudentService();
        return studentService;
    }

    @Override
    public Student create(Student student) {return this.studentRepository.create(student);}

    @Override
    public Student read(String s) {return this.studentRepository.read(s);}

    @Override
    public Student update(Student student) {return this.studentRepository.update(student);}

    @Override
    public boolean delete(String s) {this.studentRepository.delete(s);
    return true;}



}

