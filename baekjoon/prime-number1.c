#include <stdio.h>

int main(void)
{
    unsigned int x, y, n;
    int t = 0;
    int sum = 0;
    int min = 10000;

    scanf("%d%d", &x, &y);

    for (int i = x ; i <= y ; i++)
    {       
        for (int j = 2 ; j < i ; j++)
        {
            if (i%j == 0)
            {
                break;
            }
            else if (i-1 == j)
            {
                sum += i;
                t++;
                
                if (min > i)
                {
                    min = i;
                }
            }
        }

        // 소수 관련 알고리즘에서 2를 처리하는 부분이 중요하다.
        // 무언가 2를 분리하는 식 안에 다른 조건문에 들어있는 내용 중 빠트린 것이 없는지 확인하자.
      
        if (i == 2)
        {
            sum += i;
            t++;

            if (min > i)
            {
                min = i;
            }
        }
    }
  
    if (t == 0)
    printf("-1\n");
    else
    printf("%d\n%d\n", sum, min);

    return 0;
}
