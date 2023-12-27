import java.math.BigInteger;

public class Signature {
    private BigInteger modulus;
    private BigInteger privateKey;
    private String message;
    private BigInteger signature;
    Signature(String message, BigInteger privateKey, BigInteger modulus){
        this.message = message;
        this.privateKey = privateKey;
        this.modulus = modulus;
        sign(message, privateKey, modulus);
    }

    public void sign(String message, BigInteger privateKey, BigInteger modulus) {
        BigInteger hash = computeHash(message);

        BigInteger signature = hash.modPow(privateKey, modulus);

        this.signature = signature;
    }
    public boolean verify(String message, BigInteger publicKey, BigInteger modulus) {
        BigInteger receivedSignature = signature;
        BigInteger hash = computeHash(message);

        BigInteger computedSignature = receivedSignature.modPow(publicKey, modulus);

        return computedSignature.equals(hash);
    }
    private BigInteger computeHash(String message) {
        byte[] messageBytes = message.getBytes();
        return new BigInteger(messageBytes);
    }
}
