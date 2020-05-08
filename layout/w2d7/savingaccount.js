"use strict"

/**
 * @author SARFO OWUSU PHILIP
 * Savings account class
 * Provides saving operations to account
 */
class SavingsAccount extends Account {


    constructor(number, interest) {
        super(number)
        this._interest = interest
    }

    /**
     * Adds account's interest
     * @param {Number} interest 
     */
    setInterest(interest) {
        this._interest = interest
    }

    /**
     * @returns interest
     */
    getInterest() {
        return this._interest;
    }

    /**
     * Method Deposits interest in account
     */
    addInterest() {
        //Computes interest
        const interestAmt = this._balance * (this._interest / 100)

        //Deposits interestAmt
        this.deposit(interestAmt)
    }


    /**
     * Overrides toString Method to retrieve current account
     * @returns details of account
     */
    toString() {
        return "SavingsAccount 1: balance: " + this._balance + " interest: " + this._interest
    }

    /**
     * Invokes addInterest() and returns a account interest details
     */
    endOfMonth() {
        this.addInterest()
        return "Interest added SavingsAccount 1: balance: " + this._balance + " interest: " + this._interest
    }

}