#include <stdio.h>
#include <math.h>

int main(void)
{
    double A = 0;
    double B = 0;
    double V = 0;
    double day = 0;

    scanf("%lf%lf%lf", &A, &B, &V);

    day = ceil((V-B)/(A-B));
    
    printf("%d\n", (int) day);
  
}
