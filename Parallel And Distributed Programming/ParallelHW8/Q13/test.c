//reverse.c
#include <windows.h>
#include <jni.h>
#include <stdio.h>
#include <pthread.h>

int size;
char *rev ;
static void* threadfn( void *rev);
 
 

int main()
{
   char *org="hello";
 printf("line 17\n");
 //HINSTANCE hGetProcIDDLL = LoadLibrary("C:\\Users\\aditi\\OneDrive\\Documents\\NetBeansProjects\\ParallelHW8\\Q13test\\pthreadVC2.dll");
  //org = (*env)->GetStringUTFChars(env,original,NULL);
 /*if (!hGetProcIDDLL) {
    printf("could not load the dynamic library");
    //return EXIT_FAILURE;
	return "error in dll load pthread";
  }*/
    
   pthread_t t1;
   pthread_create(&t1,NULL,threadfn,(void*)org);
   //pthread_join(t1,NULL);
  //rev[size]='\0';
   threadfn((void*) org);
   
 printf("%s",rev);
// getc();
return 0;//(*env)->NewStringUTF(env,rev);
}
static void* threadfn( void *org)
{
	int i;
	//int size;
  size=5;
  char temp;
  rev = (char *)org;
   char * org2 = (char *)org;
    printf("line 28\n");
	printf("%s\n",org);
	printf("%d\n",size);
  for(i=0;i<size/2;i++){
	  printf("line 33 %d %c\n",i, org2[size-i-1]);
	    temp = org2[i];
        rev[i]=org2[size-i-1];
		rev[size-i-1]=temp;
		printf("line 34\n");
  }
  rev[size]='\0';
 
   //return rev;

}