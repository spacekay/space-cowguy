#include <stdio.h>

int main(void)
{
    // a : 연간 고정비용 (시간의 흐름은 고려하지 않음)
    // b : 대당 생산비용
    // c : 대당 가격

    // overflow 방지용
    unsigned int a, b, c, t;

    // float보다는 double이 안정성이 높음
    double x;
    
    // x : 방정식의 해를 보정하여 만든 노트북의 대수

    scanf("%d%d%d", &a, &b, &c);

    if (c > b)
    {
        // 형변환 시 늘 주의
        x = (int) a/(c-b);
        t = x+1;
    }
    else
    {
        t = -1;
    }

    printf("%d\n", t);

}
