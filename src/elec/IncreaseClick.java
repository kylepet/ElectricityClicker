package elec;

/**
 * The created object handles how much a energy a click gives the user.
 *
 * @author Kyle Petkovic
 * @version 1.0.0
 */

public class IncreaseClick extends Items {

    //The price
    private long price;

    /**
     * Constructor
     *
     * @param p How much the current cost is.
     */
    public IncreaseClick(long p){
        super(p);
    }


    /**
     * Checks to see if the user has enough mAH to buy an upgrade to their click
     *
     * @param milliAH How much mAH the user currently has.
     * @return True if user has enough mAH, false otherwise
     */
    public boolean buyUpg(long milliAH){
        if(milliAH >= price){
            return true;
        }
        else
            return false;
    }

}
