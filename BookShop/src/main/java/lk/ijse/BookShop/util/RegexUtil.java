package lk.ijse.BookShop.util;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

    public static boolean checkFinalResult(ArrayList<String> regex, JFXButton button, JFXTextField... textFields){

        for (int i = 0; i < textFields.length; i++) {
            if (textFields[i].getText().equals("")|!regex(button,textFields[i],textFields[i].getText(),regex.get(i) )){
                textFields[i].requestFocus();
                textFields[i].setFocusColor(Paint.valueOf("red"));
                button.setDisable(true);
                return false;
            }else {
            }
        }
        return true;
    }
    public static boolean regex(JFXButton button, JFXTextField txtEmail, String type, String regex,String style){
        System.out.println(type);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(type);
        if (matcher.matches()){
            txtEmail.setFocusColor(Paint.valueOf("transparent"));
            txtEmail.setStyle(style);
            button.setDisable(false);
        }else {
            button.setDisable(true);
            txtEmail.setStyle("-fx-text-fill: ReD");
        }
           return matcher.matches();
    }
    public static boolean regex(JFXButton button, JFXTextField textField, String type ,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(type);
        if (matcher.matches()){
            textField.requestFocus();
            button.setDisable(false);
        }else {
        }
        return matcher.matches();
    }
}
