#pragma once
#include <iostream>
#include <string>
using namespace std;
static int nextId = 1;
class MyStudent
{
public:
    int id = nextId++;
    string name = "Student" + id;
    int homework=0;
    int quiz = 0;
    int midterm = 0;
    int project = 0;
    int finaL = 0;
    double total = 0.0;
    string grade="F";

    //string calculateGrade();
};

