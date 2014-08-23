/*
	C_pointers_3.c

	Demonstrates 3 different ways to traverse an array
*/

#include <stdio.h>
#define MAX 5
int main()
{
    double data[MAX] = { 34.0, 27.0, 45.0, 82.5, 22.1 };
    int i;
    /* Accessed in the usual way, via changing index value */
    for (i = 0; i < MAX ; i++)
        printf("data[%d]=%5.2f is at address %u\n", i, data[i], &data[i]);

    /* Accessed via pointer */
    double *data_ptr = &data[0];  /* data_ptr points to location data[0] */
    printf("\ndata[0] = %f \n\n", *data_ptr);

    /* Can iterate through array using pointers */
    for (i = 0; i < MAX; i++)
       printf("data[%d]=%5.2f\n", i, *(data_ptr + i));

    /* in previous loop, address in data_ptr did not change */
    printf("\ndata_ptr stores address %x, value stored there is %f\n\n", data_ptr, *data_ptr);


    /* Another way of iterating over element in data */
    for (i = 0; i < MAX; i++)
       printf("data[%d]=%5.2f\n", i, *data_ptr++);

    /* address in data_ptr DID change */
    printf("\ndata_ptr stores address %x, value stored there is %f\n\n", data_ptr, *data_ptr);



    return 0;
}
