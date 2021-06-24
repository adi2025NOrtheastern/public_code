#pragma once
#include <iostream>
#include <map>
#include "MyStudent.h"
#include <thread>         // std::thread
#include <mutex>  
#include <set>

class GraderThread
{
public:
    std::mutex lock1;
    //Lock lock;
    MyStudent student;
    set<string> set1;
    int waitTime = 20000;//100;//20000;
    map<string, string> map1;
    //static int count =0;


     GraderThread(mutex lock, map<string, string> map) {
        //lock1 = lock;
        //set = new HashSet();
        map1 = map;
    }

     void graderSleep();
     static void run(struct shared1 share);
     void readFromFile();
     string calculateGrade(int homework, int quiz, int midterm, int project, int finaL);
};

