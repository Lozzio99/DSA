package attempt;

public abstract class Vehicle extends Brand
{

    private Vehicles type;

    // doesn't make any sense to make it instanciable
    // can't return num of wheels if the
    public Vehicle(Brands logo)
    {
        super(logo);
    }

    public Vehicle(Vehicles type)
    {
        super(null);
        this.type = type;
    }

    public Vehicle (Brands logo, Vehicles type)
    {
        this(logo);
        this.type = type;
    }
    public int getWheels()
    {
        if (this.type.equals(Vehicles.CAR))
            return 4;
        return 2;
    }

    @Override
    public String getBrandName()
    {
        return super.getBrandName();
    }
}
