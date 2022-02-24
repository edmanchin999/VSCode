#include <stdio.h>

double num, answer;
double cube(double num)
{
    return num * num * num;
}
int main()
{
    printf("Input any number: ");
    scanf("%lf", &num);
    answer = cube(num);
    printf("Cube of %lf = %lf ", num, answer);
    return 0;
}
