/*
    C_pointers_8.c

    Sending pointers as parameters

*/

#include <stdio.h>
int main()
{

   void pointer_as_parameter1(int *);

   int something, somethingElse;
   int *first_ptr;  /* will point to an int */
   int *second_ptr; /* will point to an int */

   something = 11;
   first_ptr = &something;
   second_ptr = first_ptr;

   printf("Confirming values and addresses of each variable.\n");
   printf("1- something is %d, stored at %u\n", something, &something);
   printf("2- first_ptr is %u, stored at %u, referencing %d\n", first_ptr, &first_ptr, *first_ptr);
   printf("3- second_ptr is %u, stored at %u, referencing %d\n\n", second_ptr, &second_ptr, *second_ptr);

   pointer_as_parameter1(&something);

   printf("\n1- something is %d\n", something);
   printf("2- something is %d\n", *first_ptr);
   printf("3- something is %d\n\n", *second_ptr);

   pointer_as_parameter1(first_ptr);

   printf("\n1- something is %d\n", something);
   printf("2- something is %d\n", *first_ptr);
   printf("3- something is %d\n\n", *second_ptr);


   return 0;
}

void pointer_as_parameter1(int * parameter1)
{
   printf("Parameter incoming value is %u\n", parameter1);
   *parameter1 = *parameter1 + 25;
}