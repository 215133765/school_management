/**
 * Name: Mandisa Msongelwa
 * Student number: 217149073
 * Group 28
 * Question 1 (Domain Package)
 * Student.java
 * Date: 10/06/2022
 */


package za.ac.cput.Domain;


public class Student {
    private String studentId;
    private String email;
    private Name name;


    //private constructor
    private Student(){}

    public Student(Builder builder) {
        this.studentId = builder.studentId;
        this.email = builder.email;
        this.name = builder.name;
    }

    //Getters, tostring
    public String getStudentId() {return studentId;}

    public String getEmail() {return email;}

    public Name getName() {return name;}

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Student ID : " + studentId + "\n"+
        "Email :" + email + "\n" +
        "Name :" + name ;
    }

    public static class Builder {
        private String studentId;
        private String email;
        private Name name;


        public Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder name(Name name) {
            this.name = name;
            return this;
        }


        public Builder copy(Student student) {
            this.studentId = student.studentId;
            this.email = student.email;
            this.name = student.name;


            return this;
        }

        public Student build() {

            return new Student(this);}
    }

}
