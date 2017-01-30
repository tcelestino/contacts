package com.projects.contacts.controllers;

import java.util.List;

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
	public void create(Contact contact) {
		contactDAO.save(contact);
		
		result.include("mensagem", "Adicionando com sucesso");		
		result.redirectTo(HomeController.class).index();
	}
	
	@Get("/contact/edit/{contact.id}")
	public void edit(Contact contact) {
		
		List<Contact> selectedContact = contactDAO.edit(contact);
		
		result.include("foo", contact);
		
		if(!selectedContact.isEmpty()) {			
			for (Contact item: selectedContact) {
				result.include("contactId", item.getId());
				result.include("contactName", item.getName());
				result.include("contactEmail", item.getEmail());
				
				if(!item.getPhone().isEmpty()) {
					result.include("contactPhone", item.getPhone());
				}
			}
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
