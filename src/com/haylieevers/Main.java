package com.haylieevers;

public class Main {
    /**
     * Test The UberDriver class
     */
    public static void main(String[] args) {
        UberDriver d = new UberDriver(1.00, .20);
        d.drive(5, 15);
        totalStats(d); //5, 15, 0.0, 0
        d.pickUp();
        d.drive(6, 3);
        totalStats(d); //11, 18, 6.6, 1
        for (int i = 0; i < 5; i++) {
            d.pickUp();
        }
        d.waitAround(2);
        totalStats(d); //11, 20, 8.2, 4
        d.dropOff();
        d.driveAtSpeed(3, 25);
        totalStats(d); //14, 27, 21.4, 3
        for (int i = 0; i < 10; i++) {
            d.dropOff();
        }
        d.drive(1, 1);
        totalStats(d); //15, 28, 21.4, 0
        System.out.println(d.getProfit()); //13.9
        System.out.println(d.getAverageProfitPerHour()); //6.48667
        d.driveAtSpeed(80, -63);

    }

    public static void totalStats(UberDriver driver) {
        System.out.println();
        System.out.println("Miles: " + driver.getTotalMiles());
        System.out.println("Minutes: " + driver.getTotalMinutes());
        System.out.println("Credits: " + driver.getTotalCredits());
        System.out.println("Passengers: " + driver.getPassengerCount());
    }
}