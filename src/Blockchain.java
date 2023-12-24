import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Blockchain {
    private ArrayList<Block> blocks = new ArrayList<>();
    private Encryption encryption = new Encryption();
    private KeyPair keyPair = encryption.generateKeyPair();


    public void listBlocks(){
        System.out.println("Blockchain:");
        for (Block block : blocks) {
            System.out.println("Block Hash: " + block.getBlockHash());
            System.out.println("Encrypted Transaction: " + block.getTransaction());
            System.out.println();
        }
    }
    public Block searchBlock(int hash){
        for(int i = 0; i < blocks.size(); i++){
            if(blocks.get(i).getBlockHash() == hash){
                return blocks.get(i);
            }
        }
        return null;
    }
    public void addBlock(String data){
        String encryptedData = encryption.encrypt(data, keyPair.getPublicKey(), keyPair.getModulus());

        // Create a new block with the encrypted transaction data
        Block newBlock = new Block(encryptedData);

        // Set the previous hash if there are previous blocks
        if (!blocks.isEmpty()) {
            newBlock.setPreviousHash(blocks.get(blocks.size() - 1).getBlockHash());
        }

        // Add the new block to the blockchain
        blocks.add(newBlock);
        System.out.println("Hash of block - " + newBlock.getBlockHash() +
                "\nYour private key:\n" + keyPair.getPrivateKey());
    }
    public BigInteger getModulus(){
        return keyPair.getModulus();
    }
}
