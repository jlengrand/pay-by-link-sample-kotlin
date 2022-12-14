# Adyen [Pay by link](https://www.adyen.com/pay-by-link) integration demo

## Run this integration in seconds using [Gitpod](https://gitpod.io/)

* Open your [Adyen Test Account](https://ca-test.adyen.com/ca/ca/overview/default.shtml) and create a set of [API keys](https://docs.adyen.com/user-management/how-to-get-the-api-key).
* Go to [gitpod account variables](https://gitpod.io/variables).
* Set the `ADYEN_API_KEY`, `ADYEN_CLIENT_KEY`, `ADYEN_HMAC_KEY` and `ADYEN_MERCHANT_ACCOUNT` variables.
* Click the button below!

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/jlengrand/pay-by-link-sample-kotlin)

## Details

This repository demonstrates a very minimal application allowing you to create payment links, and monitor their status. 
Bear in mind that the list of payment links is only stored in memory and will be lost once the application is stopped.

The Demo leverages Adyen's API Library for Java ([GitHub](https://github.com/Adyen/adyen-java-api-library) | [Docs](https://docs.adyen.com/development-resources/libraries#java)).

## Requirements

-   Java 17
-   Kotlin 1.7
-   Node 17
-   Network access to maven central

## Installation

1. Clone this repo:

```
git clone https://github.com/jlengrand/pay-by-link-sample-kotlin
```

## Usage

1. Set environment variables for your [API key](https://docs.adyen.com/user-management/how-to-get-the-api-key), [Client Key](https://docs.adyen.com/user-management/client-side-authentication) - Remember to add `http://localhost:8080` as an origin for client key, and merchant account name:

```shell
export ADYEN_API_KEY=yourAdyenApiKey
export ADYEN_MERCHANT_ACCOUNT=yourAdyenMerchantAccount
```

On Windows CMD you can use below commands instead

```shell
set ADYEN_API_KEY=yourAdyenApiKey
set ADYEN_MERCHANT_ACCOUNT=yourAdyenMerchantAccount
```

2. Start the server:

```
./gradlew run
```

3. Visit [http://localhost:8080/](http://localhost:8080/) to select an integration type.

To try out integrations with test card numbers and payment method details to complete payment on generated links, see [Test card numbers](https://docs.adyen.com/development-resources/test-cards/test-card-numbers).

## License

MIT license. For more information, see the **LICENSE** file in the root directory.
