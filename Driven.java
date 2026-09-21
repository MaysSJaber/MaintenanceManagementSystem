
import Screens.LoginScreen;
import Screens.MainScreen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author maysj
 */
public class Driven {

    public static void main(String[] args) throws IOException {

        while (true) {

            if(!LoginScreen.ShowLoginScreen()) {
                break;
            }

        }
    }
}