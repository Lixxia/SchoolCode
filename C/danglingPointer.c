/* Generate a dangling pointer  */

#include <stdio.h>
int main()
{
    /* Allocate a double on the heap */
    double *data = (double *)malloc(sizeof(double)); 
    *data = 35.5;
    printf("data is %f\n", *data);
    free(data);
    printf("data is %f\n", *data);
  
    return 0;
}