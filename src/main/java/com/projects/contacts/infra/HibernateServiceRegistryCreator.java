package com.projects.contacts.infra;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateServiceRegistryCreator {

	@Inject
	private Configuration configuration;

	@Produces
	public ServiceRegistry create(){
		return new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	}
	
}
