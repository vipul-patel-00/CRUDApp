package in.ineuron.controller;

import in.ineuron.dto.Student;

public interface IStudentController {
	String save(Student student);
	Student readById(int id);
	String updateById(Student student);
	String deleteById(int id);
}
