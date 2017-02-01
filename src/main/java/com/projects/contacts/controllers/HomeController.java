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
	
	@Get("/")
	public void index() {
		result.include("contactsList", contactDAO.all());
	}
}