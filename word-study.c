// 역대급 멘탈 붕괴를 초래한 문제

#include <stdio.h>
#include <string.h>

int main(void)
{
    int max = 0;
    int t = 0;
    int p = 0;
    int w = 0;
    int k[26];

    char S[1000000];

    scanf("%s", S);

    // 별도 library에서 가져오는 함수는 호출 횟수를 최소화해야 속도가 올라간다.
    int len = strlen(S);

    // 초기값 관리는 귀찮더라도 만약(메모리에 garbage number 있는 경우)에 대비하여 필수이다.
    for (int i = 0 ; i < 26 ; i++)
    {
        k[i] = 0;
    }

    // 알파벳 사용 회수 알고리즘은 금방 완성했다.
    for (int i = 0 ; i < len ; i++)
    {        
        if (S[i] <= 90 && S[i] >= 65)
        {
            k[S[i]-65]++;
        }
        else if (S[i] >= 97 && S[i] <= 122)
        {
            k[S[i]-97]++;
        }
    }

    for (int i = 0 ; i < 26 ; i++)
    {  
        
        if (k[i] > max)
        {
            max = k[i];
            t = i+65;

          // 이미 중복이 count된 상태에서 max 값이 갱신되었을 때,
          // 새로운 max 값의 중복이 나타나기 전까지는 w=0이어야 ?를 return하지 않는다.
            if (w == 1 && max != p)
            {
                w = 0;
            }
        }

        else if (k[i] == max && max != 0)
        {
                
                // 중복으로 w 값이 올라가지 않도록 조건을 확인한다.
                if (w == 0)
                {
                    w++;
                    p++;
                }
        }
    }

    if (w != 0)
    {
        printf("?\n");
    }
    else
    {
        printf("%c\n", t);
    }
}
