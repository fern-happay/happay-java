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
              .appId("app_36c3e32a-dc18-11e8-89bd-0242ac130002")
              .appToken("BO8SS05DS4Q9K1GRONRBP")
              .requestId("75ff8b82-bca8-11e8-a355-529269fb1459")
              .body(CreateAccountRequest.builder()
                      .accountType(AccountTypes.PREPAID)
                      .userId("usr_5a33fa01ce4b4113a11ceb5c17c601c5")
                      .build())
              .build());
    } catch (CreateAccountException e) {
      e.printStackTrace();
    }
  }
}
