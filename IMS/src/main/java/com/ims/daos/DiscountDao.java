package com.ims.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ims.beans.Discount;
import com.ims.repositories.DiscoutRepository;

@Component
@Transactional
public class DiscountDao {
	
	@Autowired
	private DiscoutRepository aRepo; //i spelled it wrong...
	
	public DiscountDao() {
		
	}
	
	public void setDiscountRepo(DiscoutRepository aRepo) {
		this.aRepo = aRepo;
	}
	
	public void addDiscount(Discount s) {
		aRepo.save(s);
	}
	public List<Discount> getAll(){
		return (List<Discount>) aRepo.findAll();
	}
	public Discount getDiscountById(int id) {
		return aRepo.findOne(id);
	}
	public void updateDiscount(Discount s) {
		aRepo.saveAndFlush(s);
	}
	public void removeDepartment(Discount s) {
		aRepo.delete(s);
	}

}