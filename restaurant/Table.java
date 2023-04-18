package projectGroup.restaurant;

import org.w3c.dom.Text;
import projectGroup.enumRestaurant.MenuTypeEnum;
import projectGroup.enumRestaurant.TableStateEnum;
import projectGroup.enumRestaurant.TextModifierEnum;

/**
 * Classe tavolo, tramite questa class è possibile prenotare un tavolo
 */
public class Table {
// * FIELD
    public static int idCounter = 0 ;
    private int id ;
    private Customer customer; // --> cliente che deve prenotare un tavolo
    private MenuTypeEnum menuType; // --> possiamo impostare un tipo menu per quel tipo di tavolo
    private TableStateEnum tableState; // --> stato del tavolo (occupato,libero)
    private int numberOfSeats; // --> numero posti a sedere
// * CONSTRUCT
    public Table(int numberOfSeats) {
        this.id = ++idCounter;
        this.numberOfSeats = numberOfSeats;
        this.customer = null;
        this.tableState = TableStateEnum.AVAILABLE;
        this.menuType = null;
    }
// * GETTER & SETTER
    public static int getIdCounter() {return idCounter;}
    public static void setIdCounter(int idCounter) {Table.idCounter = idCounter;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public Customer getCustomer() {return customer;}
    public void setCustomer(Customer customer) {this.customer = customer;}

    public MenuTypeEnum getMenuType() {return menuType;}
    public void setMenuType(MenuTypeEnum menuType) {this.menuType = menuType;}

    public TableStateEnum getTableState() {return tableState;}
    public void setTableState(TableStateEnum tableState) {this.tableState = tableState;}

    public int getNumberOfSeats() {return numberOfSeats;}
    public void setNumberOfSeats(int numberOfSeats) {this.numberOfSeats = numberOfSeats;}
// ! METHOD
    /**
     * that method setta il tavolo, quindi impostando un menu per quel tavolo e un cliente
     * settando anche lo stato del tavolo su occupato
     */
    public void bookTable(Customer c){
        setTableState(TableStateEnum.OCCUPIED);
        setMenuType(c.getMenuType());
        setCustomer(c);
        System.out.println(TextModifierEnum.ANSI_GREEN + "Table book with success!!\n" + TextModifierEnum.ANSI_RESET +
               "Info Table: [ \n\tNumber Table: " + this.id + "\n\tName: " + c.getName() + "\n]");
    }
    /**
     * that method set available the table,
     */
    public void freeTable(){
        setMenuType(null);
        setCustomer(null);
        setTableState(TableStateEnum.AVAILABLE);
    }

    public void printInfo(){
        if(this.customer == null){
            System.out.println(TextModifierEnum.ANSI_GREEN + "Table n° " + this.id + "\n" + "Table state: Empty\nNumber of seats: " + this.numberOfSeats + TextModifierEnum.ANSI_RESET);
        } else {
            System.out.println(TextModifierEnum.ANSI_RED + "Table n° " + this.id + "\n" + "Table state: " + tableState + "\nNumber of seats: " + this.numberOfSeats + TextModifierEnum.ANSI_RESET);
        }
    }
}
