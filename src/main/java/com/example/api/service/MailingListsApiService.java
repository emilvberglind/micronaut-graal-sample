package com.example.api.service;

import com.example.exception.NotFoundException;
import com.example.model.MailingListSubscriptionRequest;

import javax.ws.rs.core.Response;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2020-08-01T10:57:25.305764-04:00[America/New_York]")
public abstract class MailingListsApiService {
    public abstract Response subscribe(MailingListSubscriptionRequest mailingListSubscriptionRequest) throws NotFoundException;
}
