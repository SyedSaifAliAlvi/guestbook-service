package com.guestbook.guestbookservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.guestbook.guestbookservice.entity.GuestbookEntry;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(Include.NON_NULL)
public class GuestBookResponse {
    
    private GuestbookEntry guestbookEntry;
    private GuestBookEntries guestBookEntries;
    private String errorCode;
    private String errorMessage;
    private String message;
}
