package com.example

class FakeBankingService(val input: Boolean) : BankingService {
    var balance=0
    override fun withdraw(amount: Int) {
         balance=amount
        if (!input) throw error("Not enough amount")
    }
}