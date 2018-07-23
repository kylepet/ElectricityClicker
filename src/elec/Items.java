package elec;

public abstract class Items {

    private String name;
    private long price;

    public Items(){
        name = "";
        price = 0;
    }

    public Items(String n, long p){
        name = n;
        price = p;

    }

    public void setName(String n){
        name = n;
    }
    public void setPrice(long p){
        price = p;
    }
}
