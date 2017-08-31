/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.refactorlabs;

/**
 *
 * @author asmat
 */
public class CalculateInterest {

    public final int DAILY = 365;
    public final int YEARLY = 12;
    public final int QUATERLY = 4;
    public final int ANNUALLY = 1;

    private float interestRate;
    private float principalAmount;
    private int years;
    private int repeatPeriod;

    public CalculateInterest(float principalAmount, float interestRate, int years, int repeatPeriod) {
        
        this.principalAmount = principalAmount;
        this.years = years;
        this.repeatPeriod = repeatPeriod;
        
        switch (repeatPeriod) {
            case 1:
                repeatPeriod = 365;
                break;
            case 2:
                repeatPeriod = 12;
                break;
            case 3:
                repeatPeriod = 4;
                break;
            default:
                repeatPeriod = 1; //calculate annually if error      
        }

        setInterestRate(interestRate / repeatPeriod);
    }

    public void showInterest() {
        float amountFromInterest = 0, prinicipalAtEndOfYear = getPrincipalAmount();
        float totalInterestAmount = 0;
        //Loop for every year
        for (int i = 0; i < this.getYears(); i++) {
            System.out.println("Year " + (i + 1) + "-----> ");
            System.out.println("Principle amount ........................... " + getPrincipalAmount());

            for (int j = 0; j < this.getRepeatPeriod(); j++) {
                float newPrincipalAmount = this.getPrincipalAmount() * (1 + this.getInterestRate() / 100);
                amountFromInterest = newPrincipalAmount - this.getPrincipalAmount();

                totalInterestAmount += amountFromInterest;
                this.setPrincipalAmount(newPrincipalAmount);
            }

            System.out.println("Amount earned from interest alone ..........." + totalInterestAmount);
            System.out.println("Principle amount at the end of this year....." + this.getPrincipalAmount());

        }
    }

    /**
     * @return the interestRate
     */
    public float getInterestRate() {
        return interestRate;
    }

    /**
     * @param interestRate the interestRate to set
     */
    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * @return the principalAmount
     */
    public float getPrincipalAmount() {
        return principalAmount;
    }

    /**
     * @param principalAmount the principalAmount to set
     */
    public void setPrincipalAmount(float principalAmount) {
        this.principalAmount = principalAmount;
    }

    /**
     * @return the years
     */
    public int getYears() {
        return years;
    }

    /**
     * @param years the years to set
     */
    public void setYears(int years) {
        this.years = years;
    }

    /**
     * @return the repeatPeriod
     */
    public int getRepeatPeriod() {
        return repeatPeriod;
    }

    /**
     * @param repeatPeriod the repeatPeriod to set
     */
    public void setRepeatPeriod(int repeatPeriod) {
        this.repeatPeriod = repeatPeriod;
    }
}
