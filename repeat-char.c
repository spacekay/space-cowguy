#include <stdio.h>
#include <string.h>

int main(void)
{
    int T,R;
    int k[20];

    scanf("%d", &T);

    char S[1000][20];

    for (int i = 0 ; i < T ; i++)
    {
        scanf("%d", &R);
        scanf("%s", S[i]);

        k[i] = 0;

      
        // for문의 조건 설정할 때 사용하는 constant를 잘 확인 (boundary condition check)
        for (int j = 0 ; j < strlen(S[i]) ; j++)
        {
            while (k[j] < R)
            {
                    printf("%c", S[i][j]);
                    k[j]++;
            }

            k[j] = 0;
        }

        printf("\n");
    }
}
