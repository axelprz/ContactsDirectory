package com.axelprz.contactsdirectory.service;

import com.axelprz.contactsdirectory.exception.ResourceNotFoundException;
import com.axelprz.contactsdirectory.model.Contact;
import com.axelprz.contactsdirectory.model.Group;
import com.axelprz.contactsdirectory.repository.IContactRepository;
import com.axelprz.contactsdirectory.repository.IGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private IContactRepository contactRepository;

    @Autowired
    private IGroupRepository groupRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact createContact(Contact contact) {
        List<Group> groups = contact.getGroups();
        groups.forEach(group -> {
            Optional<Group> existingGroup = groupRepository.findByName(group.getName());
            existingGroup.ifPresent(value -> groups.set(groups.indexOf(group), value));
        });
        return contactRepository.save(contact);
    }

    public Contact getContactById(Integer id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        return optionalContact.orElseThrow(() -> new ResourceNotFoundException("Contact not found with id: " + id));
    }

    public Contact updateContact(Integer id, Contact contactDetails) {
        Contact contact = getContactById(id);

        contact.setFirstName(contactDetails.getFirstName());
        contact.setLastName(contactDetails.getLastName());
        contact.setEmail(contactDetails.getEmail());
        contact.setBirthDate(contactDetails.getBirthDate());
        contact.setAddress(contactDetails.getAddress());

        List<Group> groups = contactDetails.getGroups();
        groups.forEach(group -> {
            Optional<Group> existingGroup = groupRepository.findByName(group.getName());
            existingGroup.ifPresent(value -> groups.set(groups.indexOf(group), value));
        });
        contact.setGroups(groups);

        return contactRepository.save(contact);
    }

    public void deleteContact(Integer id) {
        Contact contact = getContactById(id);
        contactRepository.delete(contact);
    }
}
