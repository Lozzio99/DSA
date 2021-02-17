package attempt;

public abstract class Brand
{

    private Brands logo ;

    public Brand(Brands logo)
    {
        this.logo = logo;
    }

    String getBrandName() {
        if (this.logo == null) return "Free market";
        return switch (this.logo) {
            case BMW -> "BMW";
            case VW -> "MW";

        };
    }
}
