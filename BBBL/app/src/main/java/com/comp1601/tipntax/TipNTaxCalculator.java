package com.comp1601.tipntax;

public class TipNTaxCalculator {
    public static final double mDefaultTaxRate = 13.0; // this is ontario's default tax percentage
    public static final double mDefaultTipPercentage = 15.0; // this is the default tip percentage
    public static final double mInvalidResult = -1.0; // this is the invalid result that will return

    private double mTaxRate;
    private double mTipPercentage;
    private double mAmount;

    public TipNTaxCalculator(){
        mTaxRate = mDefaultTaxRate;
        mTipPercentage = mDefaultTipPercentage;

    }

    public TipNTaxCalculator(double mTaxRate, double mTipPercentage){
        this.mTaxRate = mTaxRate;
        this.mTipPercentage = mTipPercentage;
    }


    public static double getmDefaultTaxRate() {
        return mDefaultTaxRate;
    }

    public static double getmDefaultTipPercentage() {
        return mDefaultTipPercentage;
    }

    public double getmTaxRate() {
        return mTaxRate;
    }

    public double getmTipPercentage() {
        return mTipPercentage;
    }

    public void setmAmountRate(double mAmount) {
        this.mAmount = mAmount;
    }

    public void setmTaxRate(double mTaxRate) {
        this.mTaxRate = mTaxRate;
    }

    public void setmTipPercentage(double mTipPercentage) {
        this.mTipPercentage = mTipPercentage;
    }

    public double calculate(double amount){
        if(mTaxRate<=0 || mTaxRate >100.00 || mTipPercentage <0 || mTipPercentage > 100.00) return mInvalidResult;
        if(mTipPercentage<0) return mInvalidResult;
        if (amount<0) return mInvalidResult;
        // This is setting the reasonable restaurant rate
        if (amount>3000.00) return mInvalidResult;



        return amount*(1.0 + (mTaxRate/100))*(1.0+(mTipPercentage/100));
    }

}
