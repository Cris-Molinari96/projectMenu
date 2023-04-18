package projectGroup.course;

import projectGroup.enumRestaurant.AllergensEnum;
import projectGroup.enumRestaurant.CourseEnum;
import projectGroup.enumRestaurant.MenuTypeEnum;

import java.util.Set;
public class Starter extends Course {
    private double weight ;
    /**
     * @param name Starter's name
     * @param allergens Set of allergens
     * @param description Starter's description
     * @param calories calories of the Starter
     * @param price price of the Starter
     */

    public Starter(String name, String description, double weight, double calories, double price, MenuTypeEnum mt, Set<AllergensEnum> allergens) {
        super(name, description, calories, price, mt, allergens);
        this.weight = weight;
        setCourseOrderType(CourseEnum.STARTERS);
    }
    // GETTER & SETTER
    public double getWeight() {return weight;}
    public void setWeight(double weight) {this.weight = weight;}
    // OVER
    @Override
    public void printInfo(){super.printInfo();}
}

