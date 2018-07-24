package elec;

public class IncreaseClick extends Items {
    private long price;

    public IncreaseClick(long p){
        super(p);
    }


    public boolean buyUpg(long milliAH){
        if(milliAH >= price){
            return true;
        }
        else
            return false;
    }

}
