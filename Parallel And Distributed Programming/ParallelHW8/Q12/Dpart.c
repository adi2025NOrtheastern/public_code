#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *functionC();
void *sum();
pthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t mutex2 = PTHREAD_MUTEX_INITIALIZER;
int  counter = 0;
int n = 10;
int i = 0;
int total =-1;

int main()
{
   int rc1, rc2, rc3, rc4;
   pthread_t thread1, thread2, thread3, thread4;

   /* Create independent threads each of which will execute functionC */

   if( (rc1=pthread_create( &thread1, NULL, &functionC, NULL)) )
   {
      printf("Thread creation failed: %d\n", rc1);
   }

   if( (rc2=pthread_create( &thread2, NULL, &functionC, NULL)) )
   {
      printf("Thread creation failed: %d\n", rc2);
   }

   if( (rc3=pthread_create( &thread3, NULL, &sum, NULL)) )
   {
      printf("Thread creation failed: %d\n", rc3);
   }
   
   if( (rc4=pthread_create( &thread4, NULL, &sum, NULL)) )
   {
      printf("Thread creation failed: %d\n", rc4);
   }


   /* Wait till threads are complete before main continues. Unless we  */
   /* wait we run the risk of executing an exit which will terminate   */
   /* the process and all threads before the threads have completed.   */

   pthread_join( thread1, NULL);
   pthread_join( thread2, NULL); 
   pthread_join( thread3, NULL);
   pthread_join( thread4, NULL); 

   exit(EXIT_SUCCESS);
}

void *functionC()
{
   pthread_mutex_lock( &mutex1 );
   counter++;
   printf("Counter value: %d\n",counter);
   pthread_mutex_unlock( &mutex1 );
}


void *sum(){
	pthread_mutex_lock( &mutex2 );
	for(i=1;i<=n;i++)
	{
		total += i;
		printf("Total value: %d\n",total);
	}
	pthread_mutex_unlock( &mutex2 );
	
}