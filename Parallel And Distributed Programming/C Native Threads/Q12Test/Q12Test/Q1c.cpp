//// CPP program to demonstrate the given task
//#include <iostream>
//#include <pthread.h>
//#include <queue>
//#include <stdlib.h>
//
//#define MAX 20
//
//using namespace std;
//
//// Declaring global variables
//int sum_B = 0, sum_C = 0, sum_D = 0, sum_E = 0;
//int consumerCount1 = 0;
//int consumerCount2 = 0;
//int consumerCount3 = 0;
//int consumerCount4 = 0;
//// Shared queue
//queue<int> Q;
//
//// Function declaration of all required functions
//void* producerFun(void*);
//void* add_B(void*);
//void* add_C(void*);
//void* add_D(void*);
//void* add_E(void*);
//// Getting the mutex
//pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
//
//pthread_cond_t dataNotProduced =
//PTHREAD_COND_INITIALIZER;
//pthread_cond_t dataNotConsumed =
//PTHREAD_COND_INITIALIZER;
//
//// Function to generate random numbers and
//// push them into queue using thread A
//
//void* producerFun(void*)
//{
//	static int producerCount = 0;
//
//	// Initialising the seed
//	srand(time(NULL));
//
//	while (1) {
//		// Getting the lock on queue using mutex
//		pthread_mutex_lock(&mutex);
//
//		if (Q.size() < MAX && producerCount < MAX)
//		{
//
//			// Getting the random number
//			int num = rand() % 10 + 1;
//			cout << "Produced: " << num << endl;
//
//			// Pushing the number into queue
//			Q.push(num);
//
//			producerCount++;
//
//			pthread_cond_broadcast(&dataNotProduced);
//		}
//
//		// If queue is full, release the lock and return
//		else if (producerCount == MAX) {
//			pthread_mutex_unlock(&mutex);
//			return NULL;
//		}
//
//		// If some other thread is exectuing, wait
//		else {
//			cout << ">> Producer is in wait.." << endl;
//			pthread_cond_wait(&dataNotConsumed, &mutex);
//		}
//
//		// Get the mutex unlocked
//		pthread_mutex_unlock(&mutex);
//	}
//}
//
//// Function definition for consumer thread B
//void* add_B(void*)
//{
//
//	while (1) {
//
//		// Getting the lock on queue using mutex
//		pthread_mutex_lock(&mutex);
//
//		// Pop only when queue has at least 1 element
//		if (Q.size() > 0) {
//			// Get the data from the front of queue
//			int data = Q.front();
//
//			cout << "B thread consumed: " << data << endl;
//
//			// Add the data to the integer variable
//			// associated with thread B
//			sum_B += data;
//
//			// Pop the consumed data from queue
//			Q.pop();
//
//			consumerCount1++;
//
//			pthread_cond_signal(&dataNotConsumed);
//		}
//
//		// Check if consmed numbers from both threads
//		// has reached to MAX value
//		else if (consumerCount2 + consumerCount1 + consumerCount3 + consumerCount4 == MAX) {
//			pthread_mutex_unlock(&mutex);
//			return NULL;
//		}
//
//		// If some other thread is exectuing, wait
//		else {
//			cout << "B is in wait.." << endl;
//			pthread_cond_wait(&dataNotProduced, &mutex);
//		}
//
//		// Get the mutex unlocked
//		pthread_mutex_unlock(&mutex);
//	}
//}
//
//// Function definition for consumer thread C
//void* add_C(void*)
//{
//
//	while (1) {
//
//		// Getting the lock on queue using mutex
//		pthread_mutex_lock(&mutex);
//
//		// Pop only when queue has at least 1 element
//		if (Q.size() > 0) {
//
//			// Get the data from the front of queue
//			int data = Q.front();
//			cout << "C thread consumed: " << data << endl;
//
//			// Add the data to the integer variable
//			// associated with thread B
//			sum_C += data;
//
//			// Pop the consumed data from queue
//			Q.pop();
//			consumerCount2++;
//
//			pthread_cond_signal(&dataNotConsumed);
//		}
//
//		// Check if consmed numbers from both threads
//		// has reached to MAX value
//		else if (consumerCount2 + consumerCount1 + consumerCount3 + consumerCount4 == MAX)
//		{
//			pthread_mutex_unlock(&mutex);
//			return NULL;
//		}
//
//		// If some other thread is exectuing, wait
//		else {
//			cout << ">> C is in wait.." << endl;
//			// Wait on a condition
//			pthread_cond_wait(&dataNotProduced, &mutex);
//		}
//
//		// Get the mutex unlocked
//		pthread_mutex_unlock(&mutex);
//	}
//}
//
//
//// Function definition for consumer thread D
//void* add_D(void*)
//{
//
//	while (1) {
//
//		// Getting the lock on queue using mutex
//		pthread_mutex_lock(&mutex);
//
//		// Pop only when queue has at least 1 element
//		if (Q.size() > 0) {
//			// Get the data from the front of queue
//			int data = Q.front();
//
//			cout << "D thread consumed: " << data << endl;
//
//			// Add the data to the integer variable
//			// associated with thread B
//			sum_D += data;
//
//			// Pop the consumed data from queue
//			Q.pop();
//
//			consumerCount3++;
//
//			pthread_cond_signal(&dataNotConsumed);
//		}
//
//		// Check if consmed numbers from both threads
//		// has reached to MAX value
//		else if (consumerCount2 + consumerCount1 + consumerCount3 + consumerCount4 == MAX) {
//			pthread_mutex_unlock(&mutex);
//			return NULL;
//		}
//
//		// If some other thread is exectuing, wait
//		else {
//			cout << "D is in wait.." << endl;
//			pthread_cond_wait(&dataNotProduced, &mutex);
//		}
//
//		// Get the mutex unlocked
//		pthread_mutex_unlock(&mutex);
//	}
//}
//
//
//// Function definition for consumer thread E
//void* add_E(void*)
//{
//
//	while (1) {
//
//		// Getting the lock on queue using mutex
//		pthread_mutex_lock(&mutex);
//
//		// Pop only when queue has at least 1 element
//		if (Q.size() > 0) {
//			// Get the data from the front of queue
//			int data = Q.front();
//
//			cout << "E thread consumed: " << data << endl;
//
//			// Add the data to the integer variable
//			// associated with thread B
//			sum_E += data;
//
//			// Pop the consumed data from queue
//			Q.pop();
//
//			consumerCount4++;
//
//			pthread_cond_signal(&dataNotConsumed);
//		}
//
//		// Check if consmed numbers from both threads
//		// has reached to MAX value
//		else if (consumerCount2 + consumerCount1 + consumerCount3 + consumerCount4 == MAX) {
//			pthread_mutex_unlock(&mutex);
//			return NULL;
//		}
//
//		// If some other thread is exectuing, wait
//		else {
//			cout << "E is in wait.." << endl;
//			pthread_cond_wait(&dataNotProduced, &mutex);
//		}
//
//		// Get the mutex unlocked
//		pthread_mutex_unlock(&mutex);
//	}
//}
//
//
//// Driver code
//int main()
//{
//	// Declaring integers used to
//	// identify the thread in the system
//	pthread_t producerThread, consumerThread1, consumerThread2, consumerThread3, consumerThread4;
//
//	// Function to create a threads
//	// (pthread_create() takes 4 arguments)
//	int retProducer = pthread_create(&producerThread,
//		NULL, producerFun, NULL);
//	int retConsumer1 = pthread_create(&consumerThread1,
//		NULL, *add_B, NULL);
//	int retConsumer2 = pthread_create(&consumerThread2,
//		NULL, *add_C, NULL);
//	int retConsumer3 = pthread_create(&consumerThread3,
//		NULL, *add_D, NULL);
//	int retConsumer4 = pthread_create(&consumerThread4,
//		NULL, *add_E, NULL);
//
//	// pthread_join suspends execution of the calling
//	// thread until the target thread terminates
//	if (!retProducer)
//		pthread_join(producerThread, NULL);
//	if (!retConsumer1)
//		pthread_join(consumerThread1, NULL);
//	if (!retConsumer2)
//		pthread_join(consumerThread2, NULL);
//	if (!retConsumer3)
//		pthread_join(consumerThread3, NULL);
//	if (!retConsumer4)
//		pthread_join(consumerThread4, NULL);
//
//	// Checking for the final value of thread
//	if (sum_C > sum_B && sum_C> sum_D && sum_C > sum_E)
//		cout << "Winner is Thread C" << endl;
//	else if (sum_B > sum_C && sum_B > sum_D && sum_B > sum_E)
//		cout << "Winner is Thread B" << endl;
//	else if (sum_D > sum_C && sum_B < sum_D && sum_D > sum_E)
//		cout << "Winner is Thread D" << endl;
//	else if (sum_E > sum_C && sum_E > sum_D && sum_B < sum_E)
//		cout << "Winner is Thread E" << endl;
//	else
//		cout << "Both has same score" << endl;
//
//	return 0;
//}
