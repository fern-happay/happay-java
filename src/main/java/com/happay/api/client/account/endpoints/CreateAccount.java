package com.happay.api.client.account.endpoints;

import com.happay.api.client.account.types.CreateAccountRequest;
import com.happay.api.core.BearerAuth;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class CreateAccount {
  private CreateAccount() {
  }

  public static final class Request {
    private final String appId;

    private final String appToken;

    private final String requestId;

    private final CreateAccountRequest body;

    private final Optional<BearerAuth> authOverride;

    private int _cachedHashCode;

    Request(String appId, String appToken, String requestId, CreateAccountRequest body,
        Optional<BearerAuth> authOverride) {
      this.appId = appId;
      this.appToken = appToken;
      this.requestId = requestId;
      this.body = body;
      this.authOverride = authOverride;
    }

    public String getAppId() {
      return appId;
    }

    public String getAppToken() {
      return appToken;
    }

    public String getRequestId() {
      return requestId;
    }

    public CreateAccountRequest getBody() {
      return body;
    }

    public Optional<BearerAuth> getAuthOverride() {
      return authOverride;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return appId.equals(other.appId) && appToken.equals(other.appToken) && requestId.equals(other.requestId) && body.equals(other.body) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.appId, this.appToken, this.requestId, this.body, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "CreateAccount.Request{" + "appId: " + appId + ", appToken: " + appToken + ", requestId: " + requestId + ", body: " + body + ", authOverride: " + authOverride + "}";
    }

    public static AppIdStage builder() {
      return new Builder();
    }

    public interface AppIdStage {
      AppTokenStage appId(String appId);

      Builder from(Request other);
    }

    public interface AppTokenStage {
      RequestIdStage appToken(String appToken);
    }

    public interface RequestIdStage {
      BodyStage requestId(String requestId);
    }

    public interface BodyStage {
      _FinalStage body(CreateAccountRequest body);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<BearerAuth> authOverride);

      _FinalStage authOverride(BearerAuth authOverride);
    }

    public static final class Builder implements AppIdStage, AppTokenStage, RequestIdStage, BodyStage, _FinalStage {
      private String appId;

      private String appToken;

      private String requestId;

      private CreateAccountRequest body;

      private Optional<BearerAuth> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        appId(other.getAppId());
        appToken(other.getAppToken());
        requestId(other.getRequestId());
        body(other.getBody());
        authOverride(other.getAuthOverride());
        return this;
      }

      @Override
      public AppTokenStage appId(String appId) {
        this.appId = appId;
        return this;
      }

      @Override
      public RequestIdStage appToken(String appToken) {
        this.appToken = appToken;
        return this;
      }

      @Override
      public BodyStage requestId(String requestId) {
        this.requestId = requestId;
        return this;
      }

      @Override
      public _FinalStage body(CreateAccountRequest body) {
        this.body = body;
        return this;
      }

      @Override
      public _FinalStage authOverride(BearerAuth authOverride) {
        this.authOverride = Optional.of(authOverride);
        return this;
      }

      @Override
      public _FinalStage authOverride(Optional<BearerAuth> authOverride) {
        this.authOverride = authOverride;
        return this;
      }

      @Override
      public Request build() {
        return new Request(appId, appToken, requestId, body, authOverride);
      }
    }
  }
}
