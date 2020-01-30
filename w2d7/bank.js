"use strict"

/**
 * @author SARFO OWUSU PHILIP
 * Provides banking operations
 */
class Bank {



    constructor() {
        this._accounts = [
            new SavingsAccount(122, 3),
            new CheckingAccount(1223, 100)
        ]
    }

    /**
     * Add an account to the array
     * @param {number} number 
     * @returns {Account} 
     */
    addAccount(number) {
        return this._accounts.push(new Account(number))
    }

    /**
     * Adds savings account 
     * @param {number} number 
     * @param {number} interest 
     * @returns {Account} savings account
     */
    addSavingsAccount(number, interest) {
        return this._accounts.push(new SavingsAccount(number, interest))
    }

    /**
     * Adds Checking Account
     * @param {number} number 
     * @param {number} overdraft 
     * @returns {Account} checking account
     */
    addCheckingAccount(number, overdraft) {
        return this._accounts.push(new CheckingAccount(number, overdraft))
    }

    /**
     * Removes account from array
     * @param {number} number 
     */
    closeAccount(number) {
        let account = this._accounts.find(function(value, index) {
            return value.getNumber() === number
        })
        this._accounts.splice(account, 1)
    }

    /**
     * Retrieves an Account Report
     */
    accountReport() {
        this._accounts.forEach(account => {
            console.log(account.toString())
        })
    }


    /** Retr */
    nextNumber() {
        return this._accounts[0].toString()
    }

    /**  */
    endOfMonth() {
        this._accounts.forEach(account => {
            console.log(account.endofMonth())
        })
    }
}