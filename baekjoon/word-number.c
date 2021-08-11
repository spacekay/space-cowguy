#include <stdio.h>
#include <string.h>

int main(void)
{
    int t;
    char S[1000000];
    
  
    // scanf로 string 받을 때 조건 설정하는 법
    // ^는 반전 효과
    scanf("%[^\n]", S);
    int len = strlen(S);

    // 단어 입력 없이 공백만 있는 경우도 반영할 수 있어야 함
    if (S[0] == ' ' && S[1] == '\0')
    {
        t=0;
    }
    else
    t=1;

    for (int i = 1 ; i < len - 1 ; i++)
    {
        if (S[i] == ' ')
        {
            t++;
        }
    }

    printf("%d\n", t);
}
