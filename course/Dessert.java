package projectGroup.course;

import projectGroup.enumRestaurant.AllergensEnum;
import projectGroup.enumRestaurant.CourseEnum;
import projectGroup.enumRestaurant.MenuTypeEnum;

import java.util.Set;

public class Dessert extends Course {
    private double weight;

    /**
     * @param name of the dessert
     * @param description of dessert
     * @param weight of dessert
     * @param calories of each dessert
     * @param price of dessert
     * @param menu type
     * @param allergens
     */
    public Dessert(String name, String description, double weight, double calories, double price, MenuTypeEnum mt, Set<AllergensEnum> allergens) {
        super(name, description, calories, price, mt, allergens);
        this.weight = weight;
        setCourseOrderType(CourseEnum.DESSERTS);
    }
    // GETTER & SETTER
    public double getWeightDessert(){return weight;}
    public void setWeight(double weight) {this.weight = weight;}
    // OVER
    @Override
    public void printInfo(){super.printInfo();}
}