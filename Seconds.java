package projectGroup;

import java.util.Set;


public class Seconds extends Course {
    private double weight;
    private double calories;
    /**
     *
     * @param name name of the seconds
     * @param description description of the seconds
     * @param price price of seconds
     * @param weight weight of seconds
     */

    public Seconds(String name, Set<Allergens> allergens, String description, double weight,double calories, double price,MenuType mt) {
        super(name, allergens,description,calories,price,mt);
        this.weight = weight;
        setCe(CourseEnum.SECONDS);
    }
    public Seconds(String name, String description, double weight,double calories, double price,MenuType mt) {
        super(name, description,calories, price,mt);
        this.weight = weight;
        setCe(CourseEnum.SECONDS);
    }

    public double getWeight() {return this.weight;}

    @Override
    public void printInfo(){ super.printInfo(); }
    @Override
    public String printInfoClasse() {return "Seconds:";}

}
