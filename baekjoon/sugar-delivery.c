#include <stdio.h>

int main(void)
{
    unsigned int N, M;
    int a = 0;
    int b = 0;

    scanf("%d", &N);

    if (N%10 == 1 || N%10 == 6)
    {
        a = 2;       
    }
    else if (N%10 == 2 || N%10 == 7)
    {
        a = 4;
    }
    else if (N%10 == 3 || N%10 == 8)
    {
        a = 1;
    }
    else if (N%10 == 4 || N%10 == 9)
    {
        a = 3;
    }

    M = (N-a*3);
    b = M/5;
  
    // 4 뿐만 아니라 7까지 반례가 될 수 있음을 확인하여야 했다.
    if (N == 4 || N == 7)
    {
        printf("-1\n");
    }
    else
    {
        printf("%d\n", a+b);
    }

    return 0;
}
