import java.math.BigInteger;
import java.security.SecureRandom;

public class Encryption {
    public KeyPair generateKeyPair() {
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(1024, random);
        BigInteger q = BigInteger.probablePrime(1024, random);
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = BigInteger.valueOf(65537); // Commonly used public exponent
        BigInteger d = e.modInverse(phi);

        return new KeyPair(e, n, d);
    }

    public String encrypt(String plainText, BigInteger publicKey, BigInteger modulus) {
        byte[] messageBytes = plainText.getBytes();
        BigInteger message = new BigInteger(messageBytes);
        BigInteger encryptedMessage = message.modPow(publicKey, modulus);
        return encryptedMessage.toString();
    }

    public String decrypt(String encryptedText, BigInteger privateKey, BigInteger modulus) {
        BigInteger encryptedMessage = new BigInteger(encryptedText);
        BigInteger decryptedMessage = encryptedMessage.modPow(privateKey, modulus);

        // Convert the decrypted BigInteger back to a byte array
        byte[] decryptedBytes = decryptedMessage.toByteArray();

        // Convert the byte array to a String
        String decryptedText = new String(decryptedBytes);

        return decryptedText;

    }
}
