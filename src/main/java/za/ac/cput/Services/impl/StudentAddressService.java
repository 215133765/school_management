package za.ac.cput.Services.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.StudentAddress;
import za.ac.cput.Repository.Interfaces.IStudentAddressRepository;
import za.ac.cput.Repository.impl.StudentAddressRepository;
import za.ac.cput.Services.Interfaces.IStudentAddressService;

@Service
public class StudentAddressService implements IStudentAddressService {

    private static StudentAddressService studentAddressService;
    private StudentAddressRepository studentAddressRepository;

    private StudentAddressService() {
        this.studentAddressRepository = StudentAddressRepository.getStudentAddressRepository();}

    public static StudentAddressService getService() {
        if (studentAddressService == null) studentAddressService = new StudentAddressService();
        return studentAddressService;
    }

    @Override
    public StudentAddress create(StudentAddress studentAddress) {return this.studentAddressRepository.create(studentAddress);}

    @Override
    public StudentAddress read(String s) {return this.studentAddressRepository.read(s);}

    @Override
    public StudentAddress update(StudentAddress studentAddress) {return this.studentAddressRepository.update(studentAddress);}

    @Override
    public boolean delete(String s) {this.studentAddressRepository.delete(s);
    return true;}
}

