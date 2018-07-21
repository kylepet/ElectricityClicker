package elec;

public abstract class Items {

    private String name;
    private long price;

    public Items(String n, long p){
        name = n;
        price = p;

    }

    public abstract void setName(String name);
    public abstract void setPrice(long price);
}
