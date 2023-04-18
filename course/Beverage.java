package projectGroup.course;

import projectGroup.enumRestaurant.AllergensEnum;
import projectGroup.enumRestaurant.CourseEnum;
import projectGroup.enumRestaurant.MenuTypeEnum;

import java.util.Set;

public class Beverage extends Course {
    private double milliliters;
    private boolean isAlcoholic;
    /**
     * @param name name of the Beverage
     * @param description description of the Beverage
     * @param milliliters  milliliters of each Beverage
     * @param calories of each beverage
     * @param price price of each Beverage
     * @param menu type
     * @param allergens
     */

    public Beverage(String name, String description, double milliliters, double calories, double price, MenuTypeEnum mt, Set<AllergensEnum> allergens, boolean isAlcoholic) {
        super(name, description, calories, price, mt, allergens);
        this.milliliters = milliliters;
        this.isAlcoholic = isAlcoholic;
        setCourseOrderType(CourseEnum.BEVERAGE);
    }
    // GETTER & SETTER
    public double getMilliliters() {return this.milliliters;}
    public void setMilliliters(double milliliters) {this.milliliters = milliliters;}

    public boolean isAlcoholic() {return isAlcoholic;}
    public void setAlcoholic(boolean alcoholic) {isAlcoholic = alcoholic;}

    // OVER
    @Override
    public void printInfo(){super.printInfo();}
}
