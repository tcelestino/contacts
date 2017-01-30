package com.projects.contacts.contact;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class ContactDAO {
	
	@Inject Session session;
	
	public void save(Contact contact) {
		session.beginTransaction();
		session.save(contact);
		session.getTransaction().commit();
	}
	
	public void edit(Contact contact) {
		
	}
	
	public void remove(Contact contact) {
		session.beginTransaction();
		session.delete(contact.getId());
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> getAll() {
		Criteria createCriteria = session.createCriteria(Contact.class);
		
		return createCriteria.list();
	}
}
