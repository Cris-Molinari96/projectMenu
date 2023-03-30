package projectGroup;

public enum CourseEnum {
    STARTERS("Starter", 0),
    FIRSTS("First", 20),
    SECONDS("Second", 40),
    DESSERTS("Dessert", 60),
    BEVERAGE("Beverage", 80);

    String name;
    int order;

    CourseEnum(String name, int order){
        this.name = name;
        this.order = order;
    }
}