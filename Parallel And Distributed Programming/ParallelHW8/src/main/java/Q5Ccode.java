/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aditi
 */
public class Q5Ccode {
    
}
// Online C++ compiler to run C++ program online
#include <iostream>

/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <stdio.h>

int main ()
{
  // printf("Hello World");

  int j = 0;
  int x = 5;
  int *ptr1;
  ptr1 = &x;
  std::cout << "x: " << x;
  std::cout << " &x :" << &x;
  std::cout << " ptr1: " << ptr1;
  std::cout << " *ptr1: " << *ptr1;
  std::cout << std::endl;
  int *ptr2;
  ptr2 = ptr1;
//f
  std::cout << "f";
//printf("x %d, &x %s, ptr1 %d, *ptr1%d, ptr2 %d, *ptr2%d", x,&x,ptr1, * ptr1, ptr2, * ptr2);
  std::cout << "x: " << x;
  std::cout << " &x :" << &x;
  std::cout << " ptr1: " << ptr1;
  std::cout << " *ptr1: " << *ptr1;
  std::cout << " ptr2: " << ptr2;
  std::cout << " *ptr2: " << *ptr2;
  std::cout << std::endl;
  *ptr1 = 8;
//h
  std::cout << "h";
//printf("x %d, &x %s, ptr1 %d, *ptr1%d, ptr2 %d, *ptr2%d", x,&x,ptr1, * ptr1, ptr2, * ptr2);
  std::cout << "x: " << x;
  std::cout << " &x :" << &x;
  std::cout << " ptr1: " << ptr1;
  std::cout << " *ptr1: " << *ptr1;
  std::cout << " ptr2: " << ptr2;
  std::cout << " *ptr2: " << *ptr2;
  std::cout << std::endl;
  *ptr2 = 14;
  std::cout << "k";
  std::cout << "x: " << x;
  std::cout << " &x :" << &x;
  std::cout << " ptr1: " << ptr1;
  std::cout << " *ptr1: " << *ptr1;
  std::cout << " ptr2: " << ptr2;
  std::cout << " *ptr2: " << *ptr2;
  std::cout << std::endl;
//printf("x %d, &x %s, ptr1 %d, *ptr1%d, ptr2 %d, *ptr2%d", x,&x,ptr1, * ptr1, ptr2, * ptr2);

  int arr[4] = { 4, 12, 8, 6 };
 // *ptr1 = arr[0];
   ptr1 = arr;


//increment pointer 4 times
  std::cout << "increment pointer 4 times" << std::endl;
  for (j = 0; j < 4; j++)
    {


      std::cout << " ptr1: " << ptr1;
      std::cout << " *ptr1: " << *ptr1;
      std::cout << " &arr: " << &arr;
      std::cout << " arr[j]: " << arr[j];

      std::cout << " ptr2: " << ptr2;
      std::cout << " *ptr2: " << *ptr2;
      std::cout << std::endl;
//printf("ptr1 %d, *ptr %d, &arr %d, arr[i] %d, ptr2 %d, *ptr2 %d", ptr1, *ptr, &arr, arr[j], ptr2, *ptr2);

      ptr1++;

    }

  return 0;



}
