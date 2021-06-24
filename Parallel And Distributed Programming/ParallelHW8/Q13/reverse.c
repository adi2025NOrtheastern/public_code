//reverse.c
 
#include <jni.h>
#include <stdio.h>
#include <pthread.h>

void* threadfn(void *original);
const char *org;
JavaVM *vm;
JNIEnv *env;
int size;
char *rev;
//JNIEXPORT jstring JNICALL Java_reverse_reversefunc

JNIEXPORT jstring JNICALL Java_reverse_reversefunc
(JNIEnv *env,jobject jobj,jstring original)
{
  /*const char *org;
  char *rev;*/
  pthread_t t1;
  
  //return 0;
 
  //(*env)->GetJavaVM(vm);
 
 
  org = (*env)->GetStringUTFChars(env,original,NULL);
 
  int i;
  size = (*env)->GetStringUTFLength(env,original);
   
 /* for(i=0;i<size;i++)
        rev[i]=org[size-i-1];
 
  rev[size]='\0';
 */
 pthread_create(&t1,NULL,threadfn,(void*)org);
return (*env)->NewStringUTF(env,rev);  
}


void* threadfn(void *original)
{
  //const char *org;
  
   
  // JNIEnv *env;
  // int n=(*vm)->AttachCurrentThread(&env,NULL);

 
   //org = (*env)->GetStringUTFChars(env,original,NULL);
 
  int i;
  //int size = (*env)->GetStringUTFLength(env,original);
   
  for(i=0;i<size;i++)
        rev[i]=org[size-i-1];
 
  rev[size]='\0';
  
 
  

 // &vm->DetachCurrentThread();
//gl_arr = (char* )env->NewGlobalRef((char*) arr_);

        //return rev;//(*env)->NewStringUTF(env,rev);//(void*)res;
return 0;
}