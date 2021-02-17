package attempt2;

public abstract class Motorbike implements Vehicle, Brand
{
    @Override
    public int getWheels() {
        return 2;
    }

    @Override
    public String getBrandName() {
        return null;
    }
}
