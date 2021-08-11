#include <stdio.h>

int hansu (int n);

int main(void)
{
    int X = 0;
    int N;
    
    scanf("%d", &N);

    for (int i = 0 ; i < N ; i++)
    {
        X += hansu(i+1);
         // printf("The hansu of %d : %d\n", i+1,hansu(i+1));
    }

    printf("%d\n", X);

}

int hansu (int m)
{
    int ns[4];
    int t = 1;
    int result = 1;

    for (int k = 0 ; k < 3 ; k++)
    {
        ns[k] = (m/t)%10;
        t *= 10;
    }

    if (m > 99 && m < 1000)
    {
        for (int k = 1 ; k < 2 ; k++)
        {

            if ((ns[k+1] - ns[k]) != (ns[k] - ns[k-1]))
            {
                result = 0;
                break;
            }
        }
    }

    else if (m == 1000)
    {
        result = 0;
    }

    return result;

}
