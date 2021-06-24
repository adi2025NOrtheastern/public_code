#include "StudentThread.h"
#include <map>
#include "MyStudent.h"
#include <thread>         // std::thread
#include <mutex> 
#include <cstdlib>
#include <fstream>
#include <iostream>
//using namespace ;
using namespace std;

StudentThread::StudentThread(std::mutex lock1, map<string, string> map2, std::mutex lock3)
	{
		
		//student = new MyStudent();
		name = ("Thread-" + student.id);
		//lock = lock1;
		map1 = map1;
		//lock2 = lock3;
	}


void StudentThread::generateGrades()
{
   
        student.homework = rand() % lower + upper;//(Math.random() * (upper - lower)) + lower;
        callmeSleep();
        student.project = rand() % lower + upper;//(int)(Math.random() * (upper - lower)) + lower;
        callmeSleep();//(500);
        student.quiz = rand() % lower + upper;//(int)(Math.random() * (upper - lower)) + lower;
        callmeSleep();
        student.finaL = rand() % lower + upper;//(int)(Math.random() * (upper - lower)) + lower;
        callmeSleep();
        student.midterm = rand() % lower + upper;//(int)(Math.random() * (upper - lower)) + lower;
        callmeSleep();
        //student.grade = student.calculateGrade();
 
        
}



void StudentThread::writeInFile()
{
    
    ofstream myWriter;

    lock.lock();
    myWriter.open("C:\\aditi\\GradesCpp.dat");
    //string data = student.name + ", " + student.id + ", " +
    //    name + ", " + student.homework
    //    + ", " + student.quiz
    //    + ", " + student.midterm
    //    + ", " + student.project
    //    + ", " + student.finaL;// +"\n";
  
    myWriter << student.name << "," << student.id << ","  <<
        name << ","  << student.homework
        << ","  << student.quiz
        << ","  << student.midterm
        << ","  << student.project
        << "," << student.finaL << endl;
       
        
        //name, nextId, ThreadId, homework, quiz, midterm, project and final
      myWriter.close();
       
        lock.unlock();

            

}


void StudentThread::run(struct shared1 share) {
    generateGrades();

    writeInFile();

    getGrade();
}



void StudentThread::getGrade() {
    //it = map1.find('b');
    while (map1.find(student.name) == map1.end())//student.grade == null)
    {
        callmeSleep();
       
        continue;
        
    }// while

    if (map1.find(student.name) != map1.end())
    {
        student.grade = map1.find(student.name)->second;//map.get(student.name);
        //            System.out.println(Thread.currentThread().getName()+ " found data, "+ student+ " no wait");
    }

    cout<< name << " Grade is " << student.grade;

    

    //writeInFileFinal();
}



void StudentThread::callmeSleep()
{
    long n = 0;
    while (n != 500000000)
        n++;
}