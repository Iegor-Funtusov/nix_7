package ua.com.alevel.util;

import org.apache.commons.codec.digest.DigestUtils;

public final class SecurityUtil {

    private SecurityUtil() { }

    public static String hashPassword(String password) {
        String sha256hex = DigestUtils.sha256Hex(password);
        return sha256hex;
    }
}
