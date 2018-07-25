package elec;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller{
    
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
    public Button oneOneAs;
    public Button twoOneAs;
    public Button threeOneAs;
    public Button zeroFourAs;
    public Button oneFourAs;
    public Button twoFourAs;
    public Button threeFourAs;

    //Booleans to check if assistant was bought
    private boolean zeroOneAsBought = false;
    private boolean oneOneAsBought;
    private boolean twoOneAsBought;
    private boolean threeOneAsBought;
    private boolean zeroFourAsBought;
    private boolean oneFourAsBought;
    private boolean twoFourAsBought;
    private boolean threeFourAsBought;

    //Label to show price
    public Label upgradeClickPrice;

    //Progress bar progress vars
    private double zeroOneProgNum;

    //Upgrade click button
    public Button upgradeClick;

    //Button for help
    public Button helpBtn;


    //Keeps track of amount of energy created
    private long mAH = 5000;

    //Keeps track of how much to add per click
    private long clickValue = 1;

    // Passive and click objects
    private IncreaseClick inClick = new IncreaseClick((long) 100);



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

    //Timer, executes once a frame
    private  AnimationTimer oneOneTim = new AnimationTimer(){

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

    //Timer, executes once a frame
    private  AnimationTimer twoOneTim = new AnimationTimer(){

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

    //Timer, executes once a frame
    private  AnimationTimer threeOneTim = new AnimationTimer(){

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

    //Timer, executes once a frame
    private  AnimationTimer zeroFourTim = new AnimationTimer(){

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

    //Timer, executes once a frame
    private  AnimationTimer oneFourTim = new AnimationTimer(){

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

    //Timer, executes once a frame
    private  AnimationTimer twoFourTim = new AnimationTimer(){

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

    //Timer, executes once a frame
    private  AnimationTimer threeFourTim = new AnimationTimer(){

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

   //Listener to show help screen
    public void showHelpScreen (ActionEvent action){
        final Stage helpScreen = new Stage();

        helpScreen.initModality(Modality.APPLICATION_MODAL);
        
        //Set icon
        helpScreen.getIcons().add( new Image(Main.class.getResourceAsStream( "helpScreenIcon.png" )));
        helpScreen.setTitle(" How to play: ");
        
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text(
                                " Everything is bought with energy, which is generated by clicking the energy icon on the left side of the screen. \n" +
                                " The amount of energy generated is displayed at the bottom left-hand corner of the screen. Energy can also be \n" +
                                " generated by buying the items in the center of the screen, when their bar fills up a lot of energy will be generated.\n" +
                                " For the same cost, one can also upgrade the item to lower the time it takes for the bar to fill up. On the\n" +
                                " upper-right side of the screen one can buy an upgrade to their click, which adds one energy every time you click\n" +
                                " and so on. Lastly, underneath that, are the assistants which automatically buy the items corresponding to their \n" +
                                " names." ));

        Scene dialogScene = new Scene(dialogVbox, 610, 115);
        helpScreen.setScene(dialogScene);
        helpScreen.setResizable(false);
        helpScreen.show();
    }

    //Costs 5 mAH
    public void zeroOneClick (ActionEvent action){
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

    //Costs 5 mAH
    public void oneOneClick (ActionEvent action){
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

    //Costs 5 mAH
    public void twoOneClick (ActionEvent action){
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

    //Costs 5 mAH
    public void threeOneClick (ActionEvent action){
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

    //Costs 5 mAH
    public void zeroFourClick (ActionEvent action){
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

    //Costs 5 mAH
    public void oneFourClick (ActionEvent action){
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

    //Costs 5 mAH
    public void twoFourClick (ActionEvent action){
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

    //Costs 5 mAH
    public void threeFourClick (ActionEvent action){
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
