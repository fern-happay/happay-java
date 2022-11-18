package com.happay.api.client.account.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class AccountTypes {
  public static final AccountTypes LIMIT = new AccountTypes(Value.LIMIT, "LIMIT");

  public static final AccountTypes PREPAID = new AccountTypes(Value.PREPAID, "PREPAID");

  private final Value value;

  private final String string;

  AccountTypes(Value value, String string) {
    this.value = value;
    this.string = string;
  }

  public Value getEnumValue() {
    return value;
  }

  @Override
  @JsonValue
  public String toString() {
    return this.string;
  }

  @Override
  public boolean equals(Object other) {
    return (this == other) 
      || (other instanceof AccountTypes && this.string.equals(((AccountTypes) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case LIMIT:
        return visitor.visitLimit();
      case PREPAID:
        return visitor.visitPrepaid();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static AccountTypes valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "LIMIT":
        return LIMIT;
      case "PREPAID":
        return PREPAID;
      default:
        return new AccountTypes(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    PREPAID,

    LIMIT,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitPrepaid();

    T visitLimit();

    T visitUnknown(String unknownType);
  }
}
