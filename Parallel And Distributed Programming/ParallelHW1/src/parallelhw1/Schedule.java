/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallelhw1;

/**
 *
 * @author aditi
 */
class Schedule implements Runnable {
	private static Thread [] jobs = new Thread[4];
	private int threadID;
	public Schedule(int ID) {
		threadID = ID;
	}
	public void run() {
          //  do something
            System.out.println("abc");
                    }
	public static void  main(String [] args) {
		int nextThread = 0;
                
                Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		for(int i=0; i<jobs.length; i++) {
		    jobs[i] = new Thread(new Job(i));
		    jobs[i].setPriority(Thread.MIN_PRIORITY);
		    jobs[i].start();
		}
		try {
		    for(;;) {
		        jobs[nextThread].setPriority(Thread.NORM_PRIORITY);
		        Thread.sleep(1000);
		        jobs[nextThread].setPriority(Thread.MIN_PRIORITY);
		        nextThread = (nextThread + 1) % jobs.length;
		    }
		} catch(InterruptedException e) { System.out.println(e); }
	}
}

