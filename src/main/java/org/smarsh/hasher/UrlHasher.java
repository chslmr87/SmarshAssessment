package org.smarsh.hasher;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public final class UrlHasher {
    public static String hash(String url) {
        try {
            var messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(url.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }
}
