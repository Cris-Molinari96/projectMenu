package projectGroup.course;

import projectGroup.enumRestaurant.AllergensEnum;
import projectGroup.enumRestaurant.CourseEnum;
import projectGroup.enumRestaurant.MenuTypeEnum;

import java.util.Set;

public class First extends Course {
    private double weight;

    /**
     * @param name First's name
     * @param description First's description
     * @param weight First's weight
     * @param calories of first
     * @param price First's price
     * @param menu Type
     * @param allergens
     */

    public First(String name, String description, double weight, double calories, double price, MenuTypeEnum mt, Set<AllergensEnum> allergens) {
        super(name, description, calories, price, mt, allergens);
        this.weight = weight;
        setCourseOrderType(CourseEnum.FIRSTS);
    }
    // GETTER SETTER
    public double getWeight() {return weight;}
    public void setWeight(double weight) {this.weight = weight;}
    //OVER
@Override
    public void printInfo() {super.printInfo();}
}
