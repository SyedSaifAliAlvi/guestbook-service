package com.guestbook.guestbookservice.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "guestbook_entry")
@JsonInclude(Include.NON_NULL)
public class GuestbookEntry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name="entry_type")
    private String entryType;

    @Column(name="text_entry")
    private String textEntry;

    @Column(name="image_entry")
    private byte[] imageEntry;

    @Column(name="approval_status")
    private String approvalStatus;



    
}
