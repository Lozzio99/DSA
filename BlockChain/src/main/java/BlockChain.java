import java.util.Arrays;

public class BlockChain
{
    public static void main(String[] args) {
        /*
        BlockChain -
        Block - Hash of previous block + Transactions
         */

        Transaction transaction1 = new Transaction("Peter", "Sam", 100L);

        Transaction transaction2 = new Transaction("io", "tu", 1000L);
        Transaction transaction3 = new Transaction("io", "tu", 1000L);
        Transaction transaction4 = new Transaction("Peter", "Sam", 100L);
        Transaction transaction5 = new Transaction("io", "tu", 1000L);
        Transaction transaction6 = new Transaction("io", "tu", 1000L);
        Transaction transaction7 = new Transaction("Peter", "Sam", 100L);
        Transaction transaction8 = new Transaction("io", "tu", 1000L);
        Transaction transaction9 = new Transaction("io", "tu", 1000L);




        Block firstBlock = new Block(0, Arrays.asList(transaction1,transaction2));

        Block secondBlock = new Block(firstBlock.hashCode(),Arrays.asList(transaction3) );
        Block thirdBlock = new Block(secondBlock.hashCode(),Arrays.asList(transaction4,transaction5,transaction6) );
        Block fourthBlock = new Block(thirdBlock.hashCode(),Arrays.asList(transaction7,transaction8, transaction9) );



        /*
        System.out.println(transaction1.hashCode());
        System.out.println(transaction2.hashCode());
        System.out.println(transaction3.hashCode());
        System.out.println(firstBlock.hashCode());
         */
    }
}
