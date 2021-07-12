// 에라토스테네스의 체를 응용하는 법은 조금 더 연구가 필요할 듯. 기본 정의에 충실하게 코딩하였다.

#include <stdio.h>

int main(void)
{
    unsigned int n;
    int t = 0;

    scanf("%d", &n);

    int P[n];

    for (int i = 0 ; i < n ; i++)
    {
        scanf("%d", &P[i]);
        
        for (int j = 2 ; j < P[i] ; j++)
        {
            if (P[i]%j == 0)
            {
                break;
            }
            else if (P[i]-1 == j)
            {
                t++;
            }
        }

        if (P[i] == 2)
        {
            t++;
        }
    }
  
    printf("%d\n", t);

    return 0;
}
