package com.mycompany.power_of_g_man;

public class PowerCalculator {
    public int calculate(InputEntity inputEntity) {
        int sourceX = inputEntity.getSourceX();
        int sourceY = inputEntity.getSourceY();
        int destinationX = inputEntity.getDestinationX();
        int destinationY = inputEntity.getDestinationY();

        int remainingPower = 200;
        int grid = 10;
        int distance = Math.abs(destinationX - sourceX) + Math.abs(destinationY - sourceY);
        remainingPower -= distance * grid;
        return remainingPower;
    }
}
