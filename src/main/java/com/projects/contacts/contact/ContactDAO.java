package com.projects.contacts.contact;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.projects.contacts.contact.Contact;

public class ContactDAO {

	@Inject Session session;

	public void save(Contact contact) {
		session.beginTransaction();
		session.save(contact);
		session.getTransaction().commit();
	}

	
	public List<Contact> edit(Contact contact) {
		List<Contact> contactInfo = getOneContact(contact.getId());
		return contactInfo;
	}

	public boolean remove(Contact contact) {
		String hql = "DELETE FROM agenda WHERE id = :id";
		Transaction transaction = session.beginTransaction();
		int result = session.createQuery(hql)
					.setParameter("id", contact.getId())
					.executeUpdate();

		transaction.commit();

		return result > 0;
	}

	@SuppressWarnings("unchecked")
	public List<Contact> getAll() {
		Criteria createCriteria = session.createCriteria(Contact.class);

		return createCriteria.list();
	}
	
	@SuppressWarnings("unchecked")
	private List<Contact> getOneContact(Long id) {
		
		return session.createSQLQuery("SELECT c.* FROM agenda c WHERE c.id =" + id).list();
		
//		String hql = "SELECT C.* FROM agenda C WHERE C.id = :id";
//		session.beginTransaction();
//		Query query = session.createQuery(hql).setParameter("id", id).;
//		
//		return query.list();
	}

}
