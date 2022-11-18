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
    builder = CreateAccountResponse.Builder.class
)
public final class CreateAccountResponse {
  private final String accountId;

  private final String userId;

  private int _cachedHashCode;

  CreateAccountResponse(String accountId, String userId) {
    this.accountId = accountId;
    this.userId = userId;
  }

  @JsonProperty("account_id")
  public String getAccountId() {
    return accountId;
  }

  @JsonProperty("user_id")
  public String getUserId() {
    return userId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateAccountResponse && equalTo((CreateAccountResponse) other);
  }

  private boolean equalTo(CreateAccountResponse other) {
    return accountId.equals(other.accountId) && userId.equals(other.userId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.accountId, this.userId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateAccountResponse{" + "accountId: " + accountId + ", userId: " + userId + "}";
  }

  public static AccountIdStage builder() {
    return new Builder();
  }

  public interface AccountIdStage {
    UserIdStage accountId(String accountId);

    Builder from(CreateAccountResponse other);
  }

  public interface UserIdStage {
    _FinalStage userId(String userId);
  }

  public interface _FinalStage {
    CreateAccountResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements AccountIdStage, UserIdStage, _FinalStage {
    private String accountId;

    private String userId;

    private Builder() {
    }

    @Override
    public Builder from(CreateAccountResponse other) {
      accountId(other.getAccountId());
      userId(other.getUserId());
      return this;
    }

    @Override
    @JsonSetter("account_id")
    public UserIdStage accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    @Override
    @JsonSetter("user_id")
    public _FinalStage userId(String userId) {
      this.userId = userId;
      return this;
    }

    @Override
    public CreateAccountResponse build() {
      return new CreateAccountResponse(accountId, userId);
    }
  }
}
