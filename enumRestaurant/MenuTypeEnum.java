package projectGroup.enumRestaurant;

public enum MenuTypeEnum {
    MENU("Menu of day"),
    FISH_MENU("Fish menu"),
    MEAT_MENU("Meat menu"),
    VEGAN_MENU("Vegan menu"),
    CHILDREN_MENU("Children menu"),
    FEW_KCAL_MENU("Low kcal menu"),
    LIST_BEVERAGE("Beverage List");
    public String menu;

    MenuTypeEnum(String menu){
        this.menu = menu ;
    }
    public String getStringMenu() {return menu;}
}
