/*
    C_pointers_1.c

    Loosely based on example from Practical C Programming, by S. Oualline
    Demonstrates pointers to integers
*/

#include <stdio.h>
int main()
{

   int something, somethingElse;
   int *first_ptr;  /* will point to an int */
   int *second_ptr; /* will point to an int */

   something = 11;
   first_ptr = &something;
   second_ptr = first_ptr;

   printf("1- something is %d\n", something);
   printf("2- something is %d\n", *first_ptr);
   printf("3- something is %d\n\n", *second_ptr);

   /* change something this way */
   something += something; /* adds value to itself */
   printf("4- something is %d\n", something);
   printf("5- something is %d\n", *first_ptr);
   printf("6- something is %d\n\n", *second_ptr);

   /* change something this way */
   *first_ptr = 17; /* reassign the value through first_ptr */
   printf("7- something is %d\n", something);
   printf("8- something is %d\n", *first_ptr);
   printf("9 - something is %d\n\n", *second_ptr);

   /* change something this way */
   *second_ptr = -44; /* reassign the value through second_ptr */
   printf("10- something is %d\n", something);
   printf("11- something is %d\n", *first_ptr);
   printf("12 - something is %d\n\n", *second_ptr);

   /* copy something into somethingElse - is somethingElse an alias? */
   somethingElse = something; /* but they are separate memory locations */
   printf("13- something is %d, somethingElse is %d\n", something, somethingElse);

   /* change something this way */
   *second_ptr = 118;
   printf("13- something is %d, somethingElse is %d\n", something, somethingElse);


   return 0;

}
