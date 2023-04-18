package projectGroup.restaurant;

import projectGroup.course.Course;
import projectGroup.enumRestaurant.MenuTypeEnum;
import projectGroup.enumRestaurant.TableStateEnum;
import projectGroup.enumRestaurant.TextModifierEnum;
import projectGroup.menu.Menu;

import java.util.*;

/**
 * Questa classe rappresenta un entità ristorante
 * un ristorante ha uno o più menu
 * tavoli per i clienti
 */
public class Ristorante {
// * FIELD
    private String name;
    private String address;
    private String typeRestaurant;
    private Menu menus;
    private HashMap<Table, Customer> tables;
    private double cashRegister;
// * CONSTRUCT

    /**
     * name ristorante
     * indirizzo ristorante
     * menus --> lista dei menu che sono presenti nel ristorante
     * tipo di ristorante --> italiano, indiano, cinese
     * i tavoli sono un hashMap
     */
    public Ristorante(){
        this.name = "Il Solito";
        this.menus = new Menu("Menu");
        this.address = "Via Marco Aurelio";
        this.typeRestaurant = "Italiano";
        this.tables = new HashMap<>();
        this.cashRegister = 0;
    }
// * GETTER & SETTER
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
    public String getTypeRestaurant() {return typeRestaurant;}
    public void setTypeRestaurant(String typeRestaurant) {this.typeRestaurant = typeRestaurant;}
    public Menu getMenus() {return menus;}
    public void setMenus(Menu menus) {this.menus = menus;}
    public HashMap<Table, Customer> getTables() {return tables;}
    public void setTables(HashMap<Table, Customer> tables) {this.tables = tables;}
    public double getCashRegister() {return cashRegister;}
    public void setCashRegister(double cashRegister) {this.cashRegister = cashRegister;}
    // ! METHOD

    /* *That method print the info of ristorante, name, address, type*/
    public void printInfoRisto() {System.out.println("\n\tMenu " + this.name + ":\n");}

    /* *Add una portata al menu */
    public void addCourseMenu(Course c) {menus.addCourse(c);}

    /* *Add una lista di portate (firsts course) al menu*/
    public void addAllCourseMenu(List<Course> c) {menus.addAllCourse(c);}

    /* * method that generate a type of menu with plus courses
     * you can choose the course  */
    public List<Course> chooseCourseMenuType(MenuTypeEnum menuType) {
        List<Course> listToReturn = new ArrayList<>();
        for (Course course : menus.getCourseList()) {
            if (course.getMt().equals(menuType) || course.getMt().equals(MenuTypeEnum.MENU)) {
                listToReturn.add(course);
            }
        }
        listToReturn.sort(Comparator.comparingInt(a -> a.getCourseOrderType().getOrder()));
        listToReturn.forEach(c -> {
            System.out.print(TextModifierEnum.ANSI_GREEN + c.getClass().getSimpleName() + ": " + TextModifierEnum.ANSI_RESET);
            c.printInfo();
            System.out.println();
        });
        return listToReturn;
    }

    /**
     * that method can print of menu with only one course
     */
    public List<Course> generateAMenuType(MenuTypeEnum menuTypeEnum) {
        return menus.generateMenuType(menuTypeEnum);
    }

    /**
     * Adds a course to the order of the customer
     * only if the customer sit in the table, and it's a course of the menu type he chose
     */
    public void addCourseToCustomer(Course course, Customer customer) {
        if (tables.containsValue(customer) && (course.getMt() == customer.getMenuType() || course.getMt() == MenuTypeEnum.LIST_BEVERAGE)) {
            customer.addOrderedCourses(course);
            for (Table table : tables.keySet()){
                tables.put(table, customer);
            }
        } else {
            System.out.println("Can't add course to the customer");
        }
    }

    /* * Adds a table to the table map of the Restaurant*/
    public void addTable(Table table) {
        tables.put(table, null);
    }

    /* * Remove table*/
    public void removeTable(Table table) {
        boolean removeTable = false;
        for (Table t : tables.keySet()) {
            if (table.equals(t)) {
                tables.remove(table);
                removeTable = true;
            }
        }
        if (!removeTable) {
            System.out.println(TextModifierEnum.ANSI_RED + "table not found");
        }
    }

