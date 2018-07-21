package elec;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class Controller {
    public Label energyMeter;

    private long mAH = 0;

    public void energyClick(ActionEvent actionEvent) {
        mAH++;

        energyMeter.setAlignment(Pos.CENTER);
        energyMeter.setText(mAH + " mAH");
    }

}
