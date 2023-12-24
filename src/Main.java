import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.security.SecureRandom;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        ArrayList<Block> blockchain = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Date date = new Date();

        // Generate RSA key pair
        KeyPair keyPair = generateKeyPair();

        while (true) {
            System.out.println("------------------Menu--------------------" +
                    "\n1. New block" +
                    "\n2. Search block by Hash" +
                    "\n3. List all blocks" +
                    "\n4. Quit");
            System.out.println("Do you want to create a new block? (y / n): ");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    sc.nextLine();
                    System.out.println("Write data about a transaction: ");
                    String data = sc.nextLine();

                    // Encrypt the transaction data using the public key
                    String encryptedData = encrypt(data, keyPair.getPublicKey(), keyPair.getModulus());

                    // Create a new block with the encrypted transaction data
                    Block newBlock = new Block(encryptedData);

                    // Set the previous hash if there are previous blocks
                    if (!blockchain.isEmpty()) {
                        newBlock.setPreviousHash(blockchain.get(blockchain.size() - 1).getBlockHash());
                    }

                    // Add the new block to the blockchain
                    blockchain.add(newBlock);

                    System.out.println("The block was successfully added!");
                    System.out.println();
                    break;
                case "2":
                    ///sdfsdgsdgsdbdfb
                    System.out.println("dasd");
                    break;
                case "3":
                    listBlocks(blockchain);
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Choose a valid option.");
                    break;

            }
        }
    }

    private static KeyPair generateKeyPair() {
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(1024, random);
        BigInteger q = BigInteger.probablePrime(1024, random);
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = BigInteger.valueOf(65537); // Commonly used public exponent
        BigInteger d = e.modInverse(phi);

        return new KeyPair(e, n, d);
    }

    private static String encrypt(String plainText, BigInteger publicKey, BigInteger modulus) {
        byte[] messageBytes = plainText.getBytes();
        BigInteger message = new BigInteger(messageBytes);
        BigInteger encryptedMessage = message.modPow(publicKey, modulus);
        return encryptedMessage.toString();
    }
    private static void listBlocks(ArrayList<Block> blockchain){
        System.out.println("Blockchain:");
        for (Block block : blockchain) {
            System.out.println("Block Hash: " + block.getBlockHash());
            System.out.println("Encrypted Transaction: " + block.getTransaction());
            System.out.println();
        }
    }
}