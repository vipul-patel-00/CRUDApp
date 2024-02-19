package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Student;
import in.ineuron.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao{

	Connection connection;
	PreparedStatement pstmt;
	String status;
	
	@Override
	public String save(Student student) {
		String sqlInsertQuery = "insert into student(name,email,city,country) values(?,?,?,?)"; 
		try {
			connection = JdbcUtil.getConnection();
			if(connection!=null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			if(pstmt!=null) {	
				pstmt.setString(1, student.getName());
				pstmt.setString(2, student.getEmail());
				pstmt.setString(3, student.getCity());
				pstmt.setString(4, student.getCountry());
				
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected == 1) {
					status = "success";
				}
				else {
					status = "failure";
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			status = "failure";
		} catch (SQLException e) {
			e.printStackTrace();
			status = "failure";
		}
		return status;
	}

	@Override
	public Student readById(int id) {
		String selectQuery = "select * from student where id=?";
		Student student = null;
		try {
			connection = JdbcUtil.getConnection();
			if(connection!=null) {
				pstmt = connection.prepareStatement(selectQuery);
				if(pstmt!=null) {
					pstmt.setInt(1, id);
					ResultSet resultSet = pstmt.executeQuery();
					
					if (resultSet.next()) {
						// copy the reusltSet data to StudentDTO and trasfer to the view
						student = new Student();

						student.setId(resultSet.getInt(1));
						student.setName(resultSet.getString(2));
						student.setEmail(resultSet.getString(3));
						student.setCity(resultSet.getString(4));
						student.setCountry(resultSet.getString(5));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String updateById(Student student) {
		String sqlUpdateQuery = "update student set name=?, email=?, city=?, country=? where id=?";
		String status = null;
		
		try {
			connection = JdbcUtil.getConnection();
			if(connection!=null) {
				pstmt = connection.prepareStatement(sqlUpdateQuery);
				if(pstmt!=null) {
					pstmt.setString(1, student.getName());
					pstmt.setString(2, student.getEmail());
					pstmt.setString(3, student.getCity());
					pstmt.setString(4, student.getCountry());
					pstmt.setInt(5, student.getId());
				}
				if(pstmt!=null) {
					int rowsAffected = pstmt.executeUpdate();
					if(rowsAffected==1) {
						status = "success";
					}
					else{
						status = "failure";
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			status = "failure";
		} catch (SQLException e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String deleteById(int id) {
		String sqlDeleteQuery = "delete from student where id=?";
		String status = null;
		
		try {
			Student student = readById(id);
			if(student!=null) {
				connection = JdbcUtil.getConnection();
				if(connection!=null) {
					pstmt = connection.prepareStatement(sqlDeleteQuery);
				}
				if(pstmt!=null) {
					pstmt.setInt(1, id);
				}
				if(pstmt!=null) {
					int rowsAffected = pstmt.executeUpdate();
					if(rowsAffected==1) {
						status="success";
					}
					else {
						status = "failure";
					}
				}
			}
			else {
				status = "not Available";
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			status = "failure";
		} catch (SQLException e) {
			e.printStackTrace();
			status = "failure";
		}
		return status;
	}

}
