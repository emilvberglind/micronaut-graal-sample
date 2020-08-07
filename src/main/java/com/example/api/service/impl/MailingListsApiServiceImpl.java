package com.example.api.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.example.api.service.MailingListsApiService;
import com.example.api.service.TokenGenerator;
import com.example.db.model.MailingList;
import com.example.exception.NotFoundException;
import com.example.model.MailingListSubscriptionRequest;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2020-08-01T10:57:25.305764-04:00[America/New_York]")
@Slf4j
@Singleton
public class MailingListsApiServiceImpl extends MailingListsApiService {
    private final TokenGenerator tokenGenerator;
    private final Firestore db;
    private final ObjectMapper objectMapper;

    @Inject
    public MailingListsApiServiceImpl(
                                      TokenGenerator tokenGenerator,
                                      Firestore db,
                                      ObjectMapper objectMapper) {
        this.tokenGenerator = tokenGenerator;
        this.db = db;
        this.objectMapper = objectMapper;
    }

    @Override
    public Response subscribe(MailingListSubscriptionRequest mailingListSubscriptionRequest) throws NotFoundException {
        DocumentReference documentReference = db.collection("mailinglists")
                .document(mailingListSubscriptionRequest.getEmail());
        try {
            DocumentSnapshot documentSnapshot = documentReference.get().get();
            if (documentSnapshot.exists()) {
                return Response.status(Response.Status.CONFLICT).build();
            } else {
                String token = tokenGenerator.generate(16);
                MailingList mailingList = MailingList.builder()
                        .email(mailingListSubscriptionRequest.getEmail())
                        .verified(false)
                        .token(token).build();

                documentReference.set(mailingList);
                return Response.ok().build();
            }
        } catch (Exception e) {
            log.error("Caught Exception subscribing to mailing list", e);
            return Response.serverError().build();
        }
    }
}
