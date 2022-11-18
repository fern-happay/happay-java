package com.happay.api;

import com.happay.api.client.account.AccountServiceClient;
import com.happay.api.core.BearerAuth;
import com.happay.api.core.Environment;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public final class HappayApiClient {
  private final Supplier<AccountServiceClient> accountServiceClient;

  public HappayApiClient(BearerAuth auth) {
    this(Environment.PRODUCTION, auth);
  }

  public HappayApiClient(Environment environment, BearerAuth auth) {
    this.accountServiceClient = memoize(() -> new AccountServiceClient(environment.getUrl(), auth));
  }

  public final AccountServiceClient account() {
    return this.accountServiceClient.get();
  }

  private static <T> Supplier<T> memoize(Supplier<T> delegate) {
    AtomicReference<T> value = new AtomicReference<>();
    return () ->  {
      T val = value.get();
      if (val == null) {
        val = value.updateAndGet(cur -> cur == null ? Objects.requireNonNull(delegate.get()) : cur);
      }
      return val;
    } ;
  }
}
