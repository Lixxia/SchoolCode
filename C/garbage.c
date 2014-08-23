/* Generate garbage - storage still allocated, but no pointer to it */

#include <stdio.h>
int main()
{
    /* Allocate a double on the heap */
    double *data = (double *)malloc(sizeof(double));
    *data = 35.5;
    printf("data is %f\n", *data);
    data = NULL;
    printf("data is %f\n", *data);

    return 0;
}