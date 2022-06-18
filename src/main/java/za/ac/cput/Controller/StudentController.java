package za.ac.cput.Controller;

import com.sun.istack.NotNull;

import org.jetbrains.annotations.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Student;
import za.ac.cput.Factory.StudentFactory;
import za.ac.cput.Services.impl.AddressService;
import za.ac.cput.Services.impl.CityService;
import za.ac.cput.Services.impl.StudentAddressService;
import za.ac.cput.Services.impl.StudentService;

import java.util.Set;

@Controller
@RequestMapping("/student/")
public class StudentController {

    @Autowired
    private StudentService studentService;
//    @Autowired
//    private StudentAddressService studentAddressService;
//    @Autowired
//    private AddressService service;
//    @Autowired
//    private CityService cityService;
@PostMapping(value = "create")
public Student create(@RequestBody @NotNull Student student) {
    Student newStudent = StudentFactory.buildStudent(student.getStudentId(), student.getEmail(), student.getName());
    return studentService.create(newStudent);
}

    @GetMapping(value = "read/{studentId}")
    public Student read(@PathVariable String studentId) {
        return studentService.read(studentId);
    }

    @PutMapping(value = "update")
    public Student update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping(value = "delete/{studentId}")
    public boolean delete(@PathVariable String studentId) {
        return studentService.delete(studentId);
    }


}
