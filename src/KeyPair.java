import java.math.BigInteger;

public class KeyPair {
    private final BigInteger publicKey;
    private final BigInteger modulus;
    private final BigInteger privateKey;

    public KeyPair(BigInteger publicKey, BigInteger modulus, BigInteger privateKey) {
        this.publicKey = publicKey;
        this.modulus = modulus;
        this.privateKey = privateKey;
    }

    public BigInteger getPublicKey() {
        return publicKey;
    }

    public BigInteger getModulus() {
        return modulus;
    }

    public BigInteger getPrivateKey() {
        return privateKey;
    }
}
