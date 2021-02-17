package attempt;

public class testUnit
{
    public static void main (String [] args)
    {
        BMWCar m8 = new BMWCar(Brands.BMW, Vehicles.CAR);
        BMWMotorcycle hp4 = new BMWMotorcycle(Brands.BMW, Vehicles.MOTORCYCLE);
        VWCar mheight = new VWCar(Brands.VW, Vehicles.CAR);
        VWMotorcycle hpfour = new VWMotorcycle(Brands.VW, Vehicles.MOTORCYCLE);
        test(m8);
        test(hp4);
        test(mheight);
        test(hpfour);
    }
    static void test(Vehicle vehicle)
    {
        System.out.println(vehicle.getWheels());
        System.out.println(vehicle.getBrandName());
    }

}
