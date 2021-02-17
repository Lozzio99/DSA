public class StringCount
{
    int count = 0;
    public int count(String s, char c, int i)
    {
        if (i >= s.length())
        {
            int res = count;
            count = 0;
            return res;
        }
        if (s.charAt(i) == c)
            count++;
        return count(s,c,i+1);
    }
}