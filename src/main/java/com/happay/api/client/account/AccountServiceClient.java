package com.happay.api.client.account;

import com.happay.api.client.account.endpoints.CreateAccount;
import com.happay.api.client.account.exceptions.CreateAccountException;
import com.happay.api.client.account.types.CreateAccountResponse;
import com.happay.api.core.BearerAuth;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Optional;

public final class AccountServiceClient {
  private final AccountService service;

  private final Optional<BearerAuth> auth;

  public AccountServiceClient(String url) {
    this.service = AccountService.getClient(url);
    this.auth = Optional.empty();
  }

  public AccountServiceClient(String url, BearerAuth auth) {
    this.service = AccountService.getClient(url);
    this.auth = Optional.of(auth);
  }

  public CreateAccountResponse createAccount(CreateAccount.Request request) throws
      CreateAccountException {
    BearerAuth authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required for createAccount")));
    return this.service.createAccount(authValue, request.getAppId(), request.getAppToken(), request.getRequestId(), request.getBody());
  }
}
