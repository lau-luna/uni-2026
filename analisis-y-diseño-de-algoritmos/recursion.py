
def factorial(n):
    if n == 1:
        return 1
    return n * factorial(n-1)

def factorialCola(n, acc = 1):
    if n == 1:
        return acc
    return factorialCola(n-1, n * acc)

cache = {}

def fibonacci(n):
    if n <= 1:
        return n
    return fibonacci(n-1) + fibonacci(n-2)

def fibonacci_memo(n):
    if n in cache:
        return cache[n]
    if n <= 1:
        return n
    cache[n] = fibonacci_memo(n-1) + fibonacci_memo(n-2)
    return cache[n]

print(fibonacci_memo(55))
