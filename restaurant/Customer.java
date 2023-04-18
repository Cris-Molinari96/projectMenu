package projectGroup.restaurant;

import projectGroup.course.Course;
import projectGroup.enumRestaurant.MenuTypeEnum;
import projectGroup.menu.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe rappresenta un entità cliente
 */
public class Customer {
// * FIELD
    private static int idCounter = 0;
    private int id;
    private String name;
    private MenuTypeEnum menuType;
    private String mail;
    private String password;
    private boolean isVip;
    private List<Course> orderedCourses;
    private double bill;
// * CONSTRUCT
    public Customer(String name, MenuTypeEnum menuType, String mail, String password) {
        this.id = ++idCounter;
        this.name = name;
        this.menuType = menuType;
        this.mail = mail;
        this.password = password;
        this.orderedCourses = new ArrayList<>();
        this.bill = 0;

    }
// * GETTER & SETTER
    public int getId() {return this.id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}
    public MenuTypeEnum getMenuType() {return this.menuType;}
    public void setMenuType(MenuTypeEnum menuType) {this.menuType = menuType;}
    public String getMail() {return this.mail;}
    public void setMail(String mail) {this.mail = mail;}
    public String getPassword() {return this.password;}
    public void setPassword(String password) {this.password = password;}
    public boolean isVip() {return this.isVip;}
    public void setVip(boolean vip) {isVip = vip;}
    public List<Course> getOrderedCourses() {return orderedCourses;}
    public void setOrderedCourses(List<Course> orderedCourses) {this.orderedCourses = orderedCourses;}
    // ! METHOD
    /**
     * That method print the info of customer
     */
    public void printInfo(){
        System.out.println(this.name + " " + this.menuType + " menu\n" + this.mail + "\nIs VIP: " + this.isVip);
    }
    public void addOrderedCourses(Course c ){orderedCourses.add(c);}
    public void addListOrderedCourses(List<Course> c ){orderedCourses.addAll(c);}

/* *Return menuPrice and if you want to apply a discount*/
    public double calculateBill(List<Course> orderedCourses, double discount){
        for (Course course : orderedCourses) {
            bill += course.getPrice();
        }
        return Math.floor((bill / 100)*(100-discount));
    }
}