    /**
     * This method books an available table for a customer
     * takes an input method that returns the list of all available tables
     * @param table          Table the customer wants to book
     * @param customer       Customer that wants to book the table
     * @param numberOfPeople number of people in the group of the customer
     */
    public void bookATable(Table table, Customer customer, int numberOfPeople) {
        List<Table> tableListAvailable = listOfAvailableTables();
        if (table.getTableState() == TableStateEnum.AVAILABLE) {
            if (table.getNumberOfSeats() < numberOfPeople) {
                System.out.println("The table n° " + table.getId() + " is not suited for the group");
                generateTable(numberOfPeople, tableListAvailable);
            } else {
                table.bookTable(customer);
                tables.put(table, customer);
                System.out.println(TextModifierEnum.ANSI_GREEN + "You have booked with success"+ TextModifierEnum.ANSI_RESET);
            }
        } else {
            System.out.println("\n" + TextModifierEnum.ANSI_RED + "This table is already book!" + TextModifierEnum.ANSI_RESET + " Table number: " + table.getId());
            for (Table t : tableListAvailable) {
                int numberDiPostiInPiu = t.getNumberOfSeats() - numberOfPeople;
                if (numberDiPostiInPiu == 0 || (numberDiPostiInPiu>= 0 && numberDiPostiInPiu <= 2)) {
                    System.out.println(TextModifierEnum.ANSI_GREEN + "You can book this table:" + TextModifierEnum.ANSI_RESET);
                    t.printInfo();
                }
                // TODO implementare un feedBack che nessun'tavolo disponibile al momento
            }
        }
    }

    /**
     * That method print the table having available seats
     * @param numberOfPeople
     * @param tableList
     */
    private void generateTable(int numberOfPeople, List<Table> tableList) {
        for (Table t : tableList) {
            int numberDiPostiInPiu = t.getNumberOfSeats() - numberOfPeople;
            if (numberDiPostiInPiu == 0 || (numberDiPostiInPiu>= 0 && numberDiPostiInPiu <= 2)) {
                t.printInfo();
                System.out.println();
            }
        }
    }

    /* *  Return a list of all available tables*/
    public List<Table> listOfTablesFree(int numberOfPeople) {
        List<Table> tableList = new ArrayList<>();
        for (Table table : tables.keySet()) {
            if (table.getTableState().equals(TableStateEnum.OCCUPIED) || numberOfPeople > table.getNumberOfSeats())
                continue;
            else {
                tableList.add(table);
            }
        }
            if (tableList.size() == 0) {
                System.out.println("No tables available at the moment");
            }
            return tableList;
    }

    /* * Check if free table*/
    public void freeTable(Table table, double discount) {
        if (table.getTableState().equals(TableStateEnum.OCCUPIED)) {
            Customer customer = tables.get(table);
            tableCheck(customer, discount);
            table.freeTable();
            tables.put(table, null);
        }
    }

    /**
     *
     * @return
     */
    public void tableCheck(Customer customer, double discount){
        List<Course> coursesCustomer = customer.getOrderedCourses();
        double billToPay = customer.calculateBill(coursesCustomer, discount);
        cashRegister += billToPay;
        System.out.println("Bill customer:°" + customer.getId() + " = " + billToPay + "€");
        if(discount > 0){
            System.out.println("Applied discount " + discount + "%");
        }
    }

    /* * Prints the list of all the available tables*/
    public List<Table> listOfAvailableTables() {
        List<Table> tableList = new ArrayList<>();
//        System.out.println("\nAVAILABLE TABLES:\n");
        for (Table table : tables.keySet()) {
            if (table.getTableState() == TableStateEnum.AVAILABLE) {
                tableList.add(table);
            }
        }
        return tableList;
    }

    /* * print all table available*/
    public void printAvailableTables() {
        List<Table> tableList = new ArrayList<>();
        System.out.println("\nAVAILABLE TABLES:\n");
        for (Table table : tables.keySet()) {
            if (table.getTableState() == TableStateEnum.AVAILABLE) {
                tableList.add(table);
                table.printInfo();
                System.out.println();
            }
        }
    }

    /* * That method print all tables available*/
    public void printAvailableTable() {
        for (Table t : tables.keySet()) {
            if (t.getTableState().equals(TableStateEnum.AVAILABLE)) {
                System.out.println();
                t.printInfo();
            }
        }
    }

    /* * That method print all tables occupied*/
    public void printOccupiedTables() {
        System.out.println("\nOCCUPIED TABLES:\n");
        for (Table table : tables.keySet()) {
            if (table.getTableState() == TableStateEnum.OCCUPIED) {
                table.printInfo();
                System.out.println();
            }
        }
    }

    /* * print info table*/
    public void printInfoTable() {
        for (Table table : tables.keySet()) {
            table.printInfo();
            System.out.println();
        }
    }
}
