package projectGroup.enumRestaurant;

public enum AllergensEnum {

    CEREALS_CONTAINING_GLUTEN("Gluten"),
    EGG("Egg"),
    SHELLFISH("Shellfish"),
    CELERY("Celery"),
    MUSTARD("Mustard"),
    NUTS("Nuts"),
    PEANUTS("Peanuts"),
    SESAME_SEEDS("Sesame Seeds"),
    SOY("Soy"),
    LUPIN("Lupin"),
    MOLLUSCS("Molluscs"),
    FISH("Fish"),
    DAIRY("Dairy"),
    SULPHITES("Sulphites"),
    PUMPKIN("Pumpkin"),
    POTATOES("Potatoes"),
    KALE("Kale"),
    LENTIL("Lentil"),
    CARROT("Carrot "),
    SPICED("Spiced"),
    NONE("Nessun allergene");

    protected String name;

    AllergensEnum(String name) {
        this.name = name;
    }

    public String getNameAllergens() {return name;}
}
