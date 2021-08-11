// declare some libraries for this program

#include <stdio.h>
#include <cs50.h>

int main(void) {

// get any number from the user
    int num = get_int("What number do you want to judge? \n");

        // zero need to be seperated first

        if (num == 0)
        {
        printf("zero\n");
        }
        
        // next find the even numbers

        else if (num % 2 == 0)
        {
        printf("even\n");
        }
        
        // All the left numbers are odd ones
       
        else
        {
            printf("odd\n");
        }
    }
