// double의 상대오차인 10^(-15)를 확인한 경험
// atoi, atof 함수 사용 시 주의
// 여러 library 경험 - math.h, stdlib.h, string.h

#include <stdio.h>

int main(void)
{
    int N;
    int sum = 0;

    scanf("%d", &N);

    char X[N+1];
    int num;
    
    scanf("%s", X);

    for (int j = 0 ; j < N ; j++)
    {
        sum += X[j] -48;
    }

    printf("%d\n", sum);

}
