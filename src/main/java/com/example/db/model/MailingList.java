package com.example.db.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MailingList {
    private String email;
    private boolean verified;
    private String token;
}
