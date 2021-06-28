#include <stdio.h>

int main(void)
{
    int x,y,z;
    int i=0;
    int n;
    
    scanf("%d", &n);
    int a=n;

        do
        {
        if (a<10)
        {
            x=(a*10)/10;
            y=(a*10)%10;
            z=x+y;
            a=a*10+z%10;
            i++;
        }
        else
        {
            x=a/10;
            y=a%10;
            z=x+y;
            a=y*10+z%10;
            i++;
        }
        }
        while (a!=n);
    printf("%d\n", i);
    return 0;
}
