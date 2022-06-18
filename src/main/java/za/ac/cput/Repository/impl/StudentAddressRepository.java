package za.ac.cput.Repository.impl;

import za.ac.cput.Domain.Student;
import za.ac.cput.Domain.StudentAddress;
import za.ac.cput.Repository.Interfaces.IStudentAddressRepository;
import java.util.*;


public class StudentAddressRepository implements IStudentAddressRepository {


private Set<StudentAddress> studentAddresses;
private static StudentAddressRepository studentAddressRepository;

private StudentAddressRepository() {this.studentAddresses = new HashSet<>();}

public static StudentAddressRepository getStudentAddressRepository() {
    if (studentAddressRepository == null) {
        studentAddressRepository = new StudentAddressRepository();
    }

    return studentAddressRepository;
}

@Override
    public StudentAddress create(StudentAddress studentAddress) {
    this.studentAddresses.add(studentAddress);
    return studentAddress;
}

@Override
public StudentAddress read(String s) {
    for (StudentAddress studAdd: studentAddresses) {
        if (studAdd.getStudentId().equals(s))
            return studAdd;
    }
    return null;
}

@Override
    public StudentAddress update(StudentAddress studentAddress) {
    StudentAddress studAdd = read(studentAddress.getStudentId());
    if (studAdd != null) {
        StudentAddress updated = new StudentAddress.Builder().copy(studAdd)
                .address(studentAddress.getAddress())
                .build();
        delete(studAdd.getStudentId());
        this.studentAddresses.add(updated);
        studAdd = updated;
    }
    return studAdd;
}

@Override
    public void delete(String s) {
    StudentAddress studentAddress = read(s);
    this.studentAddresses.remove(studentAddress);
}

}
