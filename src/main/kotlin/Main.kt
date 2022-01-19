fun main(args: Array<String>) {


    // ****************** Project Euler - Problem 1 - BEGIN **************************
    // https://projecteuler.net/problem=1

    // brute-force method
    val sumValBruteForce = bruteForceMethod(999)
    // smart method
    val sumValSmartMethod = smartMethod(999)


    // test cases brute force method
    if (bruteForceMethod(999) != 233168)
        println(" WARNING, WARNING : All sum of 999 should be 233168")
    if (bruteForceMethod(9) != 23)
        println(" WARNING, WARNING : All sum of 9 should be 23")

    // test cases smart method
    if (smartMethod(999) != 233168)
        println(" WARNING, WARNING : All sum of 999 should be 233168")
    if (smartMethod(9) != 23)
        println(" WARNING, WARNING : All sum of 9 should be 23")

    println("Answer via bruteForceMethod  $sumValBruteForce")
    println("Answer via smartMethod  $sumValSmartMethod")

    // ****************** Project Euler - Problem 1 - END ****************************


    // ****************** Project Euler - Problem 2 - BEGIN **************************
    // https://projecteuler.net/problem=2


    val sumOfEvenFibonacci = sumOfEvenFibonacciSequence(34)

    println("******** Problem 2 ********")
    println("Answer via bruteForce $sumOfEvenFibonacci")

}

fun sumOfEvenFibonacciSequence(maxVal: Int): Int {
    var sumOfItems: Int = 0; var result = 0
    var previousVal = 0; var currentVal = 1


    do{
        result = previousVal + currentVal
        previousVal = currentVal
        currentVal = result
        println(currentVal)

        if(result %2 ==0)
            sumOfItems += result

    }while (currentVal <= 4000000)
    return sumOfItems
}

fun addCurrentValAndPrevVal(currentVal: Int, previousVal: Int): Int {
    return  currentVal + previousVal

}

private fun smartMethod(countToVal: Int): Int {

    // The problem in our case is the
    // series is in either 3+6+9... N or 5+10+15+... N
    // This can be broken into 3 * (1+2+3+.. N) or 5 * (1+2+3+... N)

    // Formula to calculate addition of 1+2+3+.... N is n(n+1)/2
    // For finding addition of all multiples of 3, the above can be broken into 3 * (N/3 ( N/3 +1 ) /2)
    // For finding addition of all multiples of 5, the above can be broken into 5 * (N/5 ( N/5 +1 ) /2)

    // Note: We need to discount multiples of both 3 and 5, like 15 as expressed below.

    return (3 * sumOfNDivByP(countToVal, 3) + 5 * sumOfNDivByP(countToVal, 5)) - 15 * sumOfNDivByP(countToVal, 15)
}

private fun sumOfNDivByP(n: Int, p: Int): Int {
    return n / p * (n / p + 1) / 2
}

private fun bruteForceMethod(countToVal: Int): Int {
    var sumVal = 0

    for (i in 1..countToVal) {
        if (i % 3 == 0 || i % 5 == 0)
            sumVal += i
    }

    return sumVal
}