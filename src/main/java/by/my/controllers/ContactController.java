package by.my.controllers;

import by.my.domain.Contact;
import by.my.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping("/edit-phones-book.html")
    public ModelAndView editContact(@RequestParam(name = "contact_id") Long contactId) {
        ModelAndView modelAndView = new ModelAndView("edit-contact");

        Contact contact = contactService.getContactById(contactId);
        modelAndView.addObject("contact", contact);

        return modelAndView;
    }

    @RequestMapping("/delete-phones-book.html")
    public ModelAndView deleteContact(@RequestParam(name = "contact_id") Long contactId) {
        contactService.deleteContact(contactId);

        ModelAndView modelAndView = new ModelAndView("redirect:phones-book.html");
        return modelAndView;
    }
    @RequestMapping("/search-contacts.html")
    public ModelAndView searchContact(@RequestParam(name = "letters") String letters) {
        ModelAndView modelAndView = new ModelAndView("search-contacts");
        List<Contact> list = new ArrayList<>();
        getContactList().forEach( contact -> {
            if (contact.getName().toLowerCase().startsWith(letters.toLowerCase())) {
                list.add(contact);
            }
        });
        modelAndView.addObject("list", list);

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
