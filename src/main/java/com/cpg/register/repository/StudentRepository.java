package com.cpg.register.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpg.register.model.Student;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Modifying
	@Query(value="insert into mydb.student values(:id, :age, :city, :email, :gender, :mobile, :name, :password, :role);",nativeQuery=true)
     void addStudent(@Param("id")long id, @Param("age")String age, @Param("city")String city,
    		 @Param("email")String email, @Param("gender")String gender, @Param("mobile")String mobile, @Param("name")String name, 
    		 @Param("password")String password,@Param("role")String role);

	
	@Query(value="select * from mydb.student where email_id = :email and s_password = :password and user_role = :role",nativeQuery=true)
	List<Student> validateStudent(@Param("email")String email, @Param("password")String password,@Param("role")String role);

	@Modifying
	@Query(value="delete from mydb.student where student_id= :sid",nativeQuery=true)
	void removeStudent(@Param("sid")long sid);
	
	@Modifying
	@Query(value="update mydb.student set student_city= :city, email_id= :email, mobile_number= :mobile, student_name= :name, s_password= :password where student_id= :sid",nativeQuery=true)
	void editStudent(@Param("sid")long sid,@Param("city")String city, @Param("email")String email, 
			@Param("mobile")String mobile, @Param("name")String name, @Param("city")String password);
	
}
