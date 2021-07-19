#include <stdio.h>
#include <string.h>

int main(void)
{
    int N, L, s;

    scanf("%d",&N);

    int t = 0;
    
    //maximum length는 미리 정의를 해야 이후 단계를 무난하게 진행 가능
    char quiz[80];

    for (int j = 0 ; j < N ; j++ )
    {
        s = 0;
        t = 0;

        //string을 scan하는 법 확인
        scanf("%s", quiz);
        L = strlen(quiz);

        for (int i = 0 ; i < L ; i++)
        {
            if (quiz[i] == 'O')
            {
                t++;
                s += t;
            }
            else if (quiz[i] == 'X')
            {
                t = 0;
            }
        }

        printf("%d\n", s);
    }
}
