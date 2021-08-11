#include <stdio.h>
#include <math.h>

int main(void)
{
    
  // 제출 전 필요 없는 변수나 출력 함수 남아있는지 확인
  unsigned int X, H, W, N;
    int x = 1;
    int y = 0;

    scanf("%d", &X);

    for (int m = 0 ; m < X ; m++)
    {
        x = 1;
        y = 0;
        
        scanf("%d%d%d", &H, &W, &N);

        for (int i = 0 ; i < N ; i++)
        {
            if (y == H)
            {
                y = 1;
                x++;
            }
            else 
            {
                y++;
            }
        }

    printf("%d\n", 100*y+x);

    }

    return 0;
}
