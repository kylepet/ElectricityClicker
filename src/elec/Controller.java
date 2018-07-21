package elec;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class Controller {
    public Label energyMeter;

    private int clicks = 0;

    public void energyClick(ActionEvent actionEvent) {
        clicks++;

        energyMeter.setAlignment(Pos.CENTER);
        energyMeter.setText(clicks + " mAH");
    }

    public static class Passive {
    }
}
