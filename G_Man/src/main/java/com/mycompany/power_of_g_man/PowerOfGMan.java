package com.mycompany.power_of_g_man;

import exception_handler.UserException;

public class PowerOfGMan {

    public boolean validateInput(InputEntity inputEntity) throws UserException {
        String[] validDirections = {"E", "W", "N", "S"};

        int sourceX = inputEntity.getSourceX();
        int sourceY = inputEntity.getSourceY();
        int destinationX = inputEntity.getDestinationX();
        int destinationY = inputEntity.getDestinationY();
        String turn = inputEntity.getTurn();

        if (!(isValidCoordinate(sourceX) && isValidCoordinate(sourceY) && isValidCoordinate(destinationX) && isValidCoordinate(destinationY))
                || !isValidDirection(turn, validDirections)) {
            throw new UserException("Coordinates must be between 0 and 6, and direction must be one of: E, W, N, S.");
        }
        return true;
    }

    private boolean isValidCoordinate(int coordinate) {
        final int MIN_COORDINATE_VALUE = 0;
        final int MAX_COORDINATE_VALUE = 6;
        return coordinate >= MIN_COORDINATE_VALUE && coordinate <= MAX_COORDINATE_VALUE;
    }

    private boolean isValidDirection(String direction, String[] validDirections) {
        for (String validDir : validDirections) {
            if (validDir.equals(direction)) {
                return true;
            }
        }
        return false;
    }
}
