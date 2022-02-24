#include <stdio.h>

int arrays1[5] = {12, 3, 66, 4, 1, 5};
int sums = 0;
float Average = 0;

int main()
{
    for (int i = 0; i < 5; i++)
    {
        sums = sums + arrays1[i];
    }
    Average = sums / 5;
}