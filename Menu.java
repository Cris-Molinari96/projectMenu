package projectGroup;

import java.util.*;
import java.util.stream.Collectors;

public class Menu {

    private List<Course> courseList;
    private List<Course> dailyMenu;
    private List<Course> childrenMenu;
    MenuType type = MenuType.MENU;

    public Menu() {
        dailyMenu = new ArrayList<>();
        courseList = new ArrayList<>();
        childrenMenu = new ArrayList<>();
    }

    public List<Course> getCourseList() {return courseList;}
    public List<Course> getDailyMenu() {return dailyMenu;}

    public void addCourse(Course s) {courseList.add(s);}
    public void addAllCourse(List<Course> courseList) {this.courseList.addAll(courseList);}

    // metodo random che mischia le portate in una nuova shufflesList e stampa in maniera casuale delle portate
    public HashSet<Course> popularCourses() {
        HashSet<Course> finalHashset = new HashSet<>();
        List<Course> shuffledCourseList = courseList.stream().filter(c -> c.getClass() != Beverage.class).collect(Collectors.toList());
        Collections.shuffle(shuffledCourseList);
        for (Course c : shuffledCourseList) {
            if (finalHashset.size() > 2) {
                break;
            } else {
                finalHashset.add(c);
                c.printInfo();
            }
        }
        return finalHashset;
    }

    public void printMenu() {
        System.out.println("\n\t" + TextModifier.ANSI_BRIGHT_RED + TextModifier.ANSI_BOLD + TextModifier.ANSI_UNDERLINE + type + " MENU" + TextModifier.ANSI_RESET + "\n");
        Course currentCourse = courseList.get(courseList.size() - 1);
        for (Course c : courseList) {
            if (currentCourse.getClass() != c.getClass()) {
                System.out.println("\n\t" + TextModifier.ANSI_UNDERLINE + TextModifier.ANSI_BOLD + TextModifier.ANSI_BRIGHT_RED + "\t" + c.getClass().getName() + TextModifier.ANSI_RESET);
                currentCourse = c;
            }
            c.printInfo();
            System.out.println();
        }
    }

    public void menuOfTheDay() {
        dailyMenu.clear();
        List<Course> shuffledList = courseList;
        Collections.shuffle(shuffledList);
        HashSet<Class<? extends Course>> classSet = new HashSet<>();
        for (Course c : shuffledList) {
            Class<? extends Course> courseClass = c.getClass();
            if (!classSet.contains(courseClass)) {
                dailyMenu.add(c);
                classSet.add(courseClass);
            }
        }
        double totalCost = 0;
        dailyMenu.sort(Comparator.comparingInt(a -> a.ce.order));
        for (Course c : dailyMenu) {
            c.printInfo();
            totalCost += c.getPrice();
        }
        totalCost = Math.floor(totalCost / 10) * 10;
        System.out.println("Total cost: " + totalCost + "€\n");
    }

    public void printMenuType(MenuType mt) {
        switch (mt) {
            case MEAT_MENU -> {
                type = MenuType.MEAT_MENU;
                System.out.println(TextModifier.ANSI_RED + " " + type + TextModifier.ANSI_RESET);
                meatMenu(20);
            }
            case FISH_MENU -> {
                type = MenuType.FISH_MENU;
                System.out.println(TextModifier.ANSI_RED + " " + type + TextModifier.ANSI_RESET);
                fishMenu(20);
            }
            case VEGAN_MENU -> {
                type = MenuType.VEGAN_MENU;
                System.out.println(TextModifier.ANSI_RED + " " + type + TextModifier.ANSI_RESET);
                veganMenu(20);
            }
            case FEW_KCAL_MENU -> {
                type = MenuType.FEW_KCAL_MENU;
                System.out.println(TextModifier.ANSI_RED + " " + type + TextModifier.ANSI_RESET);
                generateMenuFewKcal(20);
            }
            case CHILDREN_MENU -> {
                type = MenuType.CHILDREN_MENU;
                System.out.println(TextModifier.ANSI_RED + " " + type + TextModifier.ANSI_RESET);
                getChildrenMenu();
            }
        }
    }

    public List<Course> meatMenu(double sc) {
        boolean applyDiscount = true;
        List<Course> listMeatMenu = new ArrayList<>();
        List<Course> newList = new ArrayList<>();
        newList.addAll(courseList.stream().filter(c -> c.getMt() == MenuType.FISH_MENU).toList());
        newList.forEach(c -> listMeatMenu.add(c));
        listMeatMenu.forEach(c -> {
            System.out.print(TextModifier.ANSI_YELLOW + c.getClass().getName() + TextModifier.ANSI_RESET);
            c.printInfo();
        });
        double sumPrice = (calculatePriceMenu(listMeatMenu) / 100) * (100 - sc);
        if(applyDiscount){
            System.out.println("\n\tPrezzo menu scontato del " +sc +"%: " + sumPrice + "€" );
        }
        return listMeatMenu;
    }

