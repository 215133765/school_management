package za.ac.cput.Repository.Interfaces;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Student;
import za.ac.cput.Repository.IRepository;


public interface IStudentRepository extends IRepository<Student, String> {
}


