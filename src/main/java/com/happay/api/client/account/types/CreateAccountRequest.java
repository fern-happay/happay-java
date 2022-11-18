package com.happay.api.client.account.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = CreateAccountRequest.Builder.class
)
public final class CreateAccountRequest {
  private final AccountTypes accountType;

  private final String userId;

  private int _cachedHashCode;

  CreateAccountRequest(AccountTypes accountType, String userId) {
    this.accountType = accountType;
    this.userId = userId;
  }

  @JsonProperty("account_type")
  public AccountTypes getAccountType() {
    return accountType;
  }

  @JsonProperty("user_id")
  public String getUserId() {
    return userId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateAccountRequest && equalTo((CreateAccountRequest) other);
  }

  private boolean equalTo(CreateAccountRequest other) {
    return accountType.equals(other.accountType) && userId.equals(other.userId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.accountType, this.userId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateAccountRequest{" + "accountType: " + accountType + ", userId: " + userId + "}";
  }

  public static AccountTypeStage builder() {
    return new Builder();
  }

  public interface AccountTypeStage {
    UserIdStage accountType(AccountTypes accountType);

    Builder from(CreateAccountRequest other);
  }

  public interface UserIdStage {
    _FinalStage userId(String userId);
  }

  public interface _FinalStage {
    CreateAccountRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements AccountTypeStage, UserIdStage, _FinalStage {
    private AccountTypes accountType;

    private String userId;

    private Builder() {
    }

    @Override
    public Builder from(CreateAccountRequest other) {
      accountType(other.getAccountType());
      userId(other.getUserId());
      return this;
    }

    @Override
    @JsonSetter("account_type")
    public UserIdStage accountType(AccountTypes accountType) {
      this.accountType = accountType;
      return this;
    }

    @Override
    @JsonSetter("user_id")
    public _FinalStage userId(String userId) {
      this.userId = userId;
      return this;
    }

    @Override
    public CreateAccountRequest build() {
      return new CreateAccountRequest(accountType, userId);
    }
  }
}
