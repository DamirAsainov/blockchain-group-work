import java.math.BigInteger;
import java.security.SecureRandom;

public class Encryption {
    public KeyPair generateKeyPair() {
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(1024, random);
        BigInteger q = BigInteger.probablePrime(1024, random);
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = BigInteger.valueOf(65537);
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

        byte[] decryptedBytes = decryptedMessage.toByteArray();


        String decryptedText = new String(decryptedBytes);

        return decryptedText;
    }
    public String sign(String message, BigInteger privateKey, BigInteger modulus) {
        BigInteger hash = computeHash(message);


        BigInteger signature = hash.modPow(privateKey, modulus);

        return signature.toString();
    }

    public boolean verify(String message, String signature, BigInteger publicKey, BigInteger modulus) {
        BigInteger receivedSignature = new BigInteger(signature);
        BigInteger hash = computeHash(message);

        BigInteger computedSignature = receivedSignature.modPow(publicKey, modulus);

        return computedSignature.equals(hash);
    }

    private BigInteger computeHash(String message) {
        byte[] messageBytes = message.getBytes();
        return new BigInteger(messageBytes);
    }
}
