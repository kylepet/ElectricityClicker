package elec;

/**
 * Basic functions for the IncreaseClick class
 *
 * @author Kyle Petkovic
 * @version 1.0.0
 */

public abstract class Items {

    //The name of the object
    private String name;

    //The price
    private long price;

    /**
     * Default constructor
     */
    public Items(){
        name = "";
        price = 0;
    }

    /**
     * Constructor
     *
     * @param p The price of the item
     */
    public Items(long p){
        name = "";
        price = p;
    }

    /**
     * Constructor
     *
     * @param n The name
     * @param p The price
     */
    public Items(String n, long p){
        name = n;
        price = p;

    }

    /**
     * Sets the name of the item
     *
     * @param n The new name.
     */
    public void setName(String n){
        name = n;
    }

    /**
     * Sets the price.
     *
     * @param p The new price.
     */
    public void setPrice(long p){
        price = p;
    }

    /**
     * Returns the price.
     *
     * @return The price of the object.
     */
    public long getPrice(){
        return price;
    }

}
