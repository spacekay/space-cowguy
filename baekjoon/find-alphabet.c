#include <stdio.h>
#include <string.h>

int main(void)
{
    char S[100];
    int pos[26];

    scanf("%s", S);

    for (int j = 0 ; j <26 ; j++)
    {
        pos[j] = -1;
    }

    for (int i = 0 ; i < strlen(S) ; i++ )
    {
        if (pos[S[i]-97] == -1)
        pos[S[i]-97] += i+1;
    }

    for (int i = 0 ; i <26 ; i++)
    {
        printf("%d ", pos[i]);
    }

    printf("\n");

}
