package com.guestbook.guestbookservice.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guestbook.guestbookservice.dto.GuestBookEntries;
import com.guestbook.guestbookservice.dto.GuestBookRequest;
import com.guestbook.guestbookservice.dto.GuestBookResponse;
import com.guestbook.guestbookservice.entity.GuestbookEntry;
import com.guestbook.guestbookservice.repository.GuestBookEntryRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserGuestBookService {

    @Autowired
    private GuestBookEntryRepository guestBookEntryRepository;

    public GuestBookResponse fetchGuestBookEntry(long eid){

        GuestBookResponse guestBookResponse = new GuestBookResponse(); 
        Optional<GuestbookEntry> guestBookEntry = guestBookEntryRepository.findById(eid);
        if(guestBookEntry.isPresent()){
            guestBookResponse.setGuestbookEntry(guestBookEntry.get());
        }
        else{
            guestBookResponse.setErrorMessage("Entry not found");
        }
        return guestBookResponse; 

    }

    public GuestBookResponse fetchGuestBookEntries(long uid){

        GuestBookResponse guestBookResponse = new GuestBookResponse(); 
        Optional<List<GuestbookEntry>> guestBookEntries = guestBookEntryRepository.findByUserId(uid);
        if(guestBookEntries.isPresent()){
            guestBookResponse.setGuestBookEntries(new GuestBookEntries(guestBookEntries.get()));
        }
        else {
            guestBookResponse.setErrorMessage("Entry not found");
        }
        return guestBookResponse; 

    }

    public GuestBookResponse saveGuestBookEntry(GuestBookRequest guestBookRequest,long uid){

        GuestBookResponse guestBookResponse = new GuestBookResponse(); 
        GuestbookEntry guestbookEntry = new GuestbookEntry();
        guestbookEntry.setUserId(uid);
        guestbookEntry.setEntryType(guestBookRequest.getEntryType());
        guestbookEntry.setApprovalStatus("PENDING");
        if(guestBookRequest.getEntryType().toUpperCase().equals("TEXT")){
            guestbookEntry.setTextEntry(guestBookRequest.getTextEntry());
        }
        else if(guestBookRequest.getEntryType().toUpperCase().equals("IMAGE")) {
            byte[] stringByteArray;
            try {
                stringByteArray = guestBookRequest.getImageEntry().getBytes("UTF-8");
                guestbookEntry.setImageEntry(stringByteArray);
            } catch ( UnsupportedEncodingException e) {
                log.info("Error during converting to BLOB : {}",e.getLocalizedMessage());
            } 
        }
        else {
            guestBookResponse.setErrorMessage("Wrong Entry Type");
            return guestBookResponse;
        }
        guestBookEntryRepository.save(guestbookEntry);
        guestBookResponse.setMessage("Success");
        return guestBookResponse; 
    }
    
}
