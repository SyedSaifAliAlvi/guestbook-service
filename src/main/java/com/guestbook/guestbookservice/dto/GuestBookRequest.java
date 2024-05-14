package com.guestbook.guestbookservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class GuestBookRequest {
    
    private String entryType;
    private String textEntry;
    private String imageEntry;
}
