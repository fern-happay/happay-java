package com.happay.api.client.account;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.happay.api.client.account.exceptions.CreateAccountException;
import com.happay.api.client.account.types.CreateAccountRequest;
import com.happay.api.client.account.types.CreateAccountResponse;
import com.happay.api.core.BearerAuth;
import com.happay.api.core.ObjectMappers;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.String;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/account")
interface AccountService {
  @POST
  @Path("/")
  CreateAccountResponse createAccount(@HeaderParam("Authorization") BearerAuth auth,
      @HeaderParam("App-ID") String appId, @HeaderParam("App-Token") String appToken,
      @HeaderParam("Request-ID") String requestId, CreateAccountRequest body) throws
      CreateAccountException;

  static AccountService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new AccountServiceErrorDecoder()).target(AccountService.class, url);
  }
}
