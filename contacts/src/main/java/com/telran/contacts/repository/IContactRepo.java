package com.telran.contacts.repository;

import com.telran.contacts.model.Contact;

import java.util.List;

public interface IContactRepo {

    void add(Contact contact);

    Contact getById(int id);

    void edit(Contact contact);

    List<Contact> getAll();

    void remove(int id);
}