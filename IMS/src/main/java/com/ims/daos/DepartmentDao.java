package com.ims.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ims.beans.Department;
import com.ims.repositories.DepartmentRepository;

@Component
@Transactional
public class DepartmentDao {
	
	@Autowired
	private DepartmentRepository aRepo;
	
	public DepartmentDao() {
		
	}
	
	public void setDepartmentRepo(DepartmentRepository aRepo) {
		this.aRepo = aRepo;
	}
	
	public void addDepartment(Department s) {
		aRepo.save(s);
	}
	public List<Department> getAll(){
		return (List<Department>) aRepo.findAll();
	}
	public Department getDepartmentById(int id) {
		return aRepo.findOne(id);
	}
	public void updateDepartment(Department s) {
		aRepo.saveAndFlush(s);
	}
	public void removeDepartment(Department s) {
		aRepo.delete(s);
	}

}