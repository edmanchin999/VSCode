#include <stdio.h>

int main()
{
    float arr[7], sum = 0, average;

    for (int i = 0; i < 7; i++)
    {
        printf("Enter Temperature Reading of Day:%d =", i + 1);
        scanf("%f", &arr[i]);

        sum += arr[i];
    }

    average = sum / 7;
    printf("The Average Temperature of the week is = %.2f", average);
}