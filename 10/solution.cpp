#include <iostream>
#include <vector>

int main() {
  std::vector<uint32_t> primes;
  uint64_t sum = 0;

  // we could sieve through this...or we could not
  for (uint32_t i = 2; i < 2000000; i++) {
    bool out = false;
    for (const auto prime : primes) {
      if (prime > (i >> 1)) {
        break;
      }

      if (i % prime == 0) {
        out = true;
        break;
      }
    }

    if (out) {
      continue;
    }

    primes.push_back(i);
    sum += i;
  }

  std::cout << sum << std::endl;

  return 0;
}
