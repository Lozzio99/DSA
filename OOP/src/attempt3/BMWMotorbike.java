package attempt3;

public class BMWMotorbike extends Brand implements Motorbike
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
