#include <stdio.h>
int a, b;
int recursiveGCD(int a, int b)
{
    if (b == 0)
    {
        return a;
    }
    else
    {
        return recursiveGCD(b, a % b);
    }
}
int main()
{
    printf("ENter any two numbers to find GCD: ");
    scanf("%d %d", &a, &b);
    printf("GCD of %d and %d = %d", a, b, recursiveGCD(a, b));
    return 0;
}