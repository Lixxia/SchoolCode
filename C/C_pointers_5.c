/* Adapted from Practical C Programming by S. Oualline */
/* Initializing arrays */

#include <stdio.h>
#define MAX 5


int main()
{

    int data[MAX];  
    int i;

    /* prototypes for procedures that appear later */
    void init_array_1();
    void init_array_2();

    /* Accessed via pointer */
    int *data_ptr = &data[0];  /* data_ptr points to location data[0] */
  
   
    printf("Before explicit initialization.\n");
    for (i = 0; i < MAX; i++)
       printf("data[%d]=%d\n", i, *(data_ptr + i));

    init_array_1(data); /* Address of data automatically sent */

/*    init_array_1(&data[0]); */ /* Also works */

/*    init_array_2(data); */ /* Works, as well. */

/*    init_array_2(&data[0]); */ /* Works... */

    printf("\nAfter explicit initialization.\n");
    for (i = 0; i < MAX; i++)
       printf("data[%d]=%d\n", i, *(data_ptr + i));

    return 0;
}

/* Initialize array to all zeros */
/* Input the array */
void init_array_1 (int a[])
{

   int index;
   for (index = 0; index < MAX; index++)
      a[index] = 0;
}

/* Alternative initialization routine */
void init_array_2 (int *array_ptr)
{
   int index;
   for (index = 0; index < MAX; index++)
      *(array_ptr + index) = 0;
}
