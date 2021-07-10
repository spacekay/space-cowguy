#include <stdio.h>

int main(void)
{

    unsigned int X, T, D;
    int A[2] = {0,0};
    int sum = 0;

    scanf("%d", &X);

    for(int k = 0 ; ; k++)
    {
        sum += (k+1);

        if (sum >= X)
        {
            T = k+1;
            D = sum - X;
            break;
        }
    }


    if (T%2 == 1)
    {
        A[0] = 1;
        A[1] = T;

        for (int i = 0 ; i < D ; i++)
        {
            A[0] += 1;
            A[1] -= 1;
        }
    }
    else
    {
        A[0] = T;
        A[1] = 1;

        for (int i = 0 ; i < D ; i++)
        {
            A[0] -= 1;
            A[1] += 1;
        }
    }

    printf("%d/%d\n", A[0],A[1]);

}
