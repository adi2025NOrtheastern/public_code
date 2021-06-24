//#include <iostream>
//#include <map>
//#include <set>
//#include <string>
//#include <thread>         // std::thread
//#include <mutex> 
//#include <stdio.h>
//#include <stdlib.h>
//#include <pthread.h>
//#include <unistd.h>
//#include <semaphore.h>
//#include <windows.h>
//
//#include <string>     // std::string, std::stoi
//#include <fstream>
//#include <iostream>
//#include <vector>
//using namespace std;
////
////void* threadfunc1(void*);
////void* threadfunc2(void*);
//
//
//void callmeSleep();
//
//void graderSleep();
//
//void readFromFile();
//int lower = 31;//70;
//int upper = 70;//100;
//static int nextId = 1;
//class MyStudent
//{
//public:
//    int id = nextId++;
//    string name;
//    int homework = 0;
//    int quiz = 0;
//    int midterm = 0;
//    int project = 0;
//    int finaL = 0;
//    double total = 0.0;
//    string grade = "F";
//    // string calculateGrade();
//    MyStudent() {
//        name = "Student" + std::to_string(id);
//        //strcat(name, (string)id);
//        cout << "name: " << name <<endl;
//
//        homework = 70 + (rand() % 30);//rand() % lower + upper;//(Math.random() * (upper - lower)) + lower;
//        cout << "student.homework" << homework << endl;
//
//        callmeSleep();
//        project = 70 + (rand() % 30);//rand() % lower + upper;//(int)(Math.random() * (upper - lower)) + lower;
//        callmeSleep();//(500);
//        quiz = 70 + (rand() % 30);//rand() % lower + upper;//(int)(Math.random() * (upper - lower)) + lower;
//        callmeSleep();
//        finaL = 70 + (rand() % 30);//rand() % lower + upper;//(int)(Math.random() * (upper - lower)) + lower;
//        callmeSleep();
//        midterm = 70 + (rand() % 30);//rand() % lower + upper;//(int)(Math.random() * (upper - lower)) + lower;
//        callmeSleep();
//
//
//    }
//
//};
//
//int m = 100;//100;  ----change
//const int n = 101;  //101 -- chnage
////MyStudent s[n];
//static int counter = 1;
////void* studentRun(MyStudent s);
////void* graderRun(MyStudent s);
//void* studentRun(void*);
//void* graderRun(void*);
//void generateGrades(MyStudent);
//void writeInFileFinal(MyStudent student);
//void writeInFile(MyStudent);
//
//void getGrade(MyStudent);
//string calculateGrade(int homework, int quiz, int midterm, int project, int finaL);
//
//    map<string, string> map1;
//    //std::mutex mtxlock;// = new ReentrantLock();
//    pthread_mutex_t mutex11 = PTHREAD_MUTEX_INITIALIZER;
//    pthread_mutex_t mutex12 = PTHREAD_MUTEX_INITIALIZER;
//
//
//    std::mutex lock2;
//    set<string> set1;
//    
//    //MyStudent student[101];
//
//
//    /*********************int main()********************************/
//int main()
//{
//    //map<string, string> map;
//    //std::mutex lock;// = new ReentrantLock();
//    //std::mutex lock2;// = new ReentrantLock();
//    //11;  //101   --change
//    //struct shared1 *share;
//    
//    pthread_t myStudentthread[n];
//    pthread_t graderThread;// = NULL;
//    for (int i = 1;i < n;i++) {
//
//
//        pthread_create(&myStudentthread[i], NULL, studentRun, NULL);
//       // pthread_join(*mythread, NULL);
//    }
//
//    //GraderThread gt = new GraderThread(lock, map);
//    pthread_create(&graderThread, NULL, graderRun, NULL);
//
//    for (int i = 1;i < n;i++) {
//                
//        pthread_join(myStudentthread[i], NULL);
//    }
//    pthread_join(graderThread, NULL);
//
//
//    cout << "Main over"<<endl;
//    return 0;
//}
//
////void* threadfunc1() {
////    StudentThread::run();
////}
////
////void* threadfunc2() {
////    GraderThread::run();
////}
//
///**********************************************Grader starts**********/
//
//void* graderRun(void *)
//{
//    while (set1.size() < m) //chnage 5 to 50  ----change
//    {
//        // System.out.println("set size is: " + set.size());
//        cout<< "Set size: "<< set1.size()<<endl;
//        cout << "Grader Sleeping..*********************" << endl;
//        graderSleep();
//        cout << "Grader Awake..***************************************" << endl;
//        readFromFile();
//        
//    }
//    cout << "Grader done!" << endl;
//    return NULL;
//}
//
//void graderSleep() {
//    long n = 0;
//    while (n != 500000000)  //10000000000
//        n++;
//}
//
//void readFromFile() {
//    pthread_mutex_lock(&mutex11);
//    string line;
//    fstream infile;
//
//    infile.open("C:\\aditi\\GradesCpp.txt", std::fstream::in | std::fstream::out | std::fstream::app);
//
//    //Reading
//    while (infile >> line) {
//
//        cout << "Grader thread processing -> " << line << endl;
//        vector<std::string> tokens;
//
//
//        //char* token = strtok(line, ",");
//
//        std::string delimiter = ",";
//
//        size_t pos = 0;
//        std::string token;
//        pos = line.find(delimiter);
//        string name = line.substr(0, pos);//tokens[0];
//        line.erase(0, pos + delimiter.length());
//
//
//        //if already processed
//        if (set1.find(name) != set1.end())
//        {
//            continue;
//        }
//
//
//        while ((pos = line.find(delimiter)) != std::string::npos) {
//            token = line.substr(0, pos);
//            //std::cout << token << std::endl;
//
//            tokens.push_back(token);
//            line.erase(0, pos + delimiter.length());
//        }
//
//        
//
//       
//        int nextId = stoi(tokens[0]);
//        string thread = (tokens[1]);
//        int homework = stoi(tokens[2]);
//        int quiz = stoi(tokens[3]);
//        int midterm = stoi(tokens[4]);
//        int project = stoi(tokens[5]);
//        int finaL = stoi(tokens[6]);
//
//        //process it and calculateGrade
//        string grade = calculateGrade(homework, quiz, midterm, project, finaL);
//        cout << "Grade calculated-> name +" << name <<
//            " Thread " << thread << " Grade: " << grade << endl;
//        set1.insert(name);
//
//
//        map1[name] = grade;//map.put(name, grade);
//
//    }//while outer
//    infile.close();
//    pthread_mutex_unlock(&mutex11);
//}
//
//
//string calculateGrade(int homework, int quiz, int midterm, int project, int finaL) {
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
//
///***************Grader ends**********************************************/
//
//
//
///****************Student Thr4ead starts***********************************/
//
//
//void generateGrades(MyStudent student)
//{
//
//    student.homework = rand() % lower + upper;//(Math.random() * (upper - lower)) + lower;
//    cout << "student.homework" << student.homework << endl;
//    
//    callmeSleep();
//    student.project = rand() % lower + upper;//(int)(Math.random() * (upper - lower)) + lower;
//    callmeSleep();//(500);
//    student.quiz = rand() % lower + upper;//(int)(Math.random() * (upper - lower)) + lower;
//    callmeSleep();
//    student.finaL = rand() % lower + upper;//(int)(Math.random() * (upper - lower)) + lower;
//    callmeSleep();
//    student.midterm = rand() % lower + upper;//(int)(Math.random() * (upper - lower)) + lower;
//    callmeSleep();
//    //student.grade = student.calculateGrade();
//
//
//}
//
//
//
//void writeInFile(MyStudent student)
//{
//
//    fstream myWriter;
//
//    pthread_mutex_lock(&mutex11);
//
//    cout << "Thread-" << student.id << " locked file to write." << endl;
//    myWriter.open("C:\\aditi\\GradesCpp.txt", std::fstream::in | std::fstream::out | std::fstream::app);
//    //string data = student.name + ", " + student.id + ", " +
//    //    name + ", " + student.homework
//    //    + ", " + student.quiz
//    //    + ", " + student.midterm
//    //    + ", " + student.project
//    //    + ", " + student.finaL;// +"\n";
//
//    myWriter << student.name << "," << student.id << "," <<
//        "Thread-"<<student.id << "," << student.homework
//        << "," << student.quiz
//        << "," << student.midterm
//        << "," << student.project
//        << "," << student.finaL <<","<< endl;
//
//
//    //name, nextId, ThreadId, homework, quiz, midterm, project and final
//    myWriter.close();
//    cout << "Thread-" << student.id << " unlocked file to write." << endl;
//    pthread_mutex_unlock(&mutex11);
//
//
//
//}
//
//
//void* studentRun(void* ) {
//    MyStudent s;
//
//    pthread_mutex_lock(&mutex11);
//    //int i = counter;
//    //counter++;
//    cout << "Thread- started" <<s.id << endl;
//
//    pthread_mutex_unlock(&mutex11);
//
//    //generateGrades(s[i]);
//
//    writeInFile(s);
//
//    getGrade(s);
//
//    return NULL;
//
//}
//
//
//
//void getGrade(MyStudent student) {
//    //it = map1.find('b');
//    while (map1.find(student.name) == map1.end())//student.grade == null)
//    {
//        callmeSleep();
//
//        continue;
//
//    }// while
//
//    if (map1.find(student.name) != map1.end())
//    {
//        student.grade = map1.find(student.name)->second;//map.get(student.name);
//        //            System.out.println(Thread.currentThread().getName()+ " found data, "+ student+ " no wait");
//    }
//
//    pthread_mutex_lock(&mutex11);
//    cout << "Thread-"<<student.id << " Grade is " << student.grade << endl;
//    pthread_mutex_unlock(&mutex11);
//
//
//    writeInFileFinal(student);
//}
//
//
//
//
//void writeInFileFinal(MyStudent student)
//{
//
//    fstream myWriter;
//
//    pthread_mutex_lock(&mutex12);
//
//    cout << "Thread-" << student.id << " locked final file to write." << endl;
//    myWriter.open("C:\\aditi\\GradesCppFinal.txt", std::fstream::in | std::fstream::out | std::fstream::app);
//    //string data = student.name + ", " + student.id + ", " +
//    //    name + ", " + student.homework
//    //    + ", " + student.quiz
//    //    + ", " + student.midterm
//    //    + ", " + student.project
//    //    + ", " + student.finaL;// +"\n";
//
//    myWriter << student.name << "," << student.id << "," <<
//        "Thread-" << student.id << "," << student.homework
//        << "," << student.quiz
//        << "," << student.midterm
//        << "," << student.project
//        << "," << student.finaL << "," <<student.grade << endl;
//
//
//    //name, nextId, ThreadId, homework, quiz, midterm, project and final
//    myWriter.close();
//    cout << "Thread-" << student.id << " unlocked final file to write." << endl;
//    pthread_mutex_unlock(&mutex12);
//
//
//
//}
//
//
//
//
//
//void callmeSleep()
//{
//    long n = 0;
//    while (n != 500000000)
//        n++;
//}
//
//
//
///****************Student thtread ends**********************************************/