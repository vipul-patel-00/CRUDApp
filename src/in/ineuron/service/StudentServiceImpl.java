package in.ineuron.service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dto.Student;
import in.ineuron.factory.StudentDaoFactory;

public class StudentServiceImpl implements IStudentService{

	IStudentDao stdDao;
	
	@Override
	public String save(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.save(student);
	}

	@Override
	public Student readById(int id) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.readById(id);
	}

	@Override
	public String updateById(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.updateById(student);
	}

	@Override
	public String deleteById(int id) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.deleteById(id);
	}

}
