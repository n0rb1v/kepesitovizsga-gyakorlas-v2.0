package hu.nive.ujratervezes.kepesitovizsga.architect;

public class ResidentialBuildingPlan implements Plan {
    private String projectName;
    private PlanType type;
    private House house;
    private int stock;
    private int area;

    public ResidentialBuildingPlan(String projectName, House house, int stock, int area) {
        this.projectName = projectName;
        this.house = house;
        this.stock = stock;
        this.area = area;
        this.type = PlanType.RESIDENTIAL;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public int calculateSquareMeter() {
        return area * stock;
    }

    @Override
    public PlanType getType() {
        return type;
    }

    public House getHouse() {
        return house;
    }

    public int getStock() {
        return stock;
    }

    public int getArea() {
        return area;
    }
}
