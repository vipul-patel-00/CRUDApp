package in.ineuron.controller;

import in.ineuron.dto.Student;
import in.ineuron.factory.StudentServiceFactory;
import in.ineuron.service.IStudentService;

public class StudentControllerImpl implements IStudentController{

	IStudentService stdService;
	
	@Override
	public String save(Student student) {
		stdService = StudentServiceFactory.getStudentService();
		return stdService.save(student);
	}

	@Override
	public Student readById(int id) {
		stdService = StudentServiceFactory.getStudentService();
		return stdService.readById(id);
	}

	@Override
	public String updateById(Student student) {
		stdService = StudentServiceFactory.getStudentService();
		return stdService.updateById(student);
	}

	@Override
	public String deleteById(int id) {
		stdService = StudentServiceFactory.getStudentService();
		return stdService.deleteById(id);
	}

}
