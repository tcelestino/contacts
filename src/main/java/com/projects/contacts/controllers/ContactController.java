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

	@Inject
	private Result result;

	@Inject
	private ContactDAO contactDAO;
	@Inject
	private Validator validator;

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

		Contact findContact = contactDAO.findBy(contact.getId());

		result.include("contact", findContact);

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
