package com.projects.contacts.controllers;

import javax.inject.Inject;

import com.projects.contacts.contact.Contact;
import com.projects.contacts.contact.ContactDAO;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class HomeController {

	@Inject
	private Result result;
	@Inject
	private ContactDAO contactDAO;

	private Contact contact;
	
	public HomeController() {
		// TODO Auto-generated constructor stub
	}
	
	public HomeController(Contact contact) {
		this.contact = contact;
	}
	
	
	@Get("/")
	public void index() {
		result.include("contacts", contactDAO.getAll());
	}
	
}