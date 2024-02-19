package in.ineuron.dao;

import in.ineuron.dto.Student;

public interface IStudentDao {
	String save(Student student);
	Student readById(int id);
	String updateById(Student student);
	String deleteById(int id);
}
