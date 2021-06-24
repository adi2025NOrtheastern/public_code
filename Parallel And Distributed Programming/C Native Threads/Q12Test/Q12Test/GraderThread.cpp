//#include "GraderThread.h"
//#include <string>     // std::string, std::stoi
//#include <fstream>
//#include <iostream>
//#include <vector>
////#include <bits/stdc++.h>
//void GraderThread::run(struct shared1 share)
//{
//    while (set1.size() < 100) //chnage 5 to 50
//    {
//        // System.out.println("set size is: " + set.size());
//        graderSleep();
//        readFromFile();
//        cout << "Grader done!";
//    }
//}
//
//void GraderThread::graderSleep(){
//        long n = 0;
//        while (n != 10000000000)
//            n++;
//    }
//
//void GraderThread::readFromFile() {
//    lock.lock();
//    string line;
//    ifstream infile; 
//
//    infile.open("C:\\aditi\\GradesCpp.dat");
//   
//        //Reading
//        while (infile >> line) {
//            
//            cout<<"Grader thread processing -> " << line;
//            vector <string> tokens;
//
//            
//            char* token = strtok(line, ",");
//            string intermediate;
//
//            // Tokenizing w.r.t. space ' '
//            while (getline(check1, intermediate, ','))
//            {
//                tokens.push_back(intermediate);
//            }
//
//            string name = tokens[0];
//
//            //if already processed
//            if (set.find(name) == set.end())
//            {
//                continue;
//            }
//            int nextId = stoi(tokens[1]);
//            string thread = (tokens[2]);
//            int homework = stoi(tokens[3]);
//            int quiz = stoi(tokens[4]);
//            int midterm = stoi(tokens[5]);
//            int project = stoi(tokens[6]);
//            int finaL = stoi(tokens[7]);
//
//            //process it and calculateGrade
//            string grade = calculateGrade(homework, quiz, midterm, project, finaL);
//            cout<<"Grade calculated-> name +" << name <<
//                " Thread " << thread << " Grade: " << grade;
//            set.insert(name);
//
//           
//            map1[name] = grade;//map.put(name, grade);
//            
//        }//while outer
//        infile.close();
//        lock.unlock();
//}
//
//
//string GraderThread::calculateGrade(int homework, int quiz, int midterm, int project, int finaL) {
//    string grade = "";
//    double total = (0.25 * homework + 0.25 * quiz + 0.15 * midterm + 0.15 * project + 0.2 * finaL);
//    if (total >= 90) grade = "A";
//    else if (total >= 80 && total < 90) grade = "B";
//    else if (total >= 70 && total < 80) grade = "C";
//    else if (total >= 60 && total < 70) grade = "D";
//    // else if (total>= 60 && total < 70) grade ="E";
//    else if (total < 60) grade = "F";
//
//    return grade;
//}