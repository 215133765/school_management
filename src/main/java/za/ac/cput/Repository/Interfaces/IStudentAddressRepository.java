package za.ac.cput.Repository.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.StudentAddress;
import za.ac.cput.Repository.IRepository;


public interface IStudentAddressRepository extends IRepository<StudentAddress, String> {
}
