package elec;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

//Controller for the items related to the progress bars
//Also handles their timers.
public class ProgPassive extends Controller{

    private Label itemName;
    private ProgressBar itemProg;
    private Button buyThis;
    private Button upgThis;

    public ProgPassive(String name, Long price, Label lab, ProgressBar prog, Button buy, Button upg){
        //super.setName(name);
        //super.setPrice(price);

        //Label
        itemName = lab;

        Label zeroOneLab = new Label();

        zeroOneLab.setText(price + " mAH");

        //Prog bar
        itemProg = prog;

        //Buy it
        buyThis = buy;

        //Upgrade
        upgThis = upg;

    }

}
