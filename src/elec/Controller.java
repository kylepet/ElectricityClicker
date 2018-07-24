package elec;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

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

    //Assistant Buttons
    public Button zeroOneAs;
    public boolean zeroOneAsBought = false;

    //Label to show price
    public Label upgradeClickPrice;

    //Progress bar progress vars
    private double zeroOneProgNum;

    //Upgrade click button
    public Button upgradeClick;

    //Keeps track of amount of energy created
    private long mAH = 5000;

    //Keeps track of how much to add per click
    private long clickValue = 1;

    //Passive and click objects
    IncreaseClick inClick = new IncreaseClick((long) 100);


    public void energyClick(ActionEvent action) {
        mAH+= clickValue;
        energyMeter.setText(mAH + " mAH");

    }


    private double zeroOneDelay = 0.001;

    //Timer, executes once a frame
   private  AnimationTimer zeroOneTim = new AnimationTimer(){

        double zeroOneProgDelay;
        double zeroOneProgNum = 0;
        boolean zeroOneSubtractMAH = true;

        public void handle(long now){

            if(zeroOneSubtractMAH && !zeroOneAsBought){


                updateMAH(-5);


                zeroOneSubtractMAH = false;
            }

            if(zeroOneProgDelay % 5 == 0)
                zeroOneProgNum += zeroOneDelay;

            zeroOneProgDelay++;

            if(zeroOneProgNum >= 1.000)
                zeroOneProg.setProgress(1);
            else
                zeroOneProg.setProgress(zeroOneProgNum);

            if(zeroOneProg.getProgress() >= 1.0) {

                //Here so that the progress bar doesn't flash
                if(zeroOneProgNum >= 1.000 && zeroOneAsBought)
                    zeroOneProg.setProgress(1);
                else
                    zeroOneProg.setProgress(0);

                //Done otherwise the mAH count will flicker
                if(zeroOneAsBought)
                    updateMAH(10);
                else
                    updateMAH(15);

                zeroOneProgDelay = 0;
                zeroOneProgNum = 0;
                zeroOneSubtractMAH = true;

                if(!zeroOneAsBought)
                    zeroOneTim.stop();
            }
        }

    };

   public void shopUpgClick(ActionEvent action){
       if(action.getSource().equals(upgradeClick)){
           if(inClick.buyUpg(mAH)){

               if(inClick.getPrice() <= mAH) {
                   clickValue++;

                   updateMAH(inClick.getPrice() * -1);
                   inClick.setPrice(inClick.getPrice() * 3);
                   System.out.println(inClick.getPrice());

                   //Set value of price label
                   upgradeClickPrice.setText(inClick.getPrice() + " mAH");
               }

           }
       }
   }

    //Costs 5 mAH
    public void zeroOneClick(ActionEvent action){
        if(action.getSource().equals(zeroOneBut)){
            if(mAH >= 5) {

                zeroOneTim.start();
            }
        }
        else if(action.getSource().equals(zeroOneUpg)) {

            if (mAH >= 5) {

                if(zeroOneDelay >= 1.0)
                        zeroOneUpg.setDisable(true);
                    else
                        zeroOneDelay += 0.001;



                    updateMAH(-5);
            }
        }
            else if (action.getSource().equals(zeroOneAs)){

                if(mAH >= 500){
                    zeroOneTim.start();
                    zeroOneBut.setDisable(true);
                    zeroOneAs.setDisable(true);
                    zeroOneAsBought = true;
                    updateMAH(-500);
                }

            }

    }


    public void updateMAH(long val){
        mAH += val;

        energyMeter.setText(mAH + " mAH");


    }
}
