package com.haylieevers;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        UberDriver d = new UberDriver(1.00, .20);
        d.drive(5, 15);
        totalStats(d);
        d.pickUp();
        d.drive(6, 3);
        totalStats(d);
        for (int i = 0; i < 5; i++) {
            d.pickUp();
        }
        d.waitAround(2);
        totalStats(d);
        d.dropOff();
        d.driveAtSpeed(3, 25);
        totalStats(d);
        for (int i = 0; i < 10; i++) {
            d.dropOff();
        }
        d.drive(1, 1);
        totalStats(d);
        System.out.println(d.getProfit());
        System.out.println(d.getAverageProfitPerHour());
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