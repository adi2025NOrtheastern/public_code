#pragma once
#include <iostream>
#include <map>
#include "MyStudent.h"
#include <thread>         // std::thread
#include <mutex>          // std::mutex
class StudentThread
{
public:
	MyStudent student;
	string name;
	//std::mutex lock;  //Lock lock;
	//std::mutex lock2;  //Lock lock2;
	int lower = 70;
	int upper = 100;
	std::map<string, string> map1;
	std::map<string, string>::iterator it;



	StudentThread(std::mutex lock1, map<string, string> map1, std::mutex lock3);
	void generateGrades();

	void writeInFile();

	void getGrade();

	void callmeSleep();

	static void run(struct shared1 share);

};

