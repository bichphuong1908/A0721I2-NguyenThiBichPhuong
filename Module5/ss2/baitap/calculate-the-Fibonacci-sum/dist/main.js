- > Int;
function Fibonacci(num) {
    let a = 1, b = 0, temp;
    while (num > 0) {
        temp = a;
        a = a + b;
        b = temp;
        num--;
    }
    return b;
}
{
    let sum = 0;
    for (i in 0.. < n) {
        sum += Fibonacci(n);
    }
    return sum;
}
//# sourceMappingURL=main.js.map