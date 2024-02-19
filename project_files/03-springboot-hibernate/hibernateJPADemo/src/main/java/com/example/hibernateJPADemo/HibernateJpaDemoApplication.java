package com.example.hibernateJPADemo;

import com.example.hibernateJPADemo.dao.StudentDAO;
import com.example.hibernateJPADemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateJpaDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDao) {
		return runner -> {
			createStudent(studentDao);
		};
	}

	private void createStudent(StudentDAO studentDao) {
		// create the student object
		System.out.println("Creating new student object...");
		Student tmpStudent = new Student("Paul", "Doe", "paul@luv");

		// save the student object
		System.out.println("Saving the student...");
		studentDao.save(tmpStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tmpStudent.getId());
	}
}
