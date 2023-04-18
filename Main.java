package projectGroup;

import projectGroup.course.*;
import projectGroup.enumRestaurant.AllergensEnum;
import projectGroup.enumRestaurant.MenuTypeEnum;
import projectGroup.menu.Menu;
import projectGroup.menu.MenuController;
import projectGroup.restaurant.Customer;
import projectGroup.restaurant.Ristorante;
import projectGroup.restaurant.Table;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // - STARTERS
        Course ffc = new Starter("Forever Fried Chicken Calamari", "Enjoy a classic fried chicken dish with a twist, featuring calamari in a light batter for a unique flavor combination. Perfect for sharing or as an individual meal.", 500, 400, 69.69, MenuTypeEnum.FISH_MENU, Set.of(AllergensEnum.SHELLFISH));
        Course pineDuck = new Starter("Pineapple Duck Carpaccio", "Thinly sliced duck carpaccio served on a bed of fresh pineapple, drizzled with a sweet and tangy balsamic glaze", 400, 200, 3.50, MenuTypeEnum.MENU, Set.of(AllergensEnum.NONE));
        Course typicalHam = new Starter("Typical Vigezzino Ham with Sweet and Sour Skewers", "Marinated Vigezzino ham skewers, grilled to perfection and served with a sweet and sour glaze", 450, 800, 4.00, MenuTypeEnum.MEAT_MENU, Set.of(AllergensEnum.SOY));
        Course carneSalada = new Starter("Carne Salada with Wheat Flakes and Sour Mushrooms", "Tender carne salada, served with crunchy wheat flakes, sour mushrooms and a light tomato sauce", 450, 120, 3.50, MenuTypeEnum.MEAT_MENU, Set.of(AllergensEnum.CEREALS_CONTAINING_GLUTEN));
        Course salmon = new Starter("Norwegian Salmon with 5 Cereal Crostini and Flambéed Shrimps with Cognac", "Pan-seared Norwegian salmon, served with a medley of five cereal crostini and flambéed shrimps with cognac", 550, 200, 8.00, MenuTypeEnum.FISH_MENU, Set.of(AllergensEnum.FISH, AllergensEnum.SHELLFISH, AllergensEnum.CEREALS_CONTAINING_GLUTEN));
        Course lamb = new Starter("Breaded and Crispy Lamb Bites", "Bite-sized pieces of tender lamb, breaded and fried to a golden crisp. Served with a tangy garlic mayo dip", 500, 440, 2.50, MenuTypeEnum.MEAT_MENU, Set.of(AllergensEnum.CEREALS_CONTAINING_GLUTEN));
        Course hamPorcini = new Starter("Typical Vigezzino Ham with Porcini Mushrooms and Walnut Salad", "Thinly sliced Vigezzino ham, served with a robust porcini mushroom and walnut salad", 400, 312, 6.00, MenuTypeEnum.FISH_MENU, Set.of(AllergensEnum.NUTS));
        Course vegangStarterCourse = new Starter("kale chips, pumpkin and potatoes", "kale chips, pumpkin and potatoes", 120, 240, 5.0, MenuTypeEnum.VEGAN_MENU, Set.of(AllergensEnum.KALE, AllergensEnum.PUMPKIN, AllergensEnum.POTATOES));

        // - FIRSTS
        Course genovese = new First("Genovese", "Traditional Ligurian dish made with slow-cooked onions, served with a fragrant basil pesto sauce and freshly grated Parmesan cheese.", 8.50, 160, 12.99, MenuTypeEnum.FISH_MENU, Set.of(AllergensEnum.DAIRY, AllergensEnum.CEREALS_CONTAINING_GLUTEN));
        Course carbonara = new First("Carbonara", "A classic Roman pasta dish, featuring spaghetti in a creamy sauce made with eggs, pancetta, and Pecorino Romano cheese.", 9.00, 160, 12.99, MenuTypeEnum.VEGAN_MENU, Set.of(AllergensEnum.DAIRY));
        Course gricia = new First("Gricia", "A simple but flavorful pasta dish from Rome, featuring bucatini pasta in a sauce made with pork jowl, Pecorino Romano cheese, and black pepper.", 10, 120, 14.99, MenuTypeEnum.MEAT_MENU, Set.of(AllergensEnum.DAIRY));
        Course amatriciana = new First("Amatriciana", "Hearty pasta dish from the town of Amatrice, featuring bucatini pasta in a tangy tomato sauce with cured pork cheek and Pecorino Romano cheese.", 10, 130, 10.99, MenuTypeEnum.MEAT_MENU, Set.of(AllergensEnum.DAIRY));
        Course orecchiette = new First("Orecchiette broccoli and sausage", "Ear-shaped pasta from Puglia, tossed with tender broccoli florets, savory sausage, garlic, and olive oil.", 8, 120, 7.99, MenuTypeEnum.MENU, Set.of(AllergensEnum.CEREALS_CONTAINING_GLUTEN));
        Course tagliatelle = new First("Tagliatelle with white meat sauce and frutti di mare", "Ribbon-shaped pasta in a rich and creamy sauce made with tender white meat, Parmesan cheese, and a hint of nutmeg.", 7, 150, 18.99, MenuTypeEnum.FISH_MENU, Set.of(AllergensEnum.CEREALS_CONTAINING_GLUTEN));
        Course veganFirstCourse = new First("Lentil ragout", "Lentil ragout", 400, 200, 15.99, MenuTypeEnum.VEGAN_MENU, Set.of(AllergensEnum.LENTIL));
        Course firtstChildren = new First("Pasta with sauce", "Classic pasta with sauce and basil", 500, 200, 7.99, MenuTypeEnum.CHILDREN_MENU, Set.of(AllergensEnum.NONE));

        // - SECONDS
        Course florentine = new Second("Rare Florentine", "Tender and juicy classic steak with a delicious char on the outside, served with roasted vegetables and crispy potatoes.", 20, 1000, 17.99, MenuTypeEnum.MEAT_MENU, Set.of(AllergensEnum.CEREALS_CONTAINING_GLUTEN));
        Course wagyu = new Second("Wagyu", "Luxurious premium cut cooked to perfection, served with creamy mashed potatoes and steamed green beans.", 30, 400, 18.99, MenuTypeEnum.FISH_MENU, Set.of(AllergensEnum.DAIRY));
        Course kangarooSausage = new Second("Kangaroo Sausage", "Unique and flavorful sausage made with lean, tender kangaroo meat, served with sauerkraut and homemade mustard.", 25, 750, 20.99, MenuTypeEnum.MENU, Set.of(AllergensEnum.NONE));
        Course meatRolls = new Second("Meat Rolls", "Hearty and delicious appetizer with seasoned ground beef wrapped in crispy pastry, served with tomato dipping sauce.", 15, 300, 12.59, MenuTypeEnum.MEAT_MENU, Set.of(AllergensEnum.CEREALS_CONTAINING_GLUTEN));
        Course beefTartare = new Second("Beef Tartare", "Indulgent dish made with fresh high-quality beef, seasoned to perfection and served with toasted bread and mixed greens.", 24, 300, 21.99, MenuTypeEnum.MEAT_MENU, Set.of(AllergensEnum.CEREALS_CONTAINING_GLUTEN));
        Course salmonTartare = new Second("Salmon Tartare", "Indulgent dish made with fresh high-quality beef, seasoned to perfection and served with toasted bread and mixed greens.", 24, 300, 21.99, MenuTypeEnum.FISH_MENU, Set.of(AllergensEnum.CEREALS_CONTAINING_GLUTEN));
        Course hamburger = new Second("Hamburger", "Classic 100% beef burger with traditional toppings, satisfying and affordable.", 12, 220, 22.00, MenuTypeEnum.MEAT_MENU, Set.of(AllergensEnum.CEREALS_CONTAINING_GLUTEN));
        Course veganSecondCourse = new Second("Spiced Carrot Falafel", "Spiced Carrot Falafel", 400, 200, 15.99, MenuTypeEnum.VEGAN_MENU, Set.of(AllergensEnum.LENTIL));
        Course cutletPotatoes = new Second("chicken cutlet with a portion of fries", "classic fried or baked chicken cutlet with fries", 400, 700, 13.99, MenuTypeEnum.CHILDREN_MENU, Set.of(AllergensEnum.NONE));

        // - DESSERTS
        Course appleCake = new Dessert("Apple cake", "American apple pie", 1.000, 220, 12.99, MenuTypeEnum.MEAT_MENU, Set.of(AllergensEnum.DAIRY));
        Course tiramisu = new Dessert("Tiramisù", "Dessert with coffe, biscuits, cocoa", 1.000, 200, 10.99, MenuTypeEnum.FISH_MENU, Set.of(AllergensEnum.DAIRY));
        Course saltyChocolate = new Dessert("Salty chocolate ice cream", "Ice-cream with chocolate fondant and milk chocolate", 500, 250, 8.99, MenuTypeEnum.CHILDREN_MENU, Set.of(AllergensEnum.DAIRY));
        Course sacherTorte = new Dessert("Sachertorte", "Dessert with lemon cream", 700, 250, 9.99, MenuTypeEnum.FISH_MENU, Set.of(AllergensEnum.DAIRY));
        Course composeYourDessert = new Dessert("Compose your dessert", "Spiced Carrot Falafel", 400, 650, 19.99, MenuTypeEnum.FISH_MENU, Set.of(AllergensEnum.CARROT));
        Course tiramisuVegano = new Dessert("Tiramisù", "Dessert vegan, with coffe, biscuits, cocoa", 1.000, 200, 15.99, MenuTypeEnum.VEGAN_MENU, Set.of(AllergensEnum.DAIRY));

        // - BEVERAGES
        Course stillWater = new Beverage("Still Water", "Refreshing and hydrating still water in a one-liter bottle.", 1000, 250, 1.00, MenuTypeEnum.LIST_BEVERAGE, Set.of(AllergensEnum.NONE), false);
        Course sparklingWater = new Beverage("Sparkling Water", "Fizzy and invigorating sparkling water in a one-liter bottle.", 1000, 250, 1.00, MenuTypeEnum.LIST_BEVERAGE, Set.of(AllergensEnum.NONE), false);
        Course cocacola = new Beverage("Coca Cola", "Classic and delicious Coca-Cola in a 33cl bottle.", 330, 250, 2.00, MenuTypeEnum.LIST_BEVERAGE, Set.of(AllergensEnum.NONE), false);
        Course fanta = new Beverage("Fanta", "Fruity and refreshing Fanta in a 33cl bottle.", 330, 250, 2.00, MenuTypeEnum.LIST_BEVERAGE, Set.of(AllergensEnum.NONE), false);
        Course sprite = new Beverage("Sprite", "Lemon-lime flavored and thirst-quenching Sprite in a 33cl bottle.", 330, 250, 2.00, MenuTypeEnum.LIST_BEVERAGE, Set.of(AllergensEnum.NONE), false);
        Course redDraughtBeer = new Beverage("Red Draught Beer", "Rich and flavorful red draught beer served in a 0.4-liter glass.", 400, 250, 4, MenuTypeEnum.LIST_BEVERAGE, Set.of(AllergensEnum.NONE), true);
        Course blondeDraughtBeer = new Beverage("Blonde Draught Beer", "Crisp and refreshing blonde draught beer served in a 0.4-liter glass.", 400, 250, 3.5, MenuTypeEnum.LIST_BEVERAGE, Set.of(AllergensEnum.NONE), true);
        Course redWine = new Beverage("Red Wine", "Smooth and full-bodied red wine served in a 50ml glass.", 50, 250, 5, MenuTypeEnum.LIST_BEVERAGE, Set.of(AllergensEnum.NONE), true);
        Course whiteWine = new Beverage("White Wine", "Light and refreshing white wine served in a 50ml glass.", 50, 250, 5, MenuTypeEnum.LIST_BEVERAGE, Set.of(AllergensEnum.NONE), true);
        Course Mojito = new Beverage("Mojito", "A classic cocktail made with rum, sugar, lime juice, soda water, and mint leaves. Refreshing and perfect for warm weather.", 130, 250, 7, MenuTypeEnum.LIST_BEVERAGE, Set.of(AllergensEnum.NONE), true);
        Course oldFashioned = new Beverage("Old Fashioned", "A sophisticated cocktail made with whiskey, sugar, bitters, and water or soda. Perfect as an after-dinner drink.", 130, 250, 7, MenuTypeEnum.LIST_BEVERAGE, Set.of(AllergensEnum.NONE), true);
        Course whiskeySour = new Beverage("Whiskey Sour", "A tangy and refreshing cocktail made with whiskey, lemon juice, and sugar. Great for any occasion.", 130, 250, 7, MenuTypeEnum.LIST_BEVERAGE, Set.of(AllergensEnum.NONE), true);
        Course negroni = new Beverage("Negroni", "A complex and bitter cocktail made with gin, vermouth, and Campari. Perfect as an aperitif.", 130, 250, 7, MenuTypeEnum.LIST_BEVERAGE, Set.of(AllergensEnum.NONE), true);
        Course whiteRussian = new Beverage("White Russian ", "A rich and creamy cocktail made with vodka, coffee liqueur, and cream. Perfect as a dessert drink.", 130, 250, 7, MenuTypeEnum.LIST_BEVERAGE, Set.of(AllergensEnum.NONE), true);

        Ristorante ilSolito = new Ristorante();

        List<Course> startersList = Arrays.asList(ffc, pineDuck, typicalHam, carneSalada, salmon, lamb, hamPorcini, vegangStarterCourse);
        List<Course> firstsList = Arrays.asList(genovese, carbonara, gricia, amatriciana, orecchiette, tagliatelle, veganFirstCourse, firtstChildren);
        List<Course> secondsList = Arrays.asList(florentine, wagyu, salmonTartare, kangarooSausage, meatRolls, beefTartare, hamburger, veganSecondCourse, cutletPotatoes);
        List<Course> dessertsList = Arrays.asList(appleCake, tiramisu, saltyChocolate, sacherTorte, composeYourDessert, tiramisuVegano);
        List<Course> beverageList = Arrays.asList(stillWater, sparklingWater, cocacola, fanta, sprite, redDraughtBeer, blondeDraughtBeer, redWine, whiteWine, Mojito, oldFashioned, whiskeySour, negroni, whiteRussian);

        ilSolito.addAllCourseMenu(startersList);
        ilSolito.addAllCourseMenu(firstsList);
        ilSolito.addAllCourseMenu(secondsList);
        ilSolito.addAllCourseMenu(dessertsList);
        ilSolito.addAllCourseMenu(beverageList);

        Customer cris = new Customer("Cristian",MenuTypeEnum.FISH_MENU,"cris.m@libero.it","12345678");
        Customer dario = new Customer("Dario",MenuTypeEnum.MEAT_MENU,"dario.p@libero.it","abc222");
        Table tavolo1 = new Table(2);
        Table tavolo2 = new Table(2);
        Table tavolo3 = new Table(4);
        Table tavolo4 = new Table(6);
        Table tavolo5 = new Table(8);
        Table tavolo6 = new Table(10);
        Table tavolo7 = new Table(12);

        ilSolito.addTable(tavolo1);
        ilSolito.addTable(tavolo2);
        ilSolito.addTable(tavolo3);
        ilSolito.addTable(tavolo4);
        ilSolito.addTable(tavolo5);
        ilSolito.addTable(tavolo6);
        ilSolito.addTable(tavolo7);

        ilSolito.bookATable(tavolo4, cris, 6);

        ilSolito.addCourseToCustomer(ffc,cris);
        ilSolito.addCourseToCustomer(genovese,cris);
        ilSolito.addCourseToCustomer(sacherTorte,cris);
        ilSolito.addCourseToCustomer(stillWater,cris);

        ilSolito.freeTable(tavolo4,0);

    }
}