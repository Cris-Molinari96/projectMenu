package projectGroup.enumRestaurant;

public enum CourseEnum {
    // richiamato nei costruttori delle classi, ordinano secondo la squenza di portate
    STARTERS("Starter", 0),
    FIRSTS("First", 20),
    SECONDS("Second", 40),
    DESSERTS("Dessert", 60),
    BEVERAGE("Beverage", 80);

    public String name;
    public int order;

    CourseEnum(String name, int order){
        this.name = name;
        this.order = order;
    }
    public String getName() {return this.name;}
    public int getOrder() {return this.order;}
}