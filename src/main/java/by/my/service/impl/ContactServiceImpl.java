package by.my.service.impl;

import by.my.domain.Contact;
import by.my.domain.User;
import by.my.repository.ContactRepository;
import by.my.repository.UserRepository;
import by.my.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public Iterable<Contact> getUserContactList() {
        User user = getUserByUsername();

        return user.getUserContacts();
    }

    @Override
    public User getUserByUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        return userRepository.findByUsername(username);
    }

    @Override
    public Contact getContactById(Long contactId) {
        return contactRepository.findById(contactId).orElse(new Contact());
    }

    @Override
    public void deleteContact(Long contactId) {
        contactRepository.deleteById(contactId);
    }


}
