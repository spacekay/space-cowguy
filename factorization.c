#include <stdio.h>

int main(void)
{
    unsigned int x, y, n;
    int t = 0;
    int sum = 0;
    int min = 10000;

    scanf("%d", &n);

    if (n == 1)
    {
        return 0;
    }

    t = n;

    for (int j = 2 ; j <= n ; j++)
    {
        
      // 아래의 if문을 while문으로 바꾸었다면 속도가 더 증가했을 것이다.
      // 조건 만족할 때까지 (ex:2로 더이상 나눌 수 없을 때까지) 소인수 j를 늘리지 않고 계속 연산 가능
      if (t%j == 0)
        {
            t /= j;            
            printf("%d\n", j);
            j -= 1;
        }
        else if (t == 1)
        {
            break;
        }
    }
}
