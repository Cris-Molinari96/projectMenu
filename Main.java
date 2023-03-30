package projectGroup;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // - STARTERS
        Course ffc = new Starters("Forever Fried Chicken Calamari", Set.of(Allergens.SHELLFISH), "Enjoy a classic fried chicken dish with a twist, featuring calamari in a light batter for a unique flavor combination. Perfect for sharing or as an individual meal.", 500, 400,69.69, MenuType.FISH_MENU);
        Course pineDuck = new Starters("Pineapple Duck Carpaccio", Set.of(Allergens.NONE),"Thinly sliced duck carpaccio served on a bed of fresh pineapple, drizzled with a sweet and tangy balsamic glaze", 400, 200,3.50, MenuType.MENU);
        Course typicalHam = new Starters("Typical Vigezzino Ham with Sweet and Sour Skewers", Set.of(Allergens.SOY), "Marinated Vigezzino ham skewers, grilled to perfection and served with a sweet and sour glaze", 450,800, 4.00, MenuType.MENU);
        Course carneSalada = new Starters("Carne Salada with Wheat Flakes and Sour Mushrooms", Set.of(Allergens.CEREALS_CONTAINING_GLUTEN), "Tender carne salada, served with crunchy wheat flakes, sour mushrooms and a light tomato sauce", 450,120, 3.50, MenuType.MEAT_MENU);
        Course salmon = new Starters("Norwegian Salmon with 5 Cereal Crostini and Flambéed Shrimps with Cognac", Set.of(Allergens.FISH, Allergens.SHELLFISH, Allergens.CEREALS_CONTAINING_GLUTEN), "Pan-seared Norwegian salmon, served with a medley of five cereal crostini and flambéed shrimps with cognac", 550, 200 ,8.00, MenuType.FISH_MENU);
        Course lamb = new Starters("Breaded and Crispy Lamb Bites", Set.of(Allergens.CEREALS_CONTAINING_GLUTEN), "Bite-sized pieces of tender lamb, breaded and fried to a golden crisp. Served with a tangy garlic mayo dip", 500, 440,2.50, MenuType.MENU);
        Course hamPorcini = new Starters("Typical Vigezzino Ham with Porcini Mushrooms and Walnut Salad", Set.of(Allergens.NUTS), "Thinly sliced Vigezzino ham, served with a robust porcini mushroom and walnut salad", 400,312, 6.00, MenuType.MENU);
        Course vegangStarterCourse = new Starters("kale chips, pumpkin and potatoes", Set.of(Allergens.KALE, Allergens.PUMPKIN, Allergens.POTATOES), "kale chips, pumpkin and potatoes", 120,240,5.0, MenuType.MENU);

        // - FIRSTS
        Course genovese = new Firsts("Genovese", Set.of(Allergens.DAIRY, Allergens.CEREALS_CONTAINING_GLUTEN),"Traditional Ligurian dish made with slow-cooked onions, served with a fragrant basil pesto sauce and freshly grated Parmesan cheese.", 8.50, 160,12.99 , MenuType.MENU);
        Course carbonara = new Firsts("Carbonara", Set.of(Allergens.DAIRY, Allergens.EGG, Allergens.CEREALS_CONTAINING_GLUTEN),"A classic Roman pasta dish, featuring spaghetti in a creamy sauce made with eggs, pancetta, and Pecorino Romano cheese.", 9.00, 160, 12.99, MenuType.MENU);
        Course gricia = new Firsts("Gricia", Set.of(Allergens.DAIRY, Allergens.CEREALS_CONTAINING_GLUTEN),"A simple but flavorful pasta dish from Rome, featuring bucatini pasta in a sauce made with pork jowl, Pecorino Romano cheese, and black pepper.", 10, 120,14.99 , MenuType.MENU);
        Course amatriciana = new Firsts("Amatriciana", Set.of(Allergens.DAIRY, Allergens.CEREALS_CONTAINING_GLUTEN),"Hearty pasta dish from the town of Amatrice, featuring bucatini pasta in a tangy tomato sauce with cured pork cheek and Pecorino Romano cheese.", 10, 130,10.99 , MenuType.MEAT_MENU);
        Course orecchiette = new Firsts("Orecchiette broccoli and sausage", Set.of(Allergens.CEREALS_CONTAINING_GLUTEN),"Ear-shaped pasta from Puglia, tossed with tender broccoli florets, savory sausage, garlic, and olive oil.", 8, 120, 7.99, MenuType.MENU);
        Course tagliatelle = new Firsts("Tagliatelle with white meat sauce and frutti di mare", Set.of(Allergens.CEREALS_CONTAINING_GLUTEN, Allergens.DAIRY),"Ribbon-shaped pasta in a rich and creamy sauce made with tender white meat, Parmesan cheese, and a hint of nutmeg.", 7, 150, 18.99, MenuType.FISH_MENU);
        Course veganFirstCourse = new Firsts("Lentil ragout", Set.of(Allergens.LENTIL), "Lentil ragout", 400, 200, 15.99, MenuType.VEGAN_MENU);
        Course firtstChildren = new Firsts("Pasta with sauce", Set.of(Allergens.NONE),"Classic pasta with sauce and basil",500,200,7.99, MenuType.CHILDREN_MENU);

        // - SECONDS
        Course florentine = new Seconds("Rare Florentine", Set.of(Allergens.CEREALS_CONTAINING_GLUTEN),"Tender and juicy classic steak with a delicious char on the outside, served with roasted vegetables and crispy potatoes.", 20, 1000, 17.99, MenuType.MEAT_MENU);
        Course wagyu = new Seconds("Wagyu", Set.of(Allergens.DAIRY),"Luxurious premium cut cooked to perfection, served with creamy mashed potatoes and steamed green beans.", 30, 400, 18.99, MenuType.MENU);
        Course kangarooSausage = new Seconds("Kangaroo Sausage", Set.of(Allergens.NONE),"Unique and flavorful sausage made with lean, tender kangaroo meat, served with sauerkraut and homemade mustard.", 25, 750, 20.99, MenuType.MENU);
        Course meatRolls = new Seconds("Meat Rolls", Set.of(Allergens.CEREALS_CONTAINING_GLUTEN),"Hearty and delicious appetizer with seasoned ground beef wrapped in crispy pastry, served with tomato dipping sauce.", 15, 300,12.59 , MenuType.MENU);
        Course beefTartare = new Seconds("Beef Tartare",  Set.of(Allergens.CEREALS_CONTAINING_GLUTEN),"Indulgent dish made with fresh high-quality beef, seasoned to perfection and served with toasted bread and mixed greens.", 24, 300,21.99, MenuType.MEAT_MENU);
        Course hamburger = new Seconds("Hamburger",  Set.of(Allergens.CEREALS_CONTAINING_GLUTEN),"Classic 100% beef burger with traditional toppings, satisfying and affordable.", 12, 220,22.00, MenuType.MEAT_MENU);
        Course veganSecondCourse = new Seconds("Spiced Carrot Falafel", Set.of(Allergens.LENTIL), "Spiced Carrot Falafel", 400, 200, 15.99, MenuType.VEGAN_MENU );
        Course cutletPotatoes = new Seconds("chicken cutlet with a portion of fries", Set.of(Allergens.NONE),"classic fried or baked chicken cutlet with fries",400,700,13.99, MenuType.CHILDREN_MENU);

        // - DESSERTS
        Course appleCake = new Desserts("Apple cake", Set.of(Allergens.DAIRY, Allergens.CEREALS_CONTAINING_GLUTEN), "American apple pie", 1.000, 220,12.99, MenuType.FISH_MENU);
        Course tiramisu = new Desserts("Tiramisù", Set.of(Allergens.DAIRY, Allergens.EGG), "Dessert with coffe, biscuits, cocoa", 1.000, 200,10.99, MenuType.CHILDREN_MENU);
        Course saltyChocolate = new Desserts("Salty chocolate ice cream", Set.of(Allergens.DAIRY), "Ice-cream with chocolate fondant and milk chocolate", 500, 250,8.99, MenuType.VEGETARIAN_MENU);
        Course sacherTorte = new Desserts("Sachertorte", Set.of(Allergens.DAIRY, Allergens.EGG, Allergens.CEREALS_CONTAINING_GLUTEN), "Dessert with lemon cream", 700, 250,9.99, MenuType.MEAT_MENU);
        Course composeYourDessert = new Desserts("Compose your dessert", Set.of(Allergens.CARROT, Allergens.SPICED), "Spiced Carrot Falafel", 400, 650, 19.99, MenuType.MENU);
        Course tiramisuVegano = new Desserts("Tiramisù", Set.of(Allergens.DAIRY), "Dessert vegan, with coffe, biscuits, cocoa", 1.000, 200,15.99, MenuType.VEGAN_MENU);

        // - BEVERAGES
        Course stillWater = new Beverage("Still Water",Set.of(Allergens.NONE), "Refreshing and hydrating still water in a one-liter bottle.", 1000,250, 1.00, MenuType.MENU);
        Course sparklingWater = new Beverage("Sparkling Water", Set.of(Allergens.NONE), "Fizzy and invigorating sparkling water in a one-liter bottle.", 1000, 250,1.00, MenuType.MENU);
        Course cocacola = new Beverage("Coca Cola", Set.of(Allergens.NONE),"Classic and delicious Coca-Cola in a 33cl bottle.", 330, 250,2.00, MenuType.CHILDREN_MENU);
        Course fanta = new Beverage("Fanta", Set.of(Allergens.NONE),"Fruity and refreshing Fanta in a 33cl bottle.", 330,250, 2.00, MenuType.MENU);
        Course sprite = new Beverage("Sprite", Set.of(Allergens.NONE),"Lemon-lime flavored and thirst-quenching Sprite in a 33cl bottle.", 330,250, 2.00, MenuType.MENU);
        Course redDraughtBeer = new Beverage("Red Draught Beer", Set.of(Allergens.NONE),"Rich and flavorful red draught beer served in a 0.4-liter glass.", 400,250, 4, MenuType.MENU);
        Course blondeDraughtBeer = new Beverage("Blonde Draught Beer", Set.of(Allergens.NONE),"Crisp and refreshing blonde draught beer served in a 0.4-liter glass.", 400, 250,3.5, MenuType.MENU);
        Course redWine = new Beverage("Red Wine", Set.of(Allergens.NONE),"Smooth and full-bodied red wine served in a 50ml glass.", 50,250, 5, MenuType.MENU);
        Course whiteWine = new Beverage("White Wine", Set.of(Allergens.NONE),"Light and refreshing white wine served in a 50ml glass.", 50, 250,5, MenuType.MENU);
        Course Mojito = new Beverage("Mojito", Set.of(Allergens.NONE),"A classic cocktail made with rum, sugar, lime juice, soda water, and mint leaves. Refreshing and perfect for warm weather.", 130, 250,7, MenuType.MENU);
        Course oldFashioned = new Beverage("Old Fashioned", Set.of(Allergens.NONE),"A sophisticated cocktail made with whiskey, sugar, bitters, and water or soda. Perfect as an after-dinner drink.", 130, 250,7, MenuType.MENU);
        Course whiskeySour = new Beverage("Whiskey Sour", Set.of(Allergens.NONE),"A tangy and refreshing cocktail made with whiskey, lemon juice, and sugar. Great for any occasion.", 130, 250,7, MenuType.MENU);
        Course negroni = new Beverage("Negroni", Set.of(Allergens.NONE),"A complex and bitter cocktail made with gin, vermouth, and Campari. Perfect as an aperitif.", 130, 250,7, MenuType.MENU);
        Course whiteRussian = new Beverage("White Russian ", Set.of(Allergens.NONE),"A rich and creamy cocktail made with vodka, coffee liqueur, and cream. Perfect as a dessert drink.", 130, 250,7, MenuType.MENU);

        //MENU
        Menu menu = new Menu();

        List<Course> beverageList = Arrays.asList(stillWater, sparklingWater, cocacola, fanta, sprite, redDraughtBeer, blondeDraughtBeer, redWine, whiteWine, Mojito, oldFashioned, whiskeySour, negroni, whiteRussian);
        List<Course> startersList = Arrays.asList(ffc, pineDuck, typicalHam, carneSalada, salmon, lamb, hamPorcini,vegangStarterCourse);
        List<Course> firstsList = Arrays.asList(genovese, carbonara, gricia, amatriciana, orecchiette, tagliatelle,veganFirstCourse,firtstChildren);
        List<Course> secondsList = Arrays.asList(florentine, wagyu, kangarooSausage, meatRolls, beefTartare, hamburger,veganSecondCourse,cutletPotatoes);
        List<Course> dessertsList = Arrays.asList(appleCake, tiramisu, saltyChocolate, sacherTorte, composeYourDessert,tiramisuVegano);

        menu.addAllCourse(startersList);
        menu.addAllCourse(firstsList);
        menu.addAllCourse(secondsList);
        menu.addAllCourse(dessertsList);
        menu.addAllCourse(beverageList);

//        menu.printMenu();

//        menu.menuOfTheDay();

        // ! print menu tipo
//        menu.printMenuType(MenuType.MEAT_MENU);
//        menu.printMenuType(MenuType.FISH_MENU);
//        menu.printMenuType(MenuType.VEGAN_MENU);
//        menu.printMenuType(MenuType.FEW_KCAL_MENU);
//        menu.printMenuType(MenuType.CHILDREN_MENU);
//        menu.printMenuType(MenuType.FEW_KCAL_MENU);
    }
}
//