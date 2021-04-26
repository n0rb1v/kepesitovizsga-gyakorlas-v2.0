package hu.nive.ujratervezes.kepesitovizsga.architect;

public interface Plan {
    public String getProjectName();
    public int calculateSquareMeter();
    public PlanType getType();
}
