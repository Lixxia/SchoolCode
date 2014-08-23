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
      {"Smith Sally", 29466},
      {"Benson George", 29424}  
   }; 
 
   int number_of_entries = 2;

   /* Array of POINTERS to the data */ 
   struct mailing *list_ptrs[MAX]; 

   int current;  /* current mailing list entry */

   /* print contents of list */
   printf("contents printed directly from array of structures\n");
   for (current = 0; current < number_of_entries; current++)
      printf("Record %d stores %s, %d\n", current + 1, list[current].name, list[current].zip);   

   /* Each element in list_ptrs[i] points to the corresponding element in list[i] */
   for (current = 0; current < number_of_entries; current++) 
	list_ptrs[current] = &list[current];

   /* print contents of list  through list_ptrs */
   printf("\ncontents printed from pointers to data\n");
   for (current = 0; current < number_of_entries; current++)
       printf("Record %d stores %s, %d\n", current+1, list_ptrs[current]->name, list_ptrs[current]->zip);   


  /* swapping the pointers at list_ptrs[0] and [1] */
  struct mailing *temp = list_ptrs[0];
  list_ptrs[0] = list_ptrs[1];
  list_ptrs[1] = temp;

   /* print contents of list, after swapping pointers, as seen through list pointers */
   printf("\nvirtual contents of list as seen through  pointers to data\n");
   for (current = 0; current < number_of_entries; current++)
      printf("Record %d stores %s, %d\n", current+1, list_ptrs[current]->name, list_ptrs[current]->zip);   

   /* print contents of actual list */
   printf("\ncontents of actual list printed directly from array of structures\n");
   for (current = 0; current < number_of_entries; current++)
      printf("Record %d stores %s, %d\n", current + 1, list[current].name, list[current].zip);   

   return 0;
}