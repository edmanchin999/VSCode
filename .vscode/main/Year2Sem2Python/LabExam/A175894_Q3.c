
#include <stdio.h>

int rates;
int output;
float input;

int main()
{

    printf("Enter the number of hours: ");
    scanf("%f", &input);

    if (input <= 0)
    {
        printf("Number of hours should be grater than 0");
    }
    if ((input > 0) && (input <= 1))
    {
        printf("Your parking rate is RM1");
    }
    if ((input > 1) && (input <= 3))
    {
        printf("Your parking rate is RM2.5");
    }
    if ((input > 3) && (input < 8))
    {

        printf("I still dont know yet, why it must be RM11.50 for 5 hour but not RM9.5?");
    }
    if (input >= 8)
    {
        printf("Your parking rate is RM15.00");
    }
}
