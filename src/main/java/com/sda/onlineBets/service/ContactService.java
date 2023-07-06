package com.sda.onlineBets.service;

import com.sda.onlineBets.dto.ContactDto;
import com.sda.onlineBets.entity.Contact;
import com.sda.onlineBets.mapper.ContactMapper;
import com.sda.onlineBets.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactMapper contactMapper;

    public void saveContact(ContactDto contactDto) {
        Contact contact =contactMapper.map(contactDto);
        contactRepository.save(contact);
    }
}
