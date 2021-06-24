//#include <stdio.h>
//
//#include <string.h>
//
//#include <stdlib.h>
//
//#include <pthread.h>
//
//#include <unistd.h>
//
//#include <semaphore.h>
//
//#include <windows.h>
//
//sem_t semaphore;
//void callmeSleep();
//void threadfunc() {
//    int n = 0;
//    while (1) { //while (n!=5)
//        sem_wait(&semaphore);
//        printf("Hello from da thread!\n");
//        sem_post(&semaphore);
//        //sleep(1);
//        callmeSleep();
//        n++;
//    }
//
//}
//
//void callmeSleep()
//{
//    long n = 0;
//    while (n != 500000000)
//        n++;
//}
//
//
//int main(void) {
//
//    // initialize semaphore, only to be used with threads in this process, set value to 1
//
//    sem_init(&semaphore, 0, 1);
//    pthread_t* mythread;
//    mythread = (pthread_t*)malloc(sizeof(*mythread));
//    // start the thread
//    printf("Starting thread, semaphore is unlocked.\n");
//    pthread_create(mythread, NULL, (void*)threadfunc, NULL);
//    //pthread_join(*mythread, NULL);
//    getchar();
//    sem_wait(&semaphore);
//    printf("Semaphore locked.\n");
//    // do stuff with whatever is shared between threads
//    getchar();
//    printf("Semaphore unlocked.\n");
//    sem_post(&semaphore);
//    getchar();
//    //sem_destroy(&mutex);
//    return 0;
//
//}
