package com.greatLearning.CRM.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatLearning.CRM.entity.CRM_Entity;

@Repository
public class CRMServiceImpl implements CRMService{

	
	private SessionFactory sessionFactory;

	// create session
	private Session session;
	
	
	@Autowired
	CRMServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}
	
	
	@Override
	@Transactional
	public List<CRM_Entity> findAll() {
		Transaction tx = session.beginTransaction();

		// find all the records from the database table
		List<CRM_Entity> crm = session.createQuery("from CRM_Entity").list();

		tx.commit();

		return crm;
	}

	@Override
	@Transactional
	public CRM_Entity findById(int theId) {
		CRM_Entity crm_customers = new CRM_Entity();

		Transaction tx = session.beginTransaction();

		// find record with Id from the database table
		crm_customers = session.get(CRM_Entity.class, theId);

		tx.commit();

		return crm_customers;
	}
	
	
	@Override
	@Transactional
	public void save(CRM_Entity theCRM) {
		// TODO Auto-generated method stub
		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(theCRM);

		tx.commit();
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		Transaction tx = session.beginTransaction();

		// get transaction
		CRM_Entity customers = session.get(CRM_Entity.class, theId);

		// delete record
		session.delete(customers);

		tx.commit();
		
	}

}
