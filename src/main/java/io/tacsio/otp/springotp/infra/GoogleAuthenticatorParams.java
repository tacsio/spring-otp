package io.tacsio.otp.springotp.infra;

/**
 * <h2>TYPE</h2>
 * Valid types are hotp and totp, to distinguish whether the key will be used for counter-based
 * HOTP or for TOTP.
 * <p>
 * <h2>LABEL</h2>
 * The label is used to identify which account a key is associated with.
 * It contains an account name, which is a URI-encoded string, optionally prefixed
 * by an issuer string identifying the provider or service managing that account.
 * <p>
 * Valid values might include Example:alice@gmail.com, Provider1:Alice%20Smith
 *
 * <h2>SECRET</h2>
 * REQUIRED: The secret parameter is an arbitrary key value encoded in Base32 according to RFC 3548.
 *
 * <h2>ISSUER</h2>
 * STRONGLY RECOMMENDED: The issuer parameter is a string value indicating the provider or service this
 * account is associated with, URL-encoded according to RFC 3986
 */
public record GoogleAuthenticatorParams(String label, String secret, String issuer) {
    private static final String type = "topt";

    public String type() {
        return type;
    }
}
