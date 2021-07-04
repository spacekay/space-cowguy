//수학적인 방식으로 보다 간단하게 알고리즘 완성

#include <stdio.h>

int main(void)
{
   int k = 0;
   int sum = 1;

   unsigned int N;

   scanf("%d",&N);

   for (int i = 0 ; ; i++)
   {
       if (N > sum)
       {
           sum += 6*(i+1);
           k++;
       }
       else
       {
           k++;
           printf("%d\n", k);
           return 0;
       }
   }
}
