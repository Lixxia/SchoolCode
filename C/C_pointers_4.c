/*
	C_pointers_4.c

	Array initialization. Does C initialize an array for you? */

#include <stdio.h>
#define MAX 5
int main()
{

    double data[MAX];
    int i;

    /* Accessed via pointer */
    double *data_ptr = &data[0];  /* data_ptr points to location data[0] */

    /* Can iterate through array using pointers */
    for (i = 0; i < MAX; i++)
       printf("data[%d]=%5.2f\n", i, *(data_ptr + i));

    return 0;
}
