package attempt2;

public abstract class Car implements Vehicle,Brand
{
    @Override
    public int getWheels() {
        return 4;
    }

    @Override
    public String getBrandName() {
        return "null";
    }
}
