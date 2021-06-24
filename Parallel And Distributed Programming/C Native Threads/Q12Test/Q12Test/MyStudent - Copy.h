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
    int homework;
    int quiz;
    int midterm;
    int project;
    int finaL;
    double total;
    string grade;

    string calculateGrade();
};

