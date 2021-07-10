// double 범위 이상 (약 300자리 이상) 숫자를 정확히 다루기 위해서는 string으로 

#include <stdio.h>
#include <string.h>

int main(void)
{

    // Out of bound runtime error는 array의 허용 범위 이상으로 점화식이 진행한 경우 발생   
  
    char a[10001];
    char b[10001];
    
    // 결과값은 A, B보다 한 자리 더 클 수 있다.
    char c[10002];
    c[10000] = '0';
    c[10001] = '0';

    for (int i = 0 ; i < 10000 ; i++)
    {
        a[i] = '0';
        b[i] = '0';
        c[i] = '0';
    }

    scanf("%s%s", a, b);

    int len_a = strlen(a);
    int len_b = strlen(b);
    int len_c = 0;
    int max = len_a;

    for (int i = 0 ; i < len_a ; i++)
    {
        c[i] = a[len_a-1-i];
    }

    for (int i = 0 ; i <len_b ; i++)
    {
        c[i] += b[(len_b-1-i)] - '0';
    }

    if (max < len_b)
        max = len_b;

    if (c[max-1]>'9')
    {
        len_c = max + 1;
    }
    else
    {
      // if문을 쓴 경우 else case에서 필요한 변수의 값을 모두 얻을 수 있는지 확인
      // 아닌 경우 추가 서술이 필요
      len_c = max;
    }

    for (int i = 0 ; i < len_c ; i++)
    {       
        if(c[i]>'9')
        {
            c[i] -= 10;
            c[i+1] += 1;
        }
    }

    if (c[len_c-1]=='0')
    {
        c[len_c] = '1';
        len_c++;
    }

    for (int i = 0 ; i < len_c ; i++)
    {
        printf("%c", c[len_c-1-i]);
    }

    printf("\n");

    return 0;
}
