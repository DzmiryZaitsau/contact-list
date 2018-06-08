package by.my.service;

import by.my.domain.Contact;
import by.my.domain.User;

public interface ContactService {
    void saveContact(Contact contact);
    Iterable<Contact> getUserContactList();
    User getUserByUsername();
}
