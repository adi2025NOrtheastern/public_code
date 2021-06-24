#include <iostream>
#include <map>
#include <string>
#include "MyStudent.h"
#include <thread>         // std::thread
#include <mutex> 
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include <semaphore.h>
#include <windows.h>
#include "StudentThread.h"
#include "StudentThread.cpp"
#include "GraderThread.h"
using namespace std;

void* threadfunc1(void*);
void* threadfunc2(void*);

struct shared1 {
    map<string, string> map;
    std::mutex lock;// = new ReentrantLock();
    std::mutex lock2;
};

int main()
{
    //map<string, string> map;
    //std::mutex lock;// = new ReentrantLock();
    //std::mutex lock2;// = new ReentrantLock();
    int n = 101;
    struct shared1 *share;
    MyStudent student[101];
    pthread_t* myStudentthread[101];
    pthread_t* graderThread;
    for (int i = 1;i < n;i++) {


        pthread_create(myStudentthread[i], NULL, threadfunc1, share);
       // pthread_join(*mythread, NULL);
    }

    //GraderThread gt = new GraderThread(lock, map);
    pthread_create(graderThread, NULL, threadfunc2, share);

    for (int i = 1;i < n;i++) {
                
        pthread_join(*myStudentthread[i], NULL);
    }
    pthread_join(*graderThread, NULL);


    cout << "Main over"<<endl;
    return 0;
}

void* threadfunc1(struct shared1 share) {
    StudentThread::run(*share);
}

void* threadfunc2(struct shared1 share) {
    GraderThread::run(*share);
}