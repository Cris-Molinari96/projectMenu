package projectGroup;

import java.util.Set;

public class Firsts extends Course {
    private double weight;

    /**
     * @param name First's name
     * @param description First's description
     * @param price First's price
     * @param weight First's weight
     */

    public Firsts(String name, Set<Allergens> allergens, String description, double weight, double calories, double price, MenuType mt) {
        super(name, allergens,description,calories, price,mt);
        this.weight = weight;
        setCe(CourseEnum.FIRSTS);
    }

    public void setWeight(double weight) {this.weight = weight;}

@Override
    public void printInfo() {super.printInfo();}

    @Override
    public String printInfoClasse() {return "Firsts:";}

}
