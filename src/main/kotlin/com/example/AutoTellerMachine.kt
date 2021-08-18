package com.example

import java.lang.IllegalStateException

class AutoTellerMachine(private val printer: Printer, private val bankingService: BankingService) {
    fun withdraw(amount: Int) {
        try {
            bankingService.withdraw(amount)
            printer.print("${amount} withdrawal successful")

        } catch (e: IllegalStateException) {
            printer.print("Error withdrawing")
        }
    }
}