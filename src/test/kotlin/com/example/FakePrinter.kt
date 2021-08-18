package com.example

class FakePrinter: Printer {
    var printString=""
    var count:Int =0
    override fun print(text:String)
    {
        count++
        printString =text
    }
}