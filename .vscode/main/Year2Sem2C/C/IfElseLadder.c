//Program to realte two integers using =, > or < symbol

#include <stdio.h>
int main()
{
    int number1, number2;
    printf("Enter two integers: ");
    scanf("%d,%d", &number1, &number2);

    //check uf the two integes are equals
    if (number1 == number2)
    {
        printf("Result: %d = %d", number1, number2);
    }

    //check if number1 is greater than number2.
    else if (number1 > number2)
    {
        printf("Result: %d > %d", number1, number2);
    }
    else
    {
        printf("Result: %d<%d", number1, number2);
    }
    return 0;
}