# {Company} Java Library

![Maven Central](https://img.shields.io/maven-central/v/com.happay/happay-java) 
![Sonatype Nexus (Releases)](https://img.shields.io/nexus/r/com.happay/happay-java?server=https%3A%2F%2Fs01.oss.sonatype.org)

## Documentation

API documentation is available at <https://isac.happay.in/v2/api>.

## Usage

Check out the [sample app](.sample-app/app.java) which consumes this SDK!

```java
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
```

## Beta status

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning the package version to a specific version in your build.gradle file. This way, you can install the same version each time without breaking changes unless you are intentionally looking for the latest version.

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically. Additions made directly to this library would have to be moved over to our generation code, otherwise they would be overwritten upon the next generated release. Feel free to open a PR as a proof of concept, but know that we will not be able to merge it as-is. We suggest [opening an issue](https://github.com/fern-{company}/{company}-java/issues) first to discuss with us!

On the other hand, contributions to the README are always very welcome!
