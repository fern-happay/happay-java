# Happay ISAC Java Library

![Maven Central](https://img.shields.io/maven-central/v/io.github.fern-api/happay-java) 
![Sonatype Nexus (Releases)](https://img.shields.io/nexus/r/io.github.fern-api/happay-java?server=https%3A%2F%2Fs01.oss.sonatype.org)

## Documentation

API documentation is available at <https://isac.happay.in/v2/api>.

## Usage

Check out the [sample app](sample-app/src/main/java/sample/App.java) which consumes this SDK!

```java
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
            .accountType(AccountTypes.LIMIT)
            .userId("usr_5a33fa01ce4b4113a11ceb5c17c601c5")
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

While we value open-source contributions to this SDK, this library is generated programmatically. Additions made directly to this library would have to be moved over to our generation code, otherwise they would be overwritten upon the next generated release. Feel free to open a PR as a proof of concept, but know that we will not be able to merge it as-is. We suggest [opening an issue](https://github.com/fern-happay/happay-java/issues) first to discuss with us!

On the other hand, contributions to the README are always very welcome!
