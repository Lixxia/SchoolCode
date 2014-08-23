/* Using structures, lists of structures, and demonstrating the use of pointers to access them. */

#include <stdio.h>
#define MAX 2
main()
{

   /* define a structure with partial mailing information */
   struct mailing {
	char name[60];	/* last name, first name */
	int zip;  /* numeric zip code */
   } ; /* end structure mailing */

   /* put data for two records into an array of structures with partial mailing information */
   struct mailing list[MAX]= {
      {"Smith Sally", 70586},
      {"Benson George", 29424}  
   }; 
 
   struct mailing *listPtr = &list[0];
   printf("The zip at index 0 is %d\n", (*listPtr).zip); 
   printf("The zip at index 1 is %d\n", (*(listPtr+1)).zip); 
   printf("\nThe zip at index 0 is %d\n", listPtr->zip);
   listPtr++;
   printf("The zip at index 1 is %d\n", listPtr->zip);


   return 0;
}