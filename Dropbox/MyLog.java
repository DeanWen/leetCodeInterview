package logHit;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class LogNode {
	long time;
	long count;

	public LogNode(long time, long count) {
		this.time = time;
		this.count = count;
	}

	public void updateTime(long time) {
		if (time - this.time >= 10) {
			count = 1;
			this.time = time;
			System.out.println("more than 10 secs, update to 1");
		} else {
			count++;
		}
	}

}

class myThread extends Thread {
		
	LogNode[] last;
	
	public myThread(MyLog mylog) {
		last = new LogNode[10];
	}
	
	@Override
	public void run() {
		int count = 0;
		while (count < 110) {
			
			hit();
			count++;
			System.out.println("Hitting the log with count " + count);

			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	public void hit () {
		Date date = new Date();
		long time = date.getTime() / 1000 ;
		//System.out.println("Time diff is: " + time);
		if (last[(int) (time % 10)] == null) {
			System.out.println("Creating new node for slot: " + time);
			last[(int) (time % 10)] = new LogNode(time, 1);
		} else {
			last[(int) (time % 10)].updateTime(time);
			System.out.println("Updating the slot: " + time +"and the count is: " + last[(int) (time % 10)].count );

		}

	}
	
	public int gethit() {
		Date date = new Date();
		long time = date.getTime() / 1000;

		int count = 0;
		for (int i = 0; i < last.length; i++) {
			if (last[i] != null && time - last[i].time < 10) {
				count += last[i].count;
			}
		}
		return count;
	}
}

public class MyLog {

	LogNode[] last = new LogNode[10];
	
	long lastTime;
	
	ReadWriteLock lock;
	
	public MyLog(ReadWriteLock lock) {
		this.lock = lock;
	}

	public void hit() {

		Date date = new Date();
		long time = date.getTime() / 1000 ;
		//System.out.println("Time diff is: " + time);
		lock.writeLock().lock();
		if (last[(int) (time % 10)] == null) {
			System.out.println("Creating new node for slot: " + time);
			last[(int) (time % 10)] = new LogNode(time, 1);
		} else {
			last[(int) (time % 10)].updateTime(time);
			System.out.println("Updating the slot: " + time +"and the count is: " + last[(int) (time % 10)].count + "last time" + lastTime);

		}
		lastTime = time;
		lock.writeLock().unlock();

	}

	public int getlog() {

		Date date = new Date();
		long time = date.getTime() / 1000;

		int count = 0;
		lock.readLock().lock();
		for (int i = 0; i < last.length; i++) {
			if (last[i] != null && time - last[i].time < 10) {
				count += last[i].count;
			}
		}
		lock.readLock().unlock();
		return count;
	}



	public static void main(String[] args) throws InterruptedException {
		ReadWriteLock lock = new ReentrantReadWriteLock(false);
		MyLog myLog = new MyLog(lock);
		

		myThread thread1 = new myThread(myLog);
		myThread thread2 = new myThread(myLog);
		myThread thread3 = new myThread(myLog);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		executor.execute(thread1);
		executor.execute(thread2);
		executor.execute(thread3);
		
		executor.shutdown();
		
		while (!executor.isTerminated()) {
			
		}
		
		System.out.println("####Log count " + thread1.gethit() + thread2.gethit() + thread3.gethit());
		Date date = new Date();
		long time = date.getTime() / 1000;
		System.out.println("Current time is: " + time);

		System.out.println();
	}
}