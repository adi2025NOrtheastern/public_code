//HelloWorld.java
 
public class HelloWorld 
{
  native void cfunction();//Declaring the native function
                             
  static
  {
	  System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary("forhelloworld");//Linking the native library
  }                                         //which we will be creating.
 
  public static void main(String args[]) 
  {
        HelloWorld obj = new HelloWorld();
        obj.cfunction();//Calling the native function
   }
}
