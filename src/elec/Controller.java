package elec;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
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

    //Electricity production chart
    public LineChart elecProd;

    //Clear data in graph
    public Button clearGraphData;

    //Label to show mAH / sec
    public Label mAHPerSec;

    //Keeps track of amount of energy created
    private long mAH = 0;

    //Keeps track of how much to add per click
    private long clickValue = 1;

    // Passive and click objects
    private IncreaseClick inClick = new IncreaseClick((long) 100);



    public void energyClick(ActionEvent action) {
        mAH+= clickValue;
        energyMeter.setText(mAH + " mAH");

        //Remove categories
        elecProd.setCreateSymbols(false);

        elecProd.setHorizontalGridLinesVisible(false);
        elecProd.setVerticalGridLinesVisible(false);

        //Start updating of chart
        elecChartTim.start();
    }


    XYChart.Series elecData = new XYChart.Series();

    //Timer for electricity chart
    private AnimationTimer elecChartTim = new AnimationTimer() {
        //Data for chart


        boolean firstRun = true;

        int frame = 1;
        long time = 0;

        long average = 0;
        int arrIndex = 0;

        long mAHBefore = mAH;
        long mAHGraph = 0;


        @Override
        public void handle(long now) {




            if(frame % 60 == 0){

                if(mAH != mAHBefore){
                    mAHGraph += mAH - mAHBefore;
                }

                mAHBefore = mAH;

                time++;
                arrIndex++;

                if(mAHGraph < 0)
                    mAHGraph = 0;

                mAHPerSec.setText(mAHGraph + " mAH/s");
                elecData.getData().add(new XYChart.Data(time + "", mAHGraph));


                mAHGraph = 0;

                frame = 1;
            }


            if(firstRun) {
                elecData.setName("mAH");

                elecProd.getData().add(elecData);
                firstRun = false;
            }

            frame++;
        }
    };

    //Reset the data in the graph
    public void clearGraphDataClick (ActionEvent actionEvent){
        elecData.getData().clear();
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

   private double oneOneDelay = 0.001;
   
    //Timer, executes once a frame
    private  AnimationTimer oneOneTim = new AnimationTimer(){

        double oneOneProgDelay;
        double oneOneProgNum = 0;
        boolean oneOneSubtractMAH = true;

        public void handle(long now){

            if(oneOneSubtractMAH && !oneOneAsBought){


                updateMAH(-5);


                oneOneSubtractMAH = false;
            }

            if(oneOneProgDelay % 5 == 0)
                oneOneProgNum += oneOneDelay;

            oneOneProgDelay++;

            if(oneOneProgNum >= 1.000)
                oneOneProg.setProgress(1);
            else
                oneOneProg.setProgress(oneOneProgNum);

            if(oneOneProg.getProgress() >= 1.0) {

                //Here so that the progress bar doesn't flash
                if(oneOneProgNum >= 1.000 && oneOneAsBought)
                    oneOneProg.setProgress(1);
                else
                    oneOneProg.setProgress(0);

                //Done otherwise the mAH count will flicker
                if(oneOneAsBought)
                    updateMAH(10);
                else
                    updateMAH(15);

                oneOneProgDelay = 0;
                oneOneProgNum = 0;
                oneOneSubtractMAH = true;

                if(!oneOneAsBought)
                    oneOneTim.stop();
            }
        }

    };

    private double twoOneDelay = 0.001;
    
    //Timer, executes once a frame
    private  AnimationTimer twoOneTim = new AnimationTimer(){

        double twoOneProgDelay;
        double twoOneProgNum = 0;
        boolean twoOneSubtractMAH = true;

        public void handle(long now){

            if(twoOneSubtractMAH && !twoOneAsBought){


                updateMAH(-5);


                twoOneSubtractMAH = false;
            }

            if(twoOneProgDelay % 5 == 0)
                twoOneProgNum += twoOneDelay;

            twoOneProgDelay++;

            if(twoOneProgNum >= 1.000)
                twoOneProg.setProgress(1);
            else
                twoOneProg.setProgress(twoOneProgNum);

            if(twoOneProg.getProgress() >= 1.0) {

                //Here so that the progress bar doesn't flash
                if(twoOneProgNum >= 1.000 && twoOneAsBought)
                    twoOneProg.setProgress(1);
                else
                    twoOneProg.setProgress(0);

                //Done otherwise the mAH count will flicker
                if(twoOneAsBought)
                    updateMAH(10);
                else
                    updateMAH(15);

                twoOneProgDelay = 0;
                twoOneProgNum = 0;
                twoOneSubtractMAH = true;

                if(!twoOneAsBought)
                    twoOneTim.stop();
            }
        }

    };

    private double threeOneDelay = 0.001;
    
    //Timer, executes once a frame
    private  AnimationTimer threeOneTim = new AnimationTimer(){

        double threeOneProgDelay;
        double threeOneProgNum = 0;
        boolean threeOneSubtractMAH = true;

        public void handle(long now){

            if(threeOneSubtractMAH && !threeOneAsBought){


                updateMAH(-5);


                threeOneSubtractMAH = false;
            }

            if(threeOneProgDelay % 5 == 0)
                threeOneProgNum += threeOneDelay;

            threeOneProgDelay++;

            if(threeOneProgNum >= 1.000)
                threeOneProg.setProgress(1);
            else
                threeOneProg.setProgress(threeOneProgNum);

            if(threeOneProg.getProgress() >= 1.0) {

                //Here so that the progress bar doesn't flash
                if(threeOneProgNum >= 1.000 && threeOneAsBought)
                    threeOneProg.setProgress(1);
                else
                    threeOneProg.setProgress(0);

                //Done otherwise the mAH count will flicker
                if(threeOneAsBought)
                    updateMAH(10);
                else
                    updateMAH(15);

                threeOneProgDelay = 0;
                threeOneProgNum = 0;
                threeOneSubtractMAH = true;

                if(!threeOneAsBought)
                    threeOneTim.stop();
            }
        }

    };

    private double zeroFourDelay = 0.001;
    
    //Timer, executes once a frame
    private  AnimationTimer zeroFourTim = new AnimationTimer(){

        double zeroFourProgDelay;
        double zeroFourProgNum = 0;
        boolean zeroFourSubtractMAH = true;

        public void handle(long now){

            if(zeroFourSubtractMAH && !zeroFourAsBought){


                updateMAH(-5);


                zeroFourSubtractMAH = false;
            }

            if(zeroFourProgDelay % 5 == 0)
                zeroFourProgNum += zeroFourDelay;

            zeroFourProgDelay++;

            if(zeroFourProgNum >= 1.000)
                zeroFourProg.setProgress(1);
            else
                zeroFourProg.setProgress(zeroFourProgNum);

            if(zeroFourProg.getProgress() >= 1.0) {

                //Here so that the progress bar doesn't flash
                if(zeroFourProgNum >= 1.000 && zeroFourAsBought)
                    zeroFourProg.setProgress(1);
                else
                    zeroFourProg.setProgress(0);

                //Done otherwise the mAH count will flicker
                if(zeroFourAsBought)
                    updateMAH(10);
                else
                    updateMAH(15);

                zeroFourProgDelay = 0;
                zeroFourProgNum = 0;
                zeroFourSubtractMAH = true;

                if(!zeroFourAsBought)
                    zeroFourTim.stop();
            }
        }

    };
    
    private double oneFourDelay = 0.001;

    //Timer, executes once a frame
    private  AnimationTimer oneFourTim = new AnimationTimer(){

        double oneFourProgDelay;
        double oneFourProgNum = 0;
        boolean oneFourSubtractMAH = true;

        public void handle(long now){

            if(oneFourSubtractMAH && !oneFourAsBought){


                updateMAH(-5);


                oneFourSubtractMAH = false;
            }

            if(oneFourProgDelay % 5 == 0)
                oneFourProgNum += oneFourDelay;

            oneFourProgDelay++;

            if(oneFourProgNum >= 1.000)
                oneFourProg.setProgress(1);
            else
                oneFourProg.setProgress(oneFourProgNum);

            if(oneFourProg.getProgress() >= 1.0) {

                //Here so that the progress bar doesn't flash
                if(oneFourProgNum >= 1.000 && oneFourAsBought)
                    oneFourProg.setProgress(1);
                else
                    oneFourProg.setProgress(0);

                //Done otherwise the mAH count will flicker
                if(oneFourAsBought)
                    updateMAH(10);
                else
                    updateMAH(15);

                oneFourProgDelay = 0;
                oneFourProgNum = 0;
                oneFourSubtractMAH = true;

                if(!oneFourAsBought)
                    oneFourTim.stop();
            }
        }

    };

    private double twoFourDelay = 0.001;
    
    //Timer, executes once a frame
    private  AnimationTimer twoFourTim = new AnimationTimer(){

        double twoFourProgDelay;
        double twoFourProgNum = 0;
        boolean twoFourSubtractMAH = true;

        public void handle(long now){

            if(twoFourSubtractMAH && !twoFourAsBought){


                updateMAH(-5);


                twoFourSubtractMAH = false;
            }

            if(twoFourProgDelay % 5 == 0)
                twoFourProgNum += twoFourDelay;

            twoFourProgDelay++;

            if(twoFourProgNum >= 1.000)
                twoFourProg.setProgress(1);
            else
                twoFourProg.setProgress(twoFourProgNum);

            if(twoFourProg.getProgress() >= 1.0) {

                //Here so that the progress bar doesn't flash
                if(twoFourProgNum >= 1.000 && twoFourAsBought)
                    twoFourProg.setProgress(1);
                else
                    twoFourProg.setProgress(0);

                //Done otherwise the mAH count will flicker
                if(twoFourAsBought)
                    updateMAH(10);
                else
                    updateMAH(15);

                twoFourProgDelay = 0;
                twoFourProgNum = 0;
                twoFourSubtractMAH = true;

                if(!twoFourAsBought)
                    twoFourTim.stop();
            }
        }

    };
    
    private double threeFourDelay = 0.001;

    //Timer, executes once a frame
    private  AnimationTimer threeFourTim = new AnimationTimer(){

        double threeFourProgDelay;
        double threeFourProgNum = 0;
        boolean threeFourSubtractMAH = true;

        public void handle(long now){

            if(threeFourSubtractMAH && !threeFourAsBought){


                updateMAH(-5);


                threeFourSubtractMAH = false;
            }

            if(threeFourProgDelay % 5 == 0)
                threeFourProgNum += threeFourDelay;

            threeFourProgDelay++;

            if(threeFourProgNum >= 1.000)
                threeFourProg.setProgress(1);
            else
                threeFourProg.setProgress(threeFourProgNum);

            if(threeFourProg.getProgress() >= 1.0) {

                //Here so that the progress bar doesn't flash
                if(threeFourProgNum >= 1.000 && threeFourAsBought)
                    threeFourProg.setProgress(1);
                else
                    threeFourProg.setProgress(0);

                //Done otherwise the mAH count will flicker
                if(threeFourAsBought)
                    updateMAH(10);
                else
                    updateMAH(15);

                threeFourProgDelay = 0;
                threeFourProgNum = 0;
                threeFourSubtractMAH = true;

                if(!threeFourAsBought)
                    threeFourTim.stop();
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
        if(action.getSource().equals(oneOneBut)){
            if(mAH >= 5) {

                oneOneTim.start();
            }
        }
        else if(action.getSource().equals(oneOneUpg)) {

            if (mAH >= 5) {

                if(oneOneDelay >= 1.0)
                    oneOneUpg.setDisable(true);
                else
                    oneOneDelay += 0.001;



                updateMAH(-5);
            }
        }
        else if (action.getSource().equals(oneOneAs)){

            if(mAH >= 500){
                oneOneTim.start();
                oneOneBut.setDisable(true);
                oneOneAs.setDisable(true);
                oneOneAsBought = true;
                updateMAH(-500);
            }

        }

    }

    //Costs 5 mAH
    public void twoOneClick (ActionEvent action){
        if(action.getSource().equals(twoOneBut)){
            if(mAH >= 5) {

                twoOneTim.start();
            }
        }
        else if(action.getSource().equals(twoOneUpg)) {

            if (mAH >= 5) {

                if(twoOneDelay >= 1.0)
                    twoOneUpg.setDisable(true);
                else
                    twoOneDelay += 0.001;



                updateMAH(-5);
            }
        }
        else if (action.getSource().equals(twoOneAs)){

            if(mAH >= 500){
                twoOneTim.start();
                twoOneBut.setDisable(true);
                twoOneAs.setDisable(true);
                twoOneAsBought = true;
                updateMAH(-500);
            }

        }

    }

    //Costs 5 mAH
    public void threeOneClick (ActionEvent action){
        if(action.getSource().equals(threeOneBut)){
            if(mAH >= 5) {

                threeOneTim.start();
            }
        }
        else if(action.getSource().equals(threeOneUpg)) {

            if (mAH >= 5) {

                if(threeOneDelay >= 1.0)
                    threeOneUpg.setDisable(true);
                else
                    threeOneDelay += 0.001;



                updateMAH(-5);
            }
        }
        else if (action.getSource().equals(threeOneAs)){

            if(mAH >= 500){
                threeOneTim.start();
                threeOneBut.setDisable(true);
                threeOneAs.setDisable(true);
                threeOneAsBought = true;
                updateMAH(-500);
            }

        }

    }

    //Costs 5 mAH
    public void zeroFourClick (ActionEvent action){
        if(action.getSource().equals(zeroFourBut)){
            if(mAH >= 5) {

                zeroFourTim.start();
            }
        }
        else if(action.getSource().equals(zeroFourUpg)) {

            if (mAH >= 5) {

                if(zeroFourDelay >= 1.0)
                    zeroFourUpg.setDisable(true);
                else
                    zeroFourDelay += 0.001;



                updateMAH(-5);
            }
        }
        else if (action.getSource().equals(zeroFourAs)){

            if(mAH >= 500){
                zeroFourTim.start();
                zeroFourBut.setDisable(true);
                zeroFourAs.setDisable(true);
                zeroFourAsBought = true;
                updateMAH(-500);
            }

        }

    }

    //Costs 5 mAH
    public void oneFourClick (ActionEvent action){
        if(action.getSource().equals(oneFourBut)){
            if(mAH >= 5) {

                oneFourTim.start();
            }
        }
        else if(action.getSource().equals(oneFourUpg)) {

            if (mAH >= 5) {

                if(oneFourDelay >= 1.0)
                    oneFourUpg.setDisable(true);
                else
                    oneFourDelay += 0.001;



                updateMAH(-5);
            }
        }
        else if (action.getSource().equals(oneFourAs)){

            if(mAH >= 500){
                oneFourTim.start();
                oneFourBut.setDisable(true);
                oneFourAs.setDisable(true);
                oneFourAsBought = true;
                updateMAH(-500);
            }

        }

    }

    //Costs 5 mAH
    public void twoFourClick (ActionEvent action){
        if(action.getSource().equals(twoFourBut)){
            if(mAH >= 5) {

                twoFourTim.start();
            }
        }
        else if(action.getSource().equals(twoFourUpg)) {

            if (mAH >= 5) {

                if(twoFourDelay >= 1.0)
                    twoFourUpg.setDisable(true);
                else
                    twoFourDelay += 0.001;



                updateMAH(-5);
            }
        }
        else if (action.getSource().equals(twoFourAs)){

            if(mAH >= 500){
                twoFourTim.start();
                twoFourBut.setDisable(true);
                twoFourAs.setDisable(true);
                twoFourAsBought = true;
                updateMAH(-500);
            }

        }

    }

    //Costs 5 mAH
    public void threeFourClick (ActionEvent action){
        if(action.getSource().equals(threeFourBut)){
            if(mAH >= 5) {

                threeFourTim.start();
            }
        }
        else if(action.getSource().equals(threeFourUpg)) {

            if (mAH >= 5) {

                if(threeFourDelay >= 1.0)
                    threeFourUpg.setDisable(true);
                else
                    threeFourDelay += 0.001;



                updateMAH(-5);
            }
        }
        else if (action.getSource().equals(threeFourAs)){

            if(mAH >= 500){
                threeFourTim.start();
                threeFourBut.setDisable(true);
                threeFourAs.setDisable(true);
                threeFourAsBought = true;
                updateMAH(-500);
            }

        }

    }


    public void updateMAH(long val){
        mAH += val;

        energyMeter.setText(mAH + " mAH");


    }
}
