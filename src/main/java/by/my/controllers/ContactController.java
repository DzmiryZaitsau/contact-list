package by.my.controllers;

import by.my.domain.Contact;
import by.my.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

    @Autowired
    ContactService contactService;
    @RequestMapping("/phones-book.html")
    public ModelAndView showContactsPage() {
        ModelAndView modelAndView = new ModelAndView("phones-book");
        return modelAndView;
    }

    @RequestMapping(value = "/save-phones-book.html", method = RequestMethod.POST)
    public ModelAndView save(Contact contact) {
        contactService.saveContact(contact);

        ModelAndView modelAndView = new ModelAndView("redirect:phones-book.html");
        return modelAndView;
    }
    @ModelAttribute(name = "contactList")
    private Iterable<Contact> getContactList() {
        return contactService.getUserContactList();
    }

    @ModelAttribute(name = "contact")
    private Contact getEmptyContact() {
        return new Contact(contactService.getUserByUsername());
    }




}
