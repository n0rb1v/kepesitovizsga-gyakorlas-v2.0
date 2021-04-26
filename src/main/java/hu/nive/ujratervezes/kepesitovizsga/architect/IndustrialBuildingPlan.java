package hu.nive.ujratervezes.kepesitovizsga.architect;

public class IndustrialBuildingPlan implements Plan {
    private String projectName;
    private PlanType type;
    private int areaOfOfficeBlock;
    private int stock;
    private int areaOfManifacturingHall;

    public IndustrialBuildingPlan(String projectName, int areaOfOfficeBlock, int stock, int areaOfManifacturingHall) {
        this.projectName = projectName;
        this.areaOfOfficeBlock = areaOfOfficeBlock;
        this.stock = stock;
        this.areaOfManifacturingHall = areaOfManifacturingHall;
        this.type = PlanType.INDUSTRIAL;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public int calculateSquareMeter() {
        return (areaOfOfficeBlock * stock) + areaOfManifacturingHall;
    }

    @Override
    public PlanType getType() {
        return type;
    }

    public int getStock() {
        return stock;
    }

    public int getAreaOfOfficeBlock() {
        return areaOfOfficeBlock;
    }

    public int getAreaOfManufacturingHall() {
        return areaOfManifacturingHall;
    }
}
