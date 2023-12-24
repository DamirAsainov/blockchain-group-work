import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Block> blockchain = new ArrayList<>();
        String trans1 = "1123123werwerrwerDASdSDASDASD";
        String trans2 = "Dasdasdasd";
        String trans3 = "21312rdfsdfsdbfbfbfgfgdfdfb";
        Block genesisBlock = new Block(0, new String[]{trans1});
        Block block2 = new Block(genesisBlock.getPreviousHash(), new String[]{trans2, trans3});

        System.out.println("Hash of genesis");
        System.out.println(genesisBlock.getBlockHash());
        System.out.println("Hash of block 2");
        System.out.println(block2.getBlockHash());
    }
}