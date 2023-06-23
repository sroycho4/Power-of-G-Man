package com.mycompany.power_of_g_man;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {

    public InputEntity readInputFromFile(String fileName) throws FileNotFoundException {
        Scanner inputFile = new Scanner(new File(fileName));
        int sourceX = 0;
        int sourceY = 0;
        String turn = "";
        int destinationX = 0;
        int destinationY = 0;

        try {
            String srcString = inputFile.nextLine();
            String[] srcParts = srcString.split("\\s+");
            sourceX = extractCoordinate(srcParts[1]);
            sourceY = extractCoordinate(srcParts[2]);
            turn = srcParts[3];

            String destString = inputFile.nextLine();
            String[] destParts = destString.split("\\s+");
            destinationX = extractCoordinate(destParts[1]);
            destinationY = extractCoordinate(destParts[2]);

        } catch (InputMismatchException e) {
            System.err.println("Invalid input format: " + e.getMessage());
            inputFile.close();
            return null; // or throw an exception if desired
        }

        inputFile.close();

        return new InputEntity(sourceX, sourceY, destinationX, destinationY, turn);
    }

    private int extractCoordinate(String input) {
        String numericPart = input.replaceAll("\\D", "");
        if (numericPart.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(numericPart);
    }
}