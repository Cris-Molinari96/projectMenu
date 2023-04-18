package projectGroup.course;

import projectGroup.enumRestaurant.AllergensEnum;
import projectGroup.enumRestaurant.CourseEnum;
import projectGroup.enumRestaurant.MenuTypeEnum;
import projectGroup.enumRestaurant.TextModifierEnum;

import java.util.HashSet;
import java.util.Set;

public abstract class  Course {
    protected String name;
    protected String description;
    protected double price;
    protected Set <AllergensEnum> allergens;
    protected MenuTypeEnum mt ;
    protected CourseEnum courseOrderType;
    protected double calories;

    public Course(String name, String description, double calories, double price, MenuTypeEnum mt, Set<AllergensEnum> allergens) {
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.price = price;
        this.allergens = new HashSet<>(allergens);
        this.mt = mt ;
    }

// * GETTER E SETTER
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public Set<AllergensEnum> getAllergens() {return allergens;}
    public void setAllergens(Set<AllergensEnum> allergens) {this.allergens = allergens;}

    public MenuTypeEnum getMt() {return mt;}
    public void setMt(MenuTypeEnum mt) {this.mt = mt;}

    public CourseEnum getCourseOrderType() {return courseOrderType;}
    public void setCourseOrderType(CourseEnum courseOrderType) {this.courseOrderType = courseOrderType;}

    public double getCalories() {return calories;}
    public void setCalories(double calories) {this.calories = calories;}

    // ! METODI

    /**
     * Print info classe, questo metodo,
     * richiamato in ogni classe stampa il nome, prezzo e descrizione della portata
     */
    public void printInfo(){
        System.out.println("\t" + TextModifierEnum.ANSI_BOLD + TextModifierEnum.ANSI_RED + this.name + TextModifierEnum.ANSI_RESET + " - " +this.price + "€\n" + TextModifierEnum.ANSI_DESCRIPTION_COLOR_AND_BACKGROUND + TextModifierEnum.ANSI_ITALIC + this.description + TextModifierEnum.ANSI_RESET);
    };
}
