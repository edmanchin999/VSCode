//Write a C program to read temperature in centigrade

#include <stdio.h>
#include <math.h>

int main()
{
    double temperature;

    printf("Enter a temperature: ");
    scanf("%d", &temperature);

    if (temperature < 0)
    {
        prinf("It is freezing weather");
    }
    else if (temperature >= 0 && temperature < 10)
    {
        printf("It is very cold weather");
    }
    else if (temperature >= 10 && temperature < 20)
    {
        printf("It is a cold weather");
    }
    else if (temperature >= 20 && temperature < 30)
    {
        printf("It is a normal temperature");
    }
    else if (temperature >= 30 && temperature < 40)
    {
        printf("It is a hot weather");
    }
    else if (temperature >= 40)
    {
        printf("It is a very hot weather");
    }
    return 0;
}