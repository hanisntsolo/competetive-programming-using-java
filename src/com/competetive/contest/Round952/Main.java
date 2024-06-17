#include <iostream>
#include <vector>
#include <cmath>

const long long MOD = 1000000007;

long long sumOfDigits(__int128 n) {
    long long sum = 0;
    while (n != 0) {
        sum += n % 10;
        n /= 10;
    }
    return sum;
}

long long countValidNumbers(long long l, long long r, long long k) {
    __int128 lower = pow(10, l);
    __int128 upper = pow(10, r);
    long long count = 0;

    for (__int128 n = lower; n < upper; ++n) {
        if (sumOfDigits(k * n) == k * sumOfDigits(n)) {
            count++;
            if (count >= MOD) {
                count -= MOD;
            }
        }
    }

    return count;
}

int main() {
    int t;
    std::cin >> t;
    std::vector<std::vector<long long>> testCases(t, std::vector<long long>(3));

    for (int i = 0; i < t; ++i) {
        std::cin >> testCases[i][0] >> testCases[i][1] >> testCases[i][2];
    }

    for (int i = 0; i < t; ++i) {
        long long l = testCases[i][0];
        long long r = testCases[i][1];
        long long k = testCases[i][2];
        std::cout << countValidNumbers(l, r, k) << std::endl;
    }

    return 0;
}
