package projectGroup.course;

import projectGroup.enumRestaurant.AllergensEnum;
import projectGroup.enumRestaurant.CourseEnum;
import projectGroup.enumRestaurant.MenuTypeEnum;

import java.util.Set;


public class Second extends Course {
    private double weight;
    /**
     *
     * @param name name of the seconds
     * @param description description of the seconds
     * @param weight weight of seconds
     * @param calories of seconds
     * @param price price of seconds
     * @param menu Type of menu
     * @param allergens of seconds
     */

    public Second(String name, String description, double weight, double calories, double price, MenuTypeEnum mt, Set<AllergensEnum> allergens) {
        super(name, description, calories, price, mt, allergens);
        this.weight = weight;
        setCourseOrderType(CourseEnum.SECONDS);
    }
    // GETTER & SETTER
    public double getWeight() {return this.weight;}
    public void setWeight(double weight) {this.weight = weight;}
    // OVER
    @Override
    public void printInfo(){ super.printInfo(); }
}
