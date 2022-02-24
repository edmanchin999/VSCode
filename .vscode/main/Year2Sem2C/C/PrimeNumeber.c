#include <stdio.h>

int main()
{
    int input, i, flag = 0;
    printf("Enter a postive integer: ");
    scanf("%d", &input);

    for (i = 2; i <= input / 2; ++i)
    {
        //This is the condition for non-prime
        if (input % 2 == 0)
        {
            flag = 1;
            break;
        }
    }
    if (input == 1)
    {
        printf("1 is neither prime nor composite");
    }
    else
    {
        if (flag == 0)
        {
            printf("%d is a prime number.", input);
        }
        else
        {
            printf("%d is not a prime number.", input);
        }
    }
    return 0;
}