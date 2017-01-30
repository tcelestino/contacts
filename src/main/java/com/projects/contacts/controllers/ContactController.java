package com.projects.contacts.controllers;

import javax.inject.Inject;

import com.projects.contacts.contact.Contact;
import com.projects.contacts.contact.ContactDAO;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class ContactController {
	
	@Inject
	private Result result;
	
	@Inject
	private ContactDAO contactDAO;
	
	@Get("/contact/add")
	public void form() {
		
	}
	
	@Post("contact/create")
	public void save(Contact contact) {
		contactDAO.save(contact);
		result.redirectTo(HomeController.class).index();
	}
	
	@Get("/contact/edit")	
	public void edit() {
	}
	
	@Post("/contact/remove")
	public void remove(Contact contact) {
		contactDAO.remove(contact);
		
		result.redirectTo(HomeController.class).index();
	}
}
