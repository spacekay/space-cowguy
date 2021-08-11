#include <stdio.h>

int main(void)
{
    
    // 불필요한 변수 설정했던 것을 그대로 두지 않았는지 확인
  
    int C, N;
    float bttr = 0;
    int point[1000];
    float sum = 0;
    float avg;

    scanf("%d", &C);

    for ( int j = 0 ; j < C ; j++)
    {
        scanf("%d", &N);

        for ( int i = 0 ; i < N ; i++ )
        {
            scanf("%d", &point[i]);
            sum += point[i];
        }

        avg = sum/N;

        for ( int k = 0 ; k < N ; k++)
        {
            if (point[k] > avg)
            {
                bttr++;
            }
        }

        printf("%.3f%%\n", bttr/N*100);
        sum = 0;
        bttr = 0;

    }
}
