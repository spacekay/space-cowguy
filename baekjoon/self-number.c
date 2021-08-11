#include <stdio.h>

int returnd (int n);

int main(void)
{
    int self[10000];

    for (int i = 0 ; i < 10000 ; i++)
    {
        self[i] = 0;
    }

    for (int i = 0 ; i < 10000 ; i++)
    {
        
        // 배열의 선언 범위 넘지 않도록 연산자 관리하기
      
        if ( returnd(i) <= 10000 )
        {
            self[returnd(i)]++;
        }
    }

    for (int j = 0 ; j < 10000 ; j++)
    {
        if (self[j]==0)
        {
            printf("%d\n", j);
        }
    } 
}

int returnd (int n)
{
    int sum = n;
    int t = 1;
    
    for (int k = 0 ; k < 5 ; k++)
    {
        sum += (n/t)%10;
        t *= 10;
    }

    return sum;
}
