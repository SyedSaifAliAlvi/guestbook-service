package com.guestbook.guestbookservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guestbook.guestbookservice.dto.GuestBookRequest;
import com.guestbook.guestbookservice.dto.GuestBookResponse;
import com.guestbook.guestbookservice.service.UserGuestBookService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/v1")
public class GuestBookController {

    @Autowired
    UserGuestBookService userGuestBookService; 

    @GetMapping("/get-all-entries/{uid}")
    public ResponseEntity<GuestBookResponse> getAllEntriesForUser(@PathVariable long uid){

        return new ResponseEntity<>(userGuestBookService.fetchGuestBookEntries(uid),HttpStatus.OK);
    }

    @GetMapping("/get-entry/{eid}")
    public ResponseEntity<GuestBookResponse> getEntryForUser(
        @PathVariable long eid){
        return new ResponseEntity<>(userGuestBookService.fetchGuestBookEntry(eid),HttpStatus.OK);
    }

    @PostMapping("/save-entry/{uid}")
    public ResponseEntity<GuestBookResponse> saveEntryForUser(
        @RequestBody GuestBookRequest guestBookRequest,
        @PathVariable long uid
    ){
        return new ResponseEntity<>(userGuestBookService.saveGuestBookEntry(guestBookRequest, uid),HttpStatus.OK);
    }

    
}
