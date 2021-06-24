/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aditi
 */

#include <iostream>

using namespace std;

int main()
{
//clear the screen.
//clrscr();
//declare variable type int
int a[2][4],i,j, k=1;
int b[2][4];
//Input the numbers
int a1[2][4] = { {1,2,3,4} ,{5,6,7,8}
    
};
int rows =  sizeof a / sizeof a[0]; // 2 rows  
int cols = sizeof a[0] / sizeof(int); // 5 cols;
//reverse the matrix
for(i=rows -1 ;i>=0;i--)
{
for(j= cols - 1;j>=0;j--)
{
//cout<<a[i][j]<<"\t";
b[rows-1-i][cols-1-j] = a1[i][j];


}
//cout<<endl;
}
//display the matrix
for(i=0;i<2;i++)
{
for(j=0;j<4;j++)
{
cout<<b[i][j]<<"\t";
}
cout<<endl;
}

//for(i=0;i<2;i++)
//{
//for(j=0;j<4;j++)
//{
//cout<<a1[i][j]<<"\t";
//}
//cout<<endl;
//}

//get character
//getch();
return 1;
}
    
    
    
    
//    public static void main(String[] args) {
//        int[][] array = {
//            { 1, 2, 3, 4 },
//            { 5, 6, 7, 8 }
//        };
//        int rows = array.length;
//        int cols = array[0].length;
//        int[][] reverse = new int[rows][cols];
//        for(int i = rows-1; i >= 0; i--) {
//            for(int j = cols-1; j >= 0; j--) {
//                reverse[rows-1-i][cols-1-j] = array[i][j];
//            }
//        }
//        for(int i = 0; i < rows; i++) {
//            for(int j = 0; j < cols; j++) {
//                System.out.print(reverse[i][j]);
//                if(j < cols-1)
//                    System.out.print(", ");
//            }
//            System.out.println();
//        }
//    } 
//}

//}
