package projectGroup.menu;

import projectGroup.course.Course;
import projectGroup.enumRestaurant.AllergensEnum;
import projectGroup.enumRestaurant.MenuTypeEnum;
import projectGroup.enumRestaurant.TextModifierEnum;

import java.util.*;

public class Menu {

    private List<Course> courseList;
    private List<Course> currentMenu;
    private String nameMenu;

    public Menu(String nameMenu) {
        this.nameMenu = nameMenu ;
        this.courseList = new ArrayList<>();
        this.currentMenu = new ArrayList<>();
    }

    // * GETTER E SETTER
    public List<Course> getCourseList() {return courseList;}
    public void setCourseList(List<Course> courseList) {this.courseList = courseList;}

    public String getNameMenu() {return nameMenu;}
    public void setNameMenu(String nameMenu) {this.nameMenu = nameMenu;}

    public List<Course> getCurrentMenu() {return currentMenu;}
    public void setCurrentMenu(List<Course> currentMenu) {this.currentMenu = currentMenu;}

    public void addCourse(Course s) {courseList.add(s);}
    public void addAllCourse(List<Course> courseList) {this.courseList.addAll(courseList);}
    public void addCourseToMenu(Menu menu){}
    // ! METODI
//print menu con get.class
    public void printMenu() {
        System.out.println("\n\t" + TextModifierEnum.ANSI_BRIGHT_RED + TextModifierEnum.ANSI_BOLD + TextModifierEnum.ANSI_UNDERLINE + this.nameMenu + "'s MENU" + TextModifierEnum.ANSI_RESET + "\n");
        Course currentCourse = courseList.get(courseList.size() - 1);
        for (Course c : courseList) {
            if (currentCourse.getClass() != c.getClass()) {
                System.out.println("\n\t" + TextModifierEnum.ANSI_UNDERLINE + TextModifierEnum.ANSI_BOLD + TextModifierEnum.ANSI_BRIGHT_RED + "\t" + c.getClass().getName() + TextModifierEnum.ANSI_RESET);
                currentCourse = c;
            }
            c.printInfo();
            System.out.println();
        }
    }
    /**
     * questo metodo, mi serve per generare una lista random di portate, secondo questa logica:
     * creo una nuova lista, menu la quale viene rimescolata
     * creo un hashset dentro il quale viene aggiunto un tipo univoco di classe, questo mi permette di aggiungere una singola protata per ogni classe
     * ordino la lista secondo l'ordine di portata.
     */
    public List<Course> generateMenuType(MenuTypeEnum menuTypeEnum) {
        System.out.println("" + TextModifierEnum.ANSI_BOLD + TextModifierEnum.ANSI_BRIGHT_YELLOW +
                TextModifierEnum.ANSI_UNDERLINE + menuTypeEnum.getStringMenu()  + TextModifierEnum.ANSI_RESET);
        List<Course>shuffle = courseList;
        Collections.shuffle(shuffle);
        double priceMenu = calculatePriceMenu();
        double sumKcal = calculateKcal();
        HashSet<Class<?extends Course>> classSet = new HashSet<>();
        for (Course c : shuffle){
            Class<?extends Course> currentClass = c.getClass();
            if(!classSet.contains(currentClass)){
                currentMenu.add(c);
                classSet.add(currentClass);
            }
        }
        currentMenu.sort(Comparator.comparingInt(c -> c.getCourseOrderType().order));
        currentMenu.forEach(c ->  {
            System.out.print(TextModifierEnum.ANSI_GREEN + c.getClass().getSimpleName() + ": " + TextModifierEnum.ANSI_RESET);
            c.printInfo();
        });
        System.out.println("\n\tPrezzo menu: "+ calculatePriceMenu() + "€");
        if(calculateKcal()< 2000){
            System.out.println(TextModifierEnum.ANSI_GREEN + "\n\tKcal menu: "+ calculateKcal() + "kcal" + TextModifierEnum.ANSI_RESET);
        }else{
            System.out.println(TextModifierEnum.ANSI_RED + "\n\tKcal menu: "+ calculateKcal() + "kcal"+ TextModifierEnum.ANSI_RESET);
        }
        return currentMenu;
    }
    /**
     * that method check if menu contains allergens
     * @return
     */
    public HashSet<AllergensEnum> checkAllergens() {
    HashSet<AllergensEnum> newHash = new HashSet<>();
    for ( Course c : currentMenu) {
    if(c.getAllergens().equals(AllergensEnum.NONE)){
        System.out.println("Allergeni non presenti");
    }else{
        c.getAllergens().forEach(a -> newHash.add(a));
    }
    }
    System.out.print("Attenzione allergeni presenti: [ ");
    newHash.forEach(a -> System.out.print(a.getNameAllergens() + ", "));
    System.out.print(" ]");
    return newHash;
    }
    /**
    * method that apply a discount for current menu
     */
    public void calculateAndApplyDiscount(double discount) {
        double priceMenu = 0;
        for (Course c : currentMenu) {
            priceMenu += c.getPrice();
        }
        System.out.println("\n\tPrice menu discounted:" + TextModifierEnum.ANSI_GREEN + " " +
                Math.floor((priceMenu / 100) * (100 - discount)) + "€" + TextModifierEnum.ANSI_RESET);
    }
    /**
     * method that return  the price of menu
     */
    public double calculatePriceMenu(){
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        for (Course c : currentMenu) {
            sum += c.getPrice();
        }
        return Math.floor(sum);
    }
    /**
     * method that return the sumKcal in the menu
     */
    private double calculateKcal(){
        double sumKcal = 0 ;
        for (Course c : currentMenu){
            sumKcal  +=c.getCalories();
        }
        return Math.floor(sumKcal);
    }
}
