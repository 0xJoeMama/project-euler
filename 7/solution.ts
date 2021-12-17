//
// Problem 7
//

const max_prime_index: number = 10001

const primes_before: number[] = []

for (let i = 0, last = 2; i < max_prime_index; i++) {
    while (primes_before.some((prime) => last % prime == 0)) {
        last++;
    }

    primes_before.push(last)
}

const result: number = primes_before[primes_before.length - 1];
console.log(result)