package com.mycompany.power_of_g_man;

import exception_handler.UserException;
import java.io.FileNotFoundException;

public class PowerOfGManApp {

    public static void main(String[] args) {
        try {
            String inputFilePath = args[0];
            InputReader inputReader = new InputReader();
            InputEntity inputEntity = inputReader.readInputFromFile(inputFilePath);

            PowerOfGMan powerOfGMan = new PowerOfGMan();
            if (powerOfGMan.validateInput(inputEntity)) {
                PowerCalculator powerCalculator = new PowerCalculator();
                powerCalculator.calculate(inputEntity);
                Travel travel = new Travel();
                int power = travel.travel(inputEntity);
                System.out.println("Power " + power);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found: " + e.getMessage());
        } catch (UserException e) {
            System.err.println("Invalid input: " + e.getMessage());
        }
    }
}
