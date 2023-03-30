package projectGroup;

import java.util.Set;

public class Beverage extends Course {
    private double milliliters;

    /**
     * @param name name of the Beverage
     * @param description description of the Beverage
     * @param milliliters  milliliters of each Beverage
     * @param price price of each Beverage
     *
     */

    public Beverage(String name, Set<Allergens> allergens, String description, double milliliters, double calories, double price, MenuType mt) {
        super(name, allergens,description, calories,price,mt);
        this.milliliters = milliliters;
        setCe(CourseEnum.BEVERAGE);
    }

    public double getMilliliters() {return this.milliliters;}
    public void setMilliliters(double milliliters) {this.milliliters = milliliters;}

    @Override
    public void printInfo(){super.printInfo();}
    @Override
    public String printInfoClasse() {return "Beverage:";}

}
