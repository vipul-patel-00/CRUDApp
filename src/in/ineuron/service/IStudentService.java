package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {
	String save(Student student);
	Student readById(int id);
	String updateById(Student student);
	String deleteById(int id);
}
