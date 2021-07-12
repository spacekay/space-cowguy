// 코딩을 시작하기 전에 알고리즘을 수학적으로 구조화하는 것부터 필요할 때가 있다.

#include <stdio.h>

int main(void)
{
    unsigned int x, y, z, k;

    scanf("%d", &k);

    for (int i = 0 ; i < k ; i++)
    {
        scanf("%d%d", &x, &y);

        int sum = 0;
        int t = 1;
        int n = 1;

        z = y-x;

        while (sum*2 < z)
        {
            sum += t;
            t++;
        }

        if ( sum*2-t+1 >= z)
        {
            n = 2*(t-1)-1;
        }
        else
        {
            n = 2*(t-1);
        }

        printf("%d\n", n);
    }

    return 0;
}
