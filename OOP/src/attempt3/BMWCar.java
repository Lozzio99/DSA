package attempt3;

public class BMWCar extends Brand implements Car
{
    @Override
    public int getWheels() {
        return numWheels;
    }
    @Override
    public String getBrandName()
    {
        return "BMW";
    }
}
