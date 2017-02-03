package com.projects.contacts.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import com.projects.contacts.contact.Contact;
import com.projects.contacts.contact.ContactDAO;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class ContactController {

	private Result result;
	private ContactDAO contactDAO;
	private Validator validator;

	@Deprecated
	public ContactController() {
	}

	@Inject
	public ContactController(ContactDAO contactDAO, Validator validator, Result result) {
		this.contactDAO = contactDAO;
		this.validator = validator;
		this.result = result;
	}

	@Get("/contact/add")
	public void form() {
	}


	@Post("contact/create")
	public void create(@Valid Contact contact) {
		validator.onErrorUsePageOf(this).form();

		contactDAO.save(contact);

		result.include("mensagem", "Criado com sucesso");
		result.redirectTo(HomeController.class).index();
	}

	@Get("/contact/edit/{contact.id}")
	public void edit(Contact contact) {

		Optional<Contact> result = contactDAO.findBy(contact.getId());
		
		if(result.isPresent()) {
			result.include("contact", editContact);
		}
	}

	@Post("/contact/edit")
	public void updateContact(Contact contact) {
		boolean wasUpdate = contactDAO.update(contact);

		if(wasUpdate) {
			result.include("mensagem", "Editado com sucesso");
			result.redirectTo(HomeController.class).index();
		} else {
			result.redirectTo(this).form();
		}

	}

	@Post("/contact/remove")
	public void remove(Contact contact) {
		if(contact == null) {
			return;
		}

		contactDAO.remove(contact);
		result.redirectTo(HomeController.class).index();
	}
}
