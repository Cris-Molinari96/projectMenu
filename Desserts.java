package projectGroup;

import java.util.Set;

public class Desserts extends Course {
    private double weight;
    private double discount;


    /**
     * @param name name of the dessert
     * @param description description of dessert
     * @param weight weight of dessert
     * @param price price of dessert
     */
    public Desserts(String name, Set<Allergens> allergens, String description, double weight, double calories, double price, MenuType mt) {
        super(name, allergens,description, calories,price,mt);
        this.weight = weight;
        setCe(CourseEnum.DESSERTS);
    }
    public double getWeightDessert(){return weight;}
    // set and get per sconto
    public double getDiscount() {return discount;}
    public void setDiscount(double discount) {this.discount = discount;}

    @Override
    public void printInfo(){super.printInfo();}
    @Override
    public String printInfoClasse() {return "Desserts:";}
}