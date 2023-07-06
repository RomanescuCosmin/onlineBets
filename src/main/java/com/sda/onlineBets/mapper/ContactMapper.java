package com.sda.onlineBets.mapper;

import com.sda.onlineBets.dto.ContactDto;
import com.sda.onlineBets.entity.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {
    public Contact map(ContactDto contactDto){
        return Contact.builder()
                .email(contactDto.getEmail())
                .name(contactDto.getName())
                .message(contactDto.getMessage())
                .build();
    }


}
