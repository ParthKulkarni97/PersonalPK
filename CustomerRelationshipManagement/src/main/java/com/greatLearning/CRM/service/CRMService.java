package com.greatLearning.CRM.service;

import java.util.List;

import com.greatLearning.CRM.entity.CRM_Entity;

public interface CRMService {
	
	public List<CRM_Entity> findAll();

	public CRM_Entity findById(int theId);

	public void save(CRM_Entity theCRM);

	public void deleteById(int theId);

}
