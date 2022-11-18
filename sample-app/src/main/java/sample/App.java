package sample;

import java.lang.String;
import com.happay.api.HappayApiClient;
import com.happay.api.client.account.endpoints.CreateAccount;
import com.happay.api.client.account.exceptions.CreateAccountException;
import com.happay.api.client.account.types.AccountTypes;
import com.happay.api.client.account.types.CreateAccountRequest;
import com.happay.api.client.account.types.CreateAccountResponse;
import com.happay.api.core.BearerAuth;
import com.happay.api.core.Environment;

public final class App {
  public static void main(String[] args) {
    String token = System.getenv("HAPPAY_TOKEN");

    BearerAuth auth = BearerAuth.of(token);

    HappayApiClient happayApiClient =
            new HappayApiClient(Environment.PRODUCTION, auth);
    try {
      CreateAccountResponse createAccountResponse = happayApiClient.account().createAccount(CreateAccount.Request.builder()
              .appId("foo123")
              .appToken("bar456")
              .requestId("cde789")
              .body(CreateAccountRequest.builder()
                      .accountType(AccountTypes.LIMIT)
                      .userId("")
                      .build())
              .build());
    } catch (CreateAccountException e) {
      e.printStackTrace();
    }
  }
}
