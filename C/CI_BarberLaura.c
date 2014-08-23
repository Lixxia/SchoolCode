/*
Laura Barber
C Program Assignment 1
CSCI 320 McCauley
10/3/2013
*/
#include <stdio.h>
char *find_char(char const * source, char const * chars);

int main()
{
	//Initializing array and pointer
	char *source = (char *) malloc(5*sizeof(char));
	char *chars = (char *) malloc(3*sizeof(char));
	char *point = malloc(sizeof *point);
	
	//TEST 1
	
	source = "ABCDE";
	printf("%s", "Source Array: ");
	printf("%s", source);
	
	chars = "XRE";
	printf("\n%s", "Chars Array: ");
	printf("%s", chars);
	/*
	//TEST 2
	
	source = "ABCDE";
	printf("%s", "Source Array: ");
	printf("%s", source);
	
	chars = "XYF";
	printf("\n%s", "Chars Array: ");
	printf("%s", chars);
	
	//TEST 3
	
	source = "ABCDE";
	printf("%s", "Source Array: ");
	printf("%s", source);
	
	chars = "GBA";
	printf("\n%s", "Chars Array: ");
	printf("%s", chars);
	*/
	
	//Call to find_char method &assigned a pointer for ease of use
	point = find_char(source, chars);
	//If char found, print success, otherwise print fail
	if(point !=0)
	{
		printf("\n%s", "Character found: ");
		printf("%c", *point);
	}
	else
	{
		printf("\n%s", "Character not found.");
	}

	return 0;	
}

//find_char method, accepts source and chars.
char *find_char(char const * source, char const * chars) 
{
	//initialize counters and pointer
	int i;
	int j;
	int found=0;
	char *point = malloc(sizeof *point);

	/*Loop that will run through comparing the first part of the source array to each 
	element of the chars array. When it finds the appropriate char it returns a pointer.*/
	for(j=0; j < 5; j++)
	{
		for(i=0; i < 3; i++)
		{
			/*Tests to see how the loop is working
			
			printf("\n%s", "Source: ");
			printf("%c", *source);
			printf("\n%s", "Chars: ");
			printf("%c", *chars);*/
			if (*source == *chars)
			{
				//More tests 
				//printf("\n%s", "Final Output: ");
				//If found, sets to 1 and returns pointer to that location
				found = 1;
				*point = *source;
				return point;
				
			}
			*chars++;
		}
		*source++;
		for(i=0; i < 3; i++)
		{
			*chars--;
		}	
	}
	//If no appropriate character exists, returns 0
	if(found == 0)
		return 0; //null 
}