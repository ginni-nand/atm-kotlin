package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class AutoTellerMachineTest : StringSpec({
    "Should call Banking service with correct amount " {
        val printer = FakePrinter()
        val fakeBankingService =FakeBankingService(true)
        AutoTellerMachine(printer,fakeBankingService).withdraw(800)
        fakeBankingService.balance shouldBe 800

    }
    "should print a receipt if money is withdrawn successfully"  {
   // verify if printer was called or not
        //mock
        val printer = FakePrinter()
        //just return a fake response . does not care about verification
        //stub
        val fakeBankingService =FakeBankingService(true)
        AutoTellerMachine(printer,fakeBankingService).withdraw(800)
        printer.count shouldBe 1
        printer.printString shouldBe "800 withdrawal successful"
    }


    "should throw exception if banking service throws an exception" {
        val printer = FakePrinter()
        val fakeBankingService =FakeBankingService(false)
        AutoTellerMachine(printer,fakeBankingService).withdraw(800)
        printer.printString shouldBe "Error withdrawing"
    }
})