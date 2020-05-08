"use strict"

/**
 * @author SARFO OWUSU PHILIP
 * <h2>Checkings Account Class</h2>
 * Provides checking account operations to account
 */

class CheckingAccount extends Account {

    constructor(number, overdraftLimit) {
        super(number)
        this._overdraftLimit = overdraftLimit
    }


    /**
     * Setter for `[this._overdraftLimit]`
     * @param {number} overdraftLimit 
     */
    setOverdraft(overdraftLimit) {
        this._overdraftLimit = overdraftLimit
    }

    /**
     * Getter for `[this._overdraftLimit]
     * @returns {number} 
     */
    getOverdraft() {
        return this._overdraftLimit
    }


    /**
     * Private Function which tests amount if not exceeded overdraftLimit
     * @param {Function} amountFunctor 
     * @param {Function} errorCallback sends callback
     */
    amountIsOverDraft(amount, amountFunctor, errorCallback) {
        if (amount >= this._overdraftLimit) {
            amountFunctor.call()
        } else {
            errorCallback.call()
        }
    }

    /**
     * Overrides `[withdraw()]` Function to take money out of the account
     * @param {number} amount 
     */
    withdraw(amount) {
        this.amountIsOverDraft(amount, function() {
            this.withdraw(amount)
        }, errorCallback => {
            throw Error("Cannot withdraw more than ${this.__overdraftLimit}!!")
        })
    }

    /**
     * Overrides toString Method to retrieve current account
     * @returns details of account
     */
    toString() {
        return 'Account Number: ' + this._number +
            '\nAccount Type: Checking Account' +
            '\nBalance: ' + this._balance
    }

    /**
     * Returns a warning if account is low
     */
    endOfMonth() {
        if (super.getBalance() === 0) {
            return "Warning, low balance CheckingAccount 3:" + this._balance + " overdraft limit:" + this._overdraftLimit
        } else {
            return ""
        }

    }
}