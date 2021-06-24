//#include <stdio.h>
//#include <stdlib.h>
//#include <pthread.h>
//
//void *functionC();
//void *sum();
//void* sum1();
//pthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER;
//pthread_mutex_t mutex2 = PTHREAD_MUTEX_INITIALIZER;
//pthread_mutex_t mutex3 = PTHREAD_MUTEX_INITIALIZER;
//int  counter = 0;
//int n = 10;
//static volatile int i = 0;
//static volatile int total =0;
//int j = 0;
//static   int total1 = 0;
//
//int main()
//{
//   int rc1, rc2, rc3, rc4;
//   pthread_t thread1, thread2, thread3, thread4, thread5, thread6;
//
//   /* Create independent threads each of which will execute functionC */
//
//   if( (rc1=pthread_create( &thread1, NULL, &functionC, NULL)) )
//   {
//      printf("Thread creation failed: %d\n", rc1);
//   }
//
//   if( (rc2=pthread_create( &thread2, NULL, &functionC, NULL)) )
//   {
//      printf("Thread creation failed: %d\n", rc2);
//   }
//
//   if( (rc3=pthread_create( &thread3, NULL, &sum, NULL)) )
//   {
//      printf("Thread creation failed: %d\n", rc3);
//   }
//   
//   if( (rc4=pthread_create( &thread4, NULL, &sum, NULL)) )
//   {
//      printf("Thread creation failed: %d\n", rc4);
//   }
//
//   
//
//   /* Wait till threads are complete before main continues. Unless we  */
//   /* wait we run the risk of executing an exit which will terminate   */
//   /* the process and all threads before the threads have completed.   */
//
//   pthread_join( thread1, NULL);
//   pthread_join( thread2, NULL); 
//   pthread_join( thread3, NULL);
//   pthread_join( thread4, NULL); 
//  
//   if ((rc3 = pthread_create(&thread5, NULL, &sum1, NULL)))
//   {
//	   printf("Thread creation failed: %d\n", rc3);
//   }
//
//   if ((rc4 = pthread_create(&thread6, NULL, &sum1, NULL)))
//   {
//	   printf("Thread creation failed: %d\n", rc4);
//   }
//   pthread_join(thread5, NULL);
//   pthread_join(thread6, NULL);
//
//
//
//   exit(EXIT_SUCCESS);
//}
//
//void *functionC()
//{
//   pthread_mutex_lock( &mutex1 );
//   counter++;
//   printf("Counter value: %d\n",counter);
//   pthread_mutex_unlock( &mutex1 );
//}
//
//
//void *sum(){
//	//pthread_mutex_lock( &mutex2 );
//	//total = 0;
//	printf("Both thread sum \n");
//	for(i=1;i<n;)
//	{
//		pthread_mutex_lock(&mutex2);
//		//if (i <= 10) {
//			total += i;
//			printf("Total value: %d and i: %d \n", total, i);
//			i++;
//		//}
//		pthread_mutex_unlock(&mutex2);
//	}
//	//pthread_mutex_unlock( &mutex2 );
//	
//}
//
////each thread gives counter 1 to 10 sum
//void* sum1() {
//	pthread_mutex_lock(&mutex3);
//	total1 = 0;
//	printf("Each thread sum \n");
//	for (j = 1;j <= n;j++)
//	{
//		//pthread_mutex_lock(&mutex2);
//		total1 += j;
//		printf("Total value: %d and j: %d \n", total1, j);
//		//pthread_mutex_unlock(&mutex2);
//	}
//	pthread_mutex_unlock(&mutex3);
//
//}