import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static final int MAX_CAPACITY = 24;
    private static final int MAX_NUMBER_OF_TABLES = 4;
    private String name;
    private int type;

    private static final int PIZZA = 1;
    private static final int KEBAB = 2;
    private static final int CHINO = 3;

    private List<Table> tables = new ArrayList<>();

    public Restaurant(String name, int type) throws Exception {
        checkName(name);
        checkType(type);
        this.name = name;
        this.type = type;

    }

    private void checkType(int type) throws Exception {
        if (type != PIZZA && type != KEBAB && type != CHINO)
            throw new Exception("Wrong type");
    }

    private void checkName(String name) throws Exception {
        if (name.equals("")) throw new Exception();
    }

    public int getCurrentSeatings() {//!!!!
        //int people=0;
        int result = 0;
        for (Table table : tables) {
            result += table.getCurrentSeatings();
            //people+=numOfPeople;
        }
        return result;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }


    public int getRemainingSeats() {
        return MAX_CAPACITY - getCurrentSeatings();
    }

    public void addClients(int numOfPeople) throws Exception {
        checkPeopleCanEnter(numOfPeople);
//from createTable method
        while (numOfPeople > 0 && hasRemainingTables()) {
            Table table = new Table();
            numOfPeople = table.addClients(numOfPeople);// crear taula i add
            tables.add(table);
        }
        //es lo mismo que
        // Table table = new Table();
        //            int peopleRemaining = table.addClients(numOfPeople);// crear taula i add
        //            tables.add(table);
       if(numOfPeople>0)throw new Exception("No more free tables");

    }

    private boolean hasRemainingTables() {
return this.tables.size()<MAX_NUMBER_OF_TABLES;
    }

    // private Table createTable(int numOfPeople) throws Exception {
//        Table table = new Table();
//        int peopleRemaining = table.addClients(numOfPeople);
//        return table;
    // }

    private void checkPeopleCanEnter(int numOfPeople) throws Exception {
        if ((this.getCurrentSeatings() + numOfPeople) > MAX_CAPACITY)
            throw new Exception("A lot of people");

    }

    public int getMaxCapacity() {
        return MAX_CAPACITY;


    }

    public String printTablesStatus() {//!!
        String result = " ";
        //posar contador i=1 para comencar de 1.
        int i = 1;

        //for (Integer numOfPeople : tables) { //va de funcio
        // result+=numOfPeople;

        for (Table table : tables) {
            result += "Table " + i + " : " + table.getCurrentSeatings() + " persons \n ";
            i++;
        }
        return result;
    }

    public void removeTableOnIndex(int pos) throws Exception {
        if (this.tables.isEmpty() || pos > this.tables.size()) {
            throw new Exception();
        }
        this.tables.remove(pos);
    }
}
