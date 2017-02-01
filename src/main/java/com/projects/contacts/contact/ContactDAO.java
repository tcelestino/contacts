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
	public List<Contact> all() {
		Criteria createCriteria = session.createCriteria(Contact.class);

		return createCriteria.list();
	}
	
	public Contact findBy(Long id) {
		Query query = session.createQuery("SELECT c FROM " + Contact.class.getSimpleName() + " c WHERE c.id =" + id);
		return (Contact) query.uniqueResult();
	}

}
