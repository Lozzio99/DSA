import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSearch
{
    static int[] largestFirstPrefix;
    static int[] patternFound;

    public static int[] patternMatch(String text, String pattern)
    {
        // Return an array of indices representing the first indices of the matched
        // pattern in the String
        // You choose which algorithm you'd prefer to implement here (don't use brute-force)
        // If the pattern does not exist in the string, return an empty array
        calcMaxPrefix(pattern);
        patternFound = new int[text.length()];

        int pointer1, pointer2, found = pointer2 = pointer1 = 0;
        while(pointer1<text.length())
        {
            if (pattern.charAt(pointer2)==text.charAt(pointer1))
            {
                pointer1++;
                pointer2++;
                if (pointer2==pattern.length())
                {

                    patternFound[found++]=pointer1-pointer2;
                    pointer2 = largestFirstPrefix[pointer2];
                }
            }
            else
            {
                pointer2 = largestFirstPrefix[pointer2];
                if (pointer2<0)
                {
                    pointer1++;
                    pointer2++;
                }
            }
        }
        return nonzero(patternFound, found);
    }

    static int[] nonzero(int [] p, int found)
    {
        int [] n = new int [found];
        System.arraycopy(p,0,n,0,found);
        return n;
    }
    static void calcMaxPrefix (String p)
    {
        int patternLength = p.length();
        largestFirstPrefix = new int[patternLength+1];
        largestFirstPrefix[0] = -1;
        largestFirstPrefix[1] = 0;

        int prefixL = 0,i = 1;
        while(i<patternLength)
        {
            if (p.charAt(prefixL)==p.charAt(i))
            {
                prefixL++;
                i++;
                largestFirstPrefix[i] = prefixL;
            }
            else if (prefixL>0)
                prefixL = largestFirstPrefix[prefixL];
            else{
                i++;
                largestFirstPrefix[i] = 0;
            }
        }
    }

    public static void main(String[] args) {

        String dna = "GGGCATTGTTTTAGGGGGGTTATTCGAGGGCACTCGCAGCCAACTTGTCGGGACCAGCCGGGCTGGTCATCGGGCTTATATAGCGAAATGCCGAGGACCCGGCCCCACGCTATGGAACGTCTTTAGCTCCGGCA" +
                "GGCAATTAAGGACAACGTAAGTATGGCGGATATAAACAGAGAAACGGGCGAATATACCTATTCGTATCGTATCGGTAAATAGCCTCGCGGAGGCATGTGCCATGCTAGCCTGCGGAGCACTCTAGTTATGCATATGGTCC" +
                "ACAGGACACTCGTCGCTTTCGGATTTGCCCTCTATGTGACGGTTTTTAGGCGCACTTATGCTCAGCACCGTTTAAACCAGACCGACACTAGATCTATAAGGTCCGCCACGCAGACGAGAGCGCACGGAGATCACCGAGCG" +
                "ATCTATCTGATCGGCGACCATTTGTGTGGTACTGGGGCCGAGAGGTAACTACGGTGCCGCTAACAACCTCTCGGTCGTCGCTGACGTTTGTAGTCTAGTCTCATTATGATCGTACGCTATTCAGGGATTGACTGATACCG" +
                "GAAGACATCTCAGTTGAAGTGGTGTATACGACAGAGACCGTGCACCTACCAAACCTCCTTAGTCTAAGTTCAGACCAATTGGTAGTTTGTCCAGAACTCAGATTTTATCACCAGAGGACGCACGCTCTACCTTTATGATC" +
                "CATTGATGTCCCTGAGGCTGCAATACATGCAACCAGGCAGTCTTCGCGGTAAGTCCTAGTGCAATGGGGCTTTTTTTCCTTGGTCCTCGAGAAGAGGAGACGTCAGTCCAGATATCTTTAATGTGGTAATTGGAAGGACT" +
                "CTTGGCCCTCCACCCTTAGGCAGTGTATACTCTTCCATAAACGGGCTATTAGTTATGGGGTCCGAAGATTGAAAAAGGTGAGCGAACTCGGCCGAACCGGAAAGACGGGCTTCAAAGCAACCTGACCACGGTTGCGCGTC" +
                "CGTATCAAGATCCTCTTAATAAGCCC";

        System.out.println(Arrays.toString(patternMatch(dna,"GTGGTGTATAC")));
    }
}
