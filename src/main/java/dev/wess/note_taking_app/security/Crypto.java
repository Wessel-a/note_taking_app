package dev.wess.note_taking_app.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crypto {

    // Method to hash a given string (password) using SHA-256
    public static String hash(String input) {
        try {
            // Get an instance of the SHA-256 MessageDigest
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Apply the hash function on the input string
            byte[] encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Convert the byte array into a hex string
            return bytesToHex(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error: SHA-256 algorithm not found!", e);
        }
    }

    // Helper method to convert byte array to hex string
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
