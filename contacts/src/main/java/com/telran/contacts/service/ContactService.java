package com.telran.contacts.service;

import com.telran.contacts.model.Contact;
import com.telran.contacts.repository.IContactRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    final private IContactRepo contactRepo;

    public ContactService(IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public void add(Contact contact) {
        contactRepo.add(contact);
    }

    public List<Contact> getAll() {
        return contactRepo.getAll();
    }

    public void remove(int id) {
        contactRepo.remove(id);
    }

    public Contact get(int id) {
        return contactRepo.getById(id);
    }

    public void edit(Contact contact) {
        contactRepo.edit(contact);
    }
}
