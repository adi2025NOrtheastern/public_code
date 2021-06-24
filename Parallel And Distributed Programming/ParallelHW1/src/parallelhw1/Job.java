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
class Job implements Runnable {
	private static Thread [] jobs = new Thread[4];
	private int threadID;
	public Job(int ID) {
	        threadID = ID;
	}
	public void run() { 
            //do something 
            System.out.println("abc");
                    }
	public static void main(String [] args) {
		for(int i=0; i<jobs.length; i++) {
		    jobs[i] = new Thread(new Job(i));
		    jobs[i].start();
		}
		try {
		    for(int i=0; i<jobs.length; i++) {
		        jobs[i].join();
		    }
		} catch(InterruptedException e) { System.out.println(e); }
	}
}

