package elec;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javax.swing.Timer;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Controller {
    
    //Shows how much energy the player made
    public Label energyMeter;
    
    //Progress bars
    public ProgressBar zeroOneProg;
    public ProgressBar oneOneProg;
    public ProgressBar twoOneProg;
    public ProgressBar threeOneProg;
    public ProgressBar zeroFourProg;
    public ProgressBar oneFourProg;
    public ProgressBar twoFourProg;
    public ProgressBar threeFourProg;
    
    //Buttons to buy
    public Button zeroOneBut;
    public Button oneOneBut;
    public Button twoOneBut;
    public Button threeOneBut;
    public Button zeroFourBut;
    public Button oneFourBut;
    public Button twoFourBut;
    public Button threeFourBut;

    //Labels for the progress bars
    public Label zeroOneLab;
    public Label oneOneLab;
    public Label twoOneLab;
    public Label threeOneLab;
    public Label zeroFourLab;
    public Label oneFourLab;
    public Label twoFourLab;
    public Label threeFourLab;
    
    //Buttons to upgrade
    public Button zeroOneUpg;
    public Button oneOneUpg;
    public Button twoOneUpg;
    public Button threeOneUpg;
    public Button zeroFourUpg;
    public Button oneFourUpg;
    public Button twoFourUpg;
    public Button threeFourUpg;

    //Progress bar progress vars
    private double zeroOneProgNum;

    //Keeps track of amount of energy created
    private long mAH = 0;


    public void energyClick(ActionEvent action) {
        mAH++;
        energyMeter.setText(mAH + " mAH");


    }

    public void zeroOneClick(ActionEvent action){
        if(action.getSource().equals(zeroOneBut)){
            Timer timer = new Timer(100, zeroOneTim);

            if(!timer.isRunning()) {
                timer.start();
                energyMeter.setText(mAH + " mAH");
            }
        }
        else if(action.getSource().equals(zeroOneUpg)){
            mAH--;
            energyMeter.setText(mAH + " mAH");
        }
    }

    private ActionListener zeroOneTim = new ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            zeroOneProgNum += 0.01;
            zeroOneProg.setProgress(zeroOneProgNum);

            if(zeroOneProgNum >= 1.0 ){
                //Reset the vars
                zeroOneProg.setProgress(0.0);
                zeroOneProgNum = 0;

                //Increase energy
                mAH += 15;


                //Stop the timer
                ((Timer)e.getSource()).stop();

            }
        }
    };

    public void updateMAH(long val){
        mAH += val;

        energyMeter.setText(mAH + " mAH");


    }
}