    public List<Course> fishMenu(double sc) {
        boolean applyDiscount = false;
        List<Course> listMenuFish = new ArrayList<>();
        List<Course> newList = new ArrayList<>();
        newList.addAll(courseList.stream().filter(c -> c.getMt() == MenuType.FISH_MENU).toList());
        newList.forEach(c -> listMenuFish.add(c));
        listMenuFish.forEach(c -> {
            System.out.print(TextModifier.ANSI_YELLOW + c.printInfoClasse() + TextModifier.ANSI_RESET);
            c.printInfo();
        });
        double sumPrice = (calculatePriceMenu(listMenuFish) / 100) * (100 - sc);
        if(applyDiscount){
            System.out.println("\n\tPrezzo menu scontato del " +sc +"%: " + sumPrice + "€" );
        }
        return listMenuFish;
    }

    public List<Course> veganMenu(double sc) {
        boolean applyDiscount = false;
        List<Course> listVeganMenu = new ArrayList<>();
        List<Course> newList = new ArrayList<>();
        newList.addAll(courseList.stream().filter(c -> c.getMt() == MenuType.FISH_MENU).toList());
        newList.forEach(c -> listVeganMenu.add(c));
        listVeganMenu.forEach(c -> {
            System.out.print(TextModifier.ANSI_YELLOW + c.printInfoClasse() + TextModifier.ANSI_RESET);
            c.printInfo();
        });
        double sumPrice = (calculatePriceMenu(listVeganMenu) / 100) * (100 - sc);
        if (applyDiscount) {
            System.out.println("\n\tPrezzo menu scontato del " +sc +"%: " + sumPrice + "€" );
        }
        return listVeganMenu;
    }

    public List<Course> getChildrenMenu() {
        List<Course> shuffledList = new ArrayList<>();
        shuffledList.addAll( courseList.stream().filter(c -> c.getMt() == MenuType.CHILDREN_MENU)
                .toList());
        Collections.shuffle(shuffledList);
        HashSet<Class<? extends Course>> classSet = new HashSet<>();
        for (Course c : shuffledList) {
            Class<? extends Course> courseClass = c.getClass();
            if (!classSet.contains(courseClass)) {
                childrenMenu.add(c);
                classSet.add(courseClass);
            }
        }
        double totalCost = 0;
        // questo tipo di enum serve per mettere in maniera ordinata le portate in base all'enum
        childrenMenu.sort(Comparator.comparingInt(a -> a.ce.order));
        for (Course c : childrenMenu) {
            c.printInfo();
            totalCost += c.getPrice();
        }
        totalCost = Math.floor(totalCost / 10) * 10;
        System.out.println("Total cost: " + totalCost + "€\n");

        return childrenMenu;

    }

    public List<Course> generateMenuFewKcal(double sc) {
        boolean applyDiscount = true;
        List<Course> menuBasseCalorie = new ArrayList<>();
        boolean starterFound = false;
        boolean firstFound = false;
        boolean secondFound = false;
        boolean dessertFound = false;
        boolean beverageFound = false;
        for (Course c : courseList) {
            if (c.getClass().equals(Starters.class) && !starterFound) {
                if (c.getCalories() < 500) {
                    menuBasseCalorie.add(c);
                    starterFound = true;
                }
            } else if (c.getClass().equals(Firsts.class) && !firstFound) {
                if (c.getCalories() < 500) {
                    menuBasseCalorie.add(c);
                    firstFound = true;
                }
            } else if (c.getClass().equals(Seconds.class) && !secondFound) {
                if (c.getCalories() < 500) {
                    menuBasseCalorie.add(c);
                    secondFound = true;
                }
            } else if (c.getClass().equals(Desserts.class) && !dessertFound) {
                if (c.getCalories() < 500) {
                    menuBasseCalorie.add(c);
                    dessertFound = true;
                }
            } else if (c.getClass().equals(Beverage.class) && !beverageFound) {
                if (c.getCalories() < 500) {
                    menuBasseCalorie.add(c);
                    beverageFound = true;
                }
            }
        }
        double sumCalories = 0;
        for (Course c : menuBasseCalorie) {
            System.out.println(TextModifier.ANSI_YELLOW + c.printInfoClasse() + TextModifier.ANSI_RESET);
            c.printInfo();
            sumCalories += c.getCalories();
        }
        System.out.println("\nkcal in questo tipo menu: " + TextModifier.ANSI_RED + " " + sumCalories + " kcal" + TextModifier.ANSI_RESET);
        double sumPrice = (calculatePriceMenu(menuBasseCalorie) / 100) * (100 - sc);
        if(applyDiscount){
            System.out.println("\n\tPrezzo menu scontato del " +sc +"%: " + sumPrice + "€" );
        }

        return menuBasseCalorie;
    }

    public double calculatePriceMenu(List<Course>l){
        double sum = 0;
        for (Course list : l) {
            sum += list.getPrice();
        }
        System.out.println("\n\tPrezzo menu: "+sum + "€");
        return sum;
    }
}
