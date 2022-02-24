//Calcualte a hypotenuse
#include <stdio.h>
#include <math.h>
int main()
{
    int a, b, c;

    printf("Enter two integer");
    scanf("%d %d", &a, &b);

    c = hypotf(a, b);
    prinf("%d", c);
    return 0;
}