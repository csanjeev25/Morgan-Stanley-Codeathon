import sys

def maximizeProfit(a, b, m, k):
    bitcoinDollar = m*k
    c = [];
    c.append(bitcoinDollar)
    for i in range(n):
        d = m * b[i] * a[i];
        c.append(d);
    e = max(c);
    return e

if __name__ == "__main__":
    n, m, k = input().strip().split(' ')
    n, m, k = [int(n), int(m), int(k)]
    a = list(map(int, input().strip().split(' ')))
    b = list(map(int, input().strip().split(' ')))
    result = maximizeProfit(a, b, m, k)
    print(result)
