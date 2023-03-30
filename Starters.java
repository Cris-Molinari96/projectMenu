package projectGroup;

import java.util.Set;
public class Starters extends Course {
    private double weight ;
    /**
     * @param name Starter's name
     * @param allergens Set of allergens
     * @param description Starter's description
     * @param calories calories of the Starter
     * @param price price of the Starter
     */

    public Starters(String name, Set<Allergens> allergens, String description, double weight, double calories, double price, MenuType mt) {
        super(name, allergens,description,calories, price,mt);
        this.weight = weight;
        setCe(CourseEnum.STARTERS);
    }
    public Starters(String name, String description, double weight, double calories, double price, MenuType mt) {
        super(name, description, calories,price,mt);
        this.weight = weight;
        setCe(CourseEnum.STARTERS);
    }

    public double getWeight() {return weight;}

    @Override
    public void printInfo(){super.printInfo();}
    @Override
    public String printInfoClasse() {return "Starters";}
}
