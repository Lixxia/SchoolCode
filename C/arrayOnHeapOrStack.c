/*
	arrayOnHeapOrStack.c

	Show how to allocate an array on the heap or the stack */

#include <stdio.h>
#define MAX 5
int main()
{
    /* declarations */
    int index;
    double * createArray1(); /* informing compiler that method def is later */
    double * createArray2(); /* informing compiler that method def is later */

    /* calls to methods */
    double *a = createArray1();
    double *b = createArray2();

    /* Display values in array a */
    double *data_ptr = a;
    index = 0;
    printf("Display contents returned through a.\n");
    while (index < MAX)
        printf("The value at a[%d] = %f\n", index++, *data_ptr++);
    /* Display values in array b */
    double *data_ptr2 = b;
    printf("\n\n");
    printf("Display contents returned through b.\n");
    index = 0;
    while (index < MAX)
        printf("The value at b[%d] = %f\n", index++, *data_ptr2++);

    return 0;
}

/* the array created here will be stored on the stack */
double * createArray1 ( ) {
    double data[MAX] = { 10, 100, 456, -3, 10.5};
    return data;
}

/* the array created here will be stored on the heap */
double * createArray2 ( ) {
    double *data = (double *)malloc(MAX * sizeof(double));
    /* store values in the array via pointer or index */
    *data = 15;
    *(data + 1) = 50;
    data[2] = 49.2;
    *(data + 3) = -3;
    data[4] = 11.5;
    return data;
}