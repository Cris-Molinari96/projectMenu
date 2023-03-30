package projectGroup;

import java.util.HashSet;
import java.util.Set;

public abstract class  Course {
    protected String name;
    protected String description;
    protected double price;
    protected HashSet<Allergens> allergens;
    protected MenuType mt ;
    protected CourseEnum ce;
    protected double calories;

    public Course(String name, Set<Allergens> allergens, String description,double calories,double price,MenuType mt) {
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.price = price;
        this.allergens = new HashSet<>(allergens);
        this.mt = mt ;
    }

    public Set<Allergens> getAllergens() {return this.allergens;}
    public String getName() {return this.name;}
    public MenuType getMt() {return mt;}
    public Course(CourseEnum ce) {this.ce = ce;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return this.description;}
    public void setDescription(String description) {this.description = description;}
    public double getCalories() {return calories;}

    public double getPrice() {return this.price;}
    public void setPrice(double price) {this.price = price;}
    public void setCe(CourseEnum ce) {this.ce = ce;}

    public void printInfo(){
        System.out.println("\t" + TextModifier.ANSI_BOLD + TextModifier.ANSI_RED + this.name + TextModifier.ANSI_RESET + " - " +this.price + "€\n" + TextModifier.ANSI_DESCRIPTION_COLOR_AND_BACKGROUND + TextModifier.ANSI_ITALIC + this.description + TextModifier.ANSI_RESET);
    };

    public void checkAllergens() {
        Set<Allergens> allergens = this.getAllergens();
        if (allergens.isEmpty()) {
            System.out.println(TextModifier.ANSI_RED + getName() + TextModifier.ANSI_RESET + " is safe to eat.");
        } else {
            System.out.print(TextModifier.ANSI_BRIGHT_YELLOW + "Warning: " + TextModifier.ANSI_RESET + TextModifier.ANSI_BRIGHT_RED + getName() + TextModifier.ANSI_RESET + " contains ");
            for (Allergens allergen : allergens) {
                System.out.print("["+allergen.getName() + "] ");
            }
        } System.out.println();
    }

   public abstract String printInfoClasse();
}
