public class Table {
private static final int MAX_CAPACITY=6;
    private int currentSeatings=0;

    public Table(){

    }
    public int addClients(int numOfPeople ) throws Exception {
        checkValidNumOfPeople(numOfPeople);
        this.currentSeatings=numOfPeople;
        if(this.currentSeatings>MAX_CAPACITY){
            this.currentSeatings=MAX_CAPACITY;
        }
        return numOfPeople - currentSeatings;
    }

    private void checkValidNumOfPeople(int numOfPeople) throws Exception {
        if(numOfPeople<=0) throw new Exception();
    }

    public int getCurrentSeatings() {
        return currentSeatings;
    }
}
