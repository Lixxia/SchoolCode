/*
	C_pointers_2.c

	Adapted from Practical C Programming, by S. Oualline

	Demonstrates how to use pointers to change the contents
	of a parameter and have it reflected in the calling routine.
*/

#include <stdio.h>
main()
{
   int count = 0; /* number of time through */

   void inc_count(int *); /* update the counter */

/*   while (count < 10) */
      inc_count(&count);
   printf("count is %d\n", count);
   return 0;
}

void inc_count(int *count_ptr)
{
/*   (*count_ptr)++; */
   /* other ways of doing this:*/
   *count_ptr += 1;
}