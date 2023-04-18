package projectGroup.menu;

import projectGroup.course.Beverage;
import projectGroup.course.Course;
import projectGroup.enumRestaurant.MenuTypeEnum;

import java.util.*;

public class MenuController {
    private List<Course> fullMenu;

    public MenuController() {
        this.fullMenu = new ArrayList<>();
    }

    public List<Course> getFullMenu() {return fullMenu;}
    public void setFullMenu(List<Course> fullMenu) {this.fullMenu = fullMenu;}

    public void addAllCourse(List<Course> c){fullMenu.addAll(c);}

    public List<Course> generateMeatMenu() {
        List<Course> meatMenu = new ArrayList<>();
        meatMenu.addAll(fullMenu.stream().filter(c -> c.getMt().equals(MenuTypeEnum.MEAT_MENU)).toList());
        addAllDrink(meatMenu);
        return meatMenu;
    }

    public List<Course> generateFishMenu() {
        List<Course> fishMenu = new ArrayList<>();
        fishMenu.addAll(fullMenu.stream().filter(c -> c.getMt().equals(MenuTypeEnum.FISH_MENU)).toList());
        addAllDrink(fishMenu);
        return fishMenu;
    }

    public List<Course> generateChildrenMenu() {
        List<Course> childrenMenu = new ArrayList<>();
        childrenMenu.addAll(fullMenu.stream().filter(c -> c.getMt().equals(MenuTypeEnum.CHILDREN_MENU)).toList());
        addAllDrink(childrenMenu);
        return childrenMenu;
    }

    public List<Course> generateVeganMenu() {
        List<Course> veganMenu = new ArrayList<>();
        veganMenu.addAll(fullMenu.stream().filter(c -> c.getMt().equals(MenuTypeEnum.VEGAN_MENU)).toList());
        addAllDrink(veganMenu);
        return veganMenu;
    }

    public List<Course> generateFewKcalMenu() {
        List<Course> fewKcalMenu = new ArrayList<>();
        fewKcalMenu.addAll(fullMenu.stream().filter(c -> c.getCalories() < 500).toList());
        return fewKcalMenu;
    }

    public void addAllDrink(List<Course> currentMenu) {
        for (Course beverage : fullMenu) {
            if (beverage.getClass() == Beverage.class) {
                currentMenu.add(beverage);
            }
        }
    }
}
