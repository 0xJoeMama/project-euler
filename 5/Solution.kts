val maxNumber = 20

val primes: MutableList<Int> = mutableListOf()
generateSequence(2) { it + 1 }
    .take(maxNumber)
    .forEach { if (primes.none { prime -> it % prime == 0 }) primes.add(it) }


fun Int.toThe(exponent: Int): Int {
    if (exponent == 1) {
        return this
    }
    return this * this.toThe(exponent - 1)
}

fun nextPrime(num: Int): Int {
    return primes.first { it > num }
}

fun primeFactorProduct(num: Int): Map<Int, Int> {
    var currentMaxFactor = 2

    val ret = mutableMapOf<Int, Int>()
    var currentNum = num
    while (currentNum > 1) {
        if (currentNum % currentMaxFactor == 0) {
            ret.put(currentMaxFactor, ret[currentMaxFactor]?.plus(1) ?: 1)
            currentNum /= currentMaxFactor
        } else {
            currentMaxFactor = nextPrime(currentMaxFactor)
        }
    }

    return ret
}

val primeProducts: Map<Int, Map<Int, Int>> = generateSequence(0) { it + 1 }
    .take(maxNumber)
    .map { it to primeFactorProduct(it) }
    .toMap()

println(primeProducts)
val result = mutableMapOf<Int, Int>()
primeProducts.flatMap { it.value.entries }.toSet().forEach { (key: Int, value: Int) ->
    result[key] = if (result.getOrPut(key) { value } < value) value else result.getValue(key)
}

val output = result.map { it.key.toThe(it.value) }.reduce { acc, d -> acc * d }
for (i in 1..maxNumber) {
    if (output % i != 0) {
        throw RuntimeException("Invalid output: $output is not evenly divisible by $i")
    }
}

println(output)