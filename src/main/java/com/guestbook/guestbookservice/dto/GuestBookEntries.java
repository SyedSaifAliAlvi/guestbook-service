package com.guestbook.guestbookservice.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.guestbook.guestbookservice.entity.GuestbookEntry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class GuestBookEntries {
    
    private List<GuestbookEntry> guestBookEntriesList;
}
