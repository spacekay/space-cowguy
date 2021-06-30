#include <stdio.h>

int main(void)
{
    int N;
    
    // key point : when we use the division, must check each datatype of variables
    float M = 0;
    float A = 0;

    scanf("%d", &N);

    int arr[N];

    for (int i = 0 ; i < N ; i++)
    {
        scanf("%d", &arr[i]);

        if (arr[i] > M)
        {
            M = arr[i];
        }
    }

    for (int j = 0 ; j < N ; j++)
    {
            A = A + arr[j]/M*100;
    }

    printf("%.3f\n", A/N);
}
