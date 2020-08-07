package com.example.api;

import com.example.api.service.MailingListsApiService;
import com.example.exception.NotFoundException;
import com.example.model.MailingListSubscriptionRequest;
import com.example.model.RestException;
import io.swagger.annotations.ApiParam;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/mailing-lists")
@io.swagger.annotations.Api(description = "the mailing-lists API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2020-08-01T11:25:49.200896-04:00[America/New_York]")
public class MailingListsApi {
    private final MailingListsApiService delegate;

    @Inject
    public MailingListsApi(MailingListsApiService mailingListsApiService) {
        this.delegate = mailingListsApiService;
    }

    @POST

    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "Subscribes a user to the mailing list.", notes = "", response = Void.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 204, message = "User subscribed (No Content).", response = Void.class),

            @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request. A validation error occurred.", response = RestException.class),

            @io.swagger.annotations.ApiResponse(code = 409, message = "User already subscribed.", response = RestException.class),

            @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error.", response = RestException.class)})
    public Response subscribe(@ApiParam(value = "") @Valid MailingListSubscriptionRequest mailingListSubscriptionRequest)
            throws NotFoundException {
        return delegate.subscribe(mailingListSubscriptionRequest);
    }
}
