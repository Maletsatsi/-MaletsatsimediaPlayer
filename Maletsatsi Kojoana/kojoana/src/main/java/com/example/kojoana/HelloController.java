package com.example.kojoana;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class HelloController {
   @FXML
    private MediaView mediaView;
   @FXML
    private MediaPlayer kojoana;

    @FXML
    private Button back;

    @FXML
    private Button next;

    @FXML
    private Button pause;

    @FXML
    private Button play;

    @FXML
    private Slider sliderVideo;

    @FXML
    private Slider sliderVolume;
    @FXML
    public void initialize() {
        String video = getClass().getResource("Miley-Cyrus.mp4").toExternalForm();
        Media media = new Media(video);
        kojoana = new MediaPlayer(media);
        mediaView.setMediaPlayer(kojoana);






        kojoana.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration oldValue, Duration newValue) {

                sliderVideo.setValue(newValue.toSeconds());
            }
        });


        sliderVideo.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                kojoana.seek(Duration.seconds(sliderVideo.getValue()));
            }
        });


        sliderVideo.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                kojoana.seek(Duration.seconds(sliderVideo.getValue()));
            }
        });





        sliderVolume.setValue(kojoana.getVolume()*100);
        sliderVolume.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                kojoana.setVolume(sliderVolume.getValue()/100);
            }
        });


    }
    public void playVideo(MouseEvent event){
        kojoana.play();
    }
    public void stopVideo(MouseEvent event){
        kojoana.stop();
    }
    public void pauseVideo(MouseEvent event){
        kojoana.pause();
    }
    @FXML
    void bVideo(MouseEvent event) {
        kojoana.seek(kojoana.getCurrentTime().add(Duration.seconds(-10)));
    }

    @FXML
    void fVideo(MouseEvent event) {
        kojoana.seek(kojoana.getCurrentTime().add(Duration.seconds(+10)));
    }







}