public class Money<Integer> implements Compare<Integer>
{

    @Override
    public boolean equal(Integer e, Integer f) {
        int i = (int )e;
        int h = (int) f;
        return i==h;
    }

    @Override
    public boolean smaller(Integer e, Integer f)
    {
        int i = (int )e;
        int h = (int) f;
        return i<h;
    }
}
