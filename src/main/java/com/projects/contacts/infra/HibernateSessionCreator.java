package com.projects.contacts.infra;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateSessionCreator {

	@Inject
	private SessionFactory factory;

	@Produces
	public Session create() {
		return factory.openSession();
	}
	
}
