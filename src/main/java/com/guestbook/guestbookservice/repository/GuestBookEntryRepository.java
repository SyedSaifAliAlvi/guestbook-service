package com.guestbook.guestbookservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guestbook.guestbookservice.entity.GuestbookEntry;


public interface GuestBookEntryRepository extends JpaRepository<GuestbookEntry,Integer> {

    Optional<GuestbookEntry> findById(long id);
    Optional<List<GuestbookEntry>> findByUserId(long userId);
}
