package com.projects.contacts.infra;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactoryCreator {

	@Inject
	private Configuration configuration;
	
	@Inject
	private ServiceRegistry registry;
	
	@Produces
	public SessionFactory create() {
		return configuration.buildSessionFactory(registry);
	}
	
}
