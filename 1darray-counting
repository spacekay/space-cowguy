#include <stdio.h>

int main(void)
{
    // 중간 중간 여러차례 꼬였던 코드라 변수 네이밍이 엉망진창
    // 차후엔 초반부터 네이밍 규칙 잡으면서 진행 예정
    
    int a, b, c, t;
    int j = 0;
    int times = 1;
    int times1 = 1;

    scanf("%d%d%d", &a, &b, &c);

    while (a*b*c > times)
    {
        j++;
        times *= 10;
    }

    int m = j;

    int arr1[10];

    for (int p = 0; p < 10 ; p++)
    {
        arr1[p]=0;
    }

    for (int i = 0 ; i < m ; i++)
    {
        t = a*b*c/times1;
        arr1[t%10]++;
        times1 *= 10;
    }

    for (int l = 0 ; l < 10 ; l++)
    {
        printf("%d\n", arr1[l]);
    }
}
