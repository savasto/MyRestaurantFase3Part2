//Fase 3:
//
//Un cop els clients han acabat de menjar, poden anar sortint del restaurant.
//
//Preguntem a l’usuari quina taula vol sortir i marxa tot el grup sencer.
//
//Mai pot marxar més gent de la que hi ha al grup.
//
//
//Fase 4:
//
//A partir d’ara, el restaurant posa a disposició dels clients taules.
// Una taula té una capacitat màxima de 6 persones, és a dir, hi ha 4 taules.

import java.util.Scanner;

public class Main {
    private static final int ADD_PEOPLE = 1;
    private static final int REMOVE_PEOPLE = 2;

    public static void main(String[] args) throws Exception {
        Restaurant restaurant = createRestaurant();
        int option = chooseOption();
        managePeopleOnRestaurant(restaurant, option);
    }

    private static void managePeopleOnRestaurant(Restaurant restaurant, int option) throws Exception {
        if (option == ADD_PEOPLE) {
            addPeopleToRestaurant(restaurant);
        }
        if (option == REMOVE_PEOPLE) {
            removePeopleFromRestaurant(restaurant);
        }

    }

    private static void removePeopleFromRestaurant(Restaurant restaurant) throws Exception {

        while (restaurant.getRemainingSeats() > 0 && askUserWantsToRemoveClient()) {
            removeTableOnRestaurant(restaurant);
            showHowManyPeopleOnRestaurant(restaurant);
        }
    }

    private static void removeTableOnRestaurant(Restaurant restaurant) throws Exception {
        // int table = askwhichTableWantsToRemove();
        //restaurant.removeTableOnIndex(table)
        int pos = askWhichTableWantsToRemove();
        restaurant.removeTableOnIndex(pos - 1);//para contar correcto
    }

    private static int askWhichTableWantsToRemove() {
        System.out.println(" What table do you want to remove?");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static boolean askUserWantsToRemoveClient() {
        System.out.println("Do you want to remove clients? (Y/N)");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().equalsIgnoreCase("Y");
    }

    private static int chooseOption() {
        System.out.println(" Do you want to add or remove clients? 1 - add, 2- remove ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void addPeopleToRestaurant(Restaurant restaurant) throws Exception {
        while (restaurant.getRemainingSeats() > 0 && askUserWantsToEnterClient()) {
            assignPeopleToRestaurant(restaurant);
            showHowManyPeopleOnRestaurant(restaurant);
        }
    }

    private static boolean askUserWantsToEnterClient() {
        System.out.println("Do you want to add clients? (Y/N)");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().equalsIgnoreCase("Y");
        //String text = sc.nextLine();
        // boolean result = text.equalsIgnoreCase("S");
        //return result;
    }

    private static void showHowManyPeopleOnRestaurant(Restaurant restaurant) {
        int remainingSeats = restaurant.getRemainingSeats();
        System.out.println(restaurant.getName() + " now has " + remainingSeats + " free seats from "
                + restaurant.getMaxCapacity() + "total seats");
        System.out.println("Tables: \n " + restaurant.printTablesStatus());
    }

    private static void assignPeopleToRestaurant(Restaurant restaurant) throws Exception {
        int numOfPeople = askForHowManyPeopleToEnter();
        restaurant.addClients(numOfPeople);
    }

    private static int askForHowManyPeopleToEnter() {
        System.out.println(" How many persons want to enter?");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static Restaurant createRestaurant() throws Exception {
        // String name = askForRestaurantName();
        //Restaurant restaurant = new Restaurant(name);
        String name = askForRestaurantName();
        int type = askForTypeOfRestaurant();
        return new Restaurant(name, type);
    }

    private static int askForTypeOfRestaurant() {
        System.out.println("Restaurant type: PIZZA -1, KEBAB -2, CHINO - 3 ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String askForRestaurantName() {
        System.out.println("Restaurant name: ");
        Scanner sc = new Scanner(System.in);
        // String text = sc.nextLine();
        // return text.equalsIgnoreCase("");
        return sc.nextLine();
    }
}

