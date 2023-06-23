package com.mycompany.power_of_g_man;

public class Travel {

    public int travel(InputEntity inputEntity) {
        int sourceX = inputEntity.getSourceX();
        int sourceY = inputEntity.getSourceY();
        int destinationX = inputEntity.getDestinationX();
        int destinationY = inputEntity.getDestinationY();
        String turn = inputEntity.getTurn();
        int travelX = destinationX - sourceX;
        int travelY = destinationY - sourceY;
        int powerDeduction = 5;
        String directionEast = "E";
        String directionWest = "W";
        String directionNorth = "N";
        String directionSouth = "S";
        int zero = 0;

        PowerCalculator powerCalculator = new PowerCalculator();
        int remainingPower = powerCalculator.calculate(inputEntity);

        while (sourceX != destinationX || sourceY != destinationY) {
            if (sourceX < destinationX) {
                sourceX++;
                if (!turn.equals(directionEast)) {
                    remainingPower -= powerDeduction;
                    turn = directionEast;
                    if (travelY == zero) {
                        remainingPower -= powerDeduction;
                    }
                }
            } else if (sourceX > destinationX) {
                sourceX--;
                if (!turn.equals(directionWest)) {
                    remainingPower -= powerDeduction;
                    turn = directionWest;
                    if (travelY == zero) {
                        remainingPower -= powerDeduction;
                    }
                }
            } else if (sourceY < destinationY) {
                sourceY++;
                if (!turn.equals(directionNorth)) {
                    remainingPower -= powerDeduction;
                    turn = directionNorth;
                    if (travelX == zero) {
                        remainingPower -= powerDeduction;
                    }
                }
            } else if (sourceY > destinationY) {
                sourceY--;
                if (!turn.equals(directionSouth)) {
                    remainingPower -= powerDeduction;
                    turn = directionSouth;
                    if (travelX == zero) {
                        remainingPower -= powerDeduction;
                    }
                }
            }
        }
        return remainingPower;
    }
}
