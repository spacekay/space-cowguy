#include <stdio.h>

int main(void)
{
    int arr[10];
    int brr[10];
    int t=0;

    for (int i=0 ; i < 10 ; i++)
    {
        scanf("%d", &arr[i]);

        brr[i]=0;

        for (int j = 0 ; j < i+1 ; j++)
        {
            if ((arr[i]%42) != (arr[j]%42))
            {
                brr[i]++;
            }
        }
    }

    for (int k = 0 ; k <10 ; k++)
    {
        if ( brr[k]-k+1 > 0 )
        {
            t++;
        }
    }
    printf("%d\n", t);
}
