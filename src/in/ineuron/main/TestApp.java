package in.ineuron.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import in.ineuron.controller.IStudentController;
import in.ineuron.dto.Student;
import in.ineuron.factory.StudentControllerFactory;

public class TestApp {

	public static void main(String[] args) {
		IStudentController stdController = StudentControllerFactory.getStudentController();
		String name = null, city = null, email = null, country = null, status = null;
		Integer id = null;
		Student studentRecord = null;
		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("1. CREATE");
				System.out.println("2. READ");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. EXIT");
				System.out.print("Your Option :: [1,2,3,4,5]:: ");
				Integer option = Integer.parseInt(br.readLine());

				switch (option) {

				case 1:
					System.out.print("Enter Name:: ");
					name = br.readLine();
					System.out.print("Enter Email:: ");
					email = br.readLine();
					System.out.print("Enter City:: ");
					city = br.readLine();
					System.out.print("Enter Country:: ");
					country = br.readLine();

					Student student = new Student();
					student.setName(name);
					student.setEmail(email);
					student.setCity(city);
					student.setCountry(country);

					status = stdController.save(student);
					if (status.equalsIgnoreCase("success")) {
						System.out.println("Student registered sucessfully...");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("Registration Failed...");
					} else {
						System.out.println("Some error occured...");
					}
					break;
				case 2:
					System.out.print("Enter Id :: ");
					id = Integer.parseInt(br.readLine());

					studentRecord = stdController.readById(id);
					if (studentRecord != null) {
						System.out.println(studentRecord);
					} else {
						System.out.println("Student with id::" + id + " dosen't exist...");
					}
					break;
				case 3:
					System.out.print("Enter Id to update details:: ");
					id = Integer.parseInt(br.readLine());

					studentRecord = stdController.readById(id);
					if (studentRecord != null) {
						Student newStudent = new Student();

						newStudent.setId(id);
						System.out.print("Student Name :[Old Name :: " + studentRecord.getName() + "] :: ");
						String newName = br.readLine();
						if (newName == null || newName.equals("")) {
							newStudent.setName(studentRecord.getName());
						} else {
							newStudent.setName(newName);
						}

						System.out.print("Student Email:[Old Email :: " + studentRecord.getEmail() + "] :: ");
						String newEmail = br.readLine();
						if(newEmail==null || newEmail.equals("")) {
							newStudent.setEmail(studentRecord.getEmail());
						}
						else {
							newStudent.setEmail(newEmail);
						}
						
						System.out.print("Student City:[Old City :: "+studentRecord.getCity()+"] :: ");
						String newCity = br.readLine();
						if(newCity==null || newCity.equals("")) {
							newStudent.setCity(studentRecord.getCity());
						}
						else {
							newStudent.setCity(newCity);
						}
						
						System.out.print("Student Country:[Old Country :: "+studentRecord.getCountry()+"] :: ");
						String newCountry = br.readLine();
						if(newCountry==null || newCountry.equals("")) {
							newStudent.setCountry(studentRecord.getCountry());
						}
						else {
							newStudent.setCountry(newCountry);
						}
						
						status = stdController.updateById(newStudent);
						if (status.equalsIgnoreCase("success")) {
							System.out.println("Record updated succesfully...");
						} else if (status.equalsIgnoreCase("failure")) {
							System.out.println("Record updation failed...");
						} else {
							System.out.println("Some problem occured...");
						}
					}
					else {
						System.out.println("Student with Id::"+id+" doesent exist...");
					}
					break;
				case 4:
					System.out.print("Enter Id to Delete the Entry:: ");
					id = Integer.parseInt(br.readLine());
					status = stdController.deleteById(id);
					if (status.equalsIgnoreCase("success")) {
						System.out.println("Record deleted succesfully...");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("Record deletion failed...");
					} else {
						System.out.println("Record not available for the given id to delete :: "+id);
					}
					break;
				case 5:
					System.out.println("Thanks for using the application");
					System.exit(0);

				default:
					System.out.println("Plz enter the option like 1,2,3,4,5 for operation");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
