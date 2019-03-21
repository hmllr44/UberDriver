package com.haylieevers;

public class UberDriver {

    public static final int MAX_PASSENGERS = 4;
    //Cost to operate the vehicle per mile.
    public static final double OPERATING_COST = 0.5;
    public int milesTotal;
    public double perMileRate;
    public double perMinuteRate;
    public int minutesTotal;
    public double totalCredits;
    public int passengers;


    //Constructs an UberDriver with the given per-mile rate and per-minute rate.
    public UberDriver(double givenPerMileRate, double givenPerMinuteRate) {
        milesTotal = 0;
        minutesTotal = 0;
        perMileRate = givenPerMileRate;
        perMinuteRate = givenPerMinuteRate;
        passengers = 0;
        totalCredits = 0;
        }

    public int getTotalMiles(){
        return milesTotal;
    }


    //Returns the total minutes driven since this UberDriver was constructed.
    public int getTotalMinutes(){
        return minutesTotal;
    }


    //Drives the vehicle for the given number of miles over the given number of minutes.
    public void drive(int miles, int minutes){
        milesTotal +=  miles;
        minutesTotal += minutes;
        totalCredits += (miles * perMileRate + minutes * perMinuteRate) * passengers;
    }


    //Simulates sitting in the vehicle without moving for the given number of minutes.
    //      Equivalent to drive(0, minutes).
    public void waitAround(int minutes)
    {
        drive(0, minutes);
    }

    //Drives the vehicle for the given number of miles at the given speed. Equivalent to
    //drive(miles, m), where m is the actual number of minutes required, rounded to the
    //nearest integer. Caller of method must ensure that averageSpeed is positive.
    public void driveAtSpeed(int miles, double averageSpeed){
        if (averageSpeed <= 0){
            throw new RuntimeException("Invalid input, average speed must be positive.  You entered " + averageSpeed);
        }
          int minutes = (int) Math.round(60 * miles / averageSpeed);

        drive(miles, minutes);

    }

    //Returns the number of passengers currently in the vehicle.
    public int getPassengerCount(){
        return passengers;
    }

    //Increases the passenger count by 1, not exceeding MAX_PASSENGERS.
    public void pickUp(){
        passengers++;
        passengers = Math.min(passengers, MAX_PASSENGERS);
    }

    //Decreases the passenger count by 1, not going below zero.
    public void dropOff(){
        passengers--;
        passengers = Math.max(passengers, 0);
    }

    //Returns this UberDriver's total credits (money earned before deducting operating costs).
    public double getTotalCredits(){
        return totalCredits;
    }

    //Returns this UberDriver's profit (total credits, less operating costs).
    public double getProfit(){
        double profit = totalCredits - OPERATING_COST * milesTotal;
        return profit;
    }

    //Returns this UberDriver's average profit per hour worked. Caller of method must ensure
    //that it is only called when the value of getTotalMinutes() is nonzero.
    public double getAverageProfitPerHour(){
        double averageProfit = getProfit() * minutesTotal / 60;
        return averageProfit;
    }



}

