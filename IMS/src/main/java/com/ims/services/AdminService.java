package com.ims.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.beans.Admin;
import com.ims.daos.AdminDao;
import com.ims.dtos.AdminDto;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	public AdminDto createOrUpdateAdmin(Admin admin) {
		//add to Db
		admin = adminDao.saveAdmin(admin);
		//create dto
		AdminDto adminDto = new AdminDto(admin.getId(),admin.getEmail(),admin.getPassword(),true);
		return adminDto;
	}
	
	public AdminDto authenticateUser(AdminDto adminDto) {
		Admin admin = adminDao.getAdminByUsernameAndPassword(adminDto.getEmail(),adminDto.getPassword());
		if(admin != null) {
			adminDto.setAuthenticated(true);
			adminDto.setId(admin.getId());
		}
		return adminDto;
	}
	
	public void removeAdmin(Admin admin) {
		// remove from DB
		adminDao.removeAdmin(admin);
	}

}
