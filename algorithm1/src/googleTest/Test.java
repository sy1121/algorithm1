package googleTest;

public class Test {
/*	public static void main(String[] args) {
		Runner1 runner1 = new Runner1();
		Runner2 runner2 = new Runner2();
//		Thread(Runnable target) 分配新的 Thread 对象。
		Thread thread1 = new Thread(runner1);
		Thread thread2 = new Thread(runner2);
		thread1.start();
		thread2.start();
//		thread1.run();
//		thread2.run();
	}
	*/
	public static void main(String[] args) {  
		/*MyThread mt=new MyThread();  
		new Thread(mt).start();//同一个mt，但是在Thread中就不可以，如果用同一  
		new Thread(mt).start();//个实例化对象mt，就会出现异常  
		new Thread(mt).start();  */
		MyThread mt1=new MyThread();  
		MyThread mt2=new MyThread();  
		MyThread mt3=new MyThread();  
		mt1.start();//每个线程都各卖了10张，共卖了30张票  
		mt2.start();//但实际只有10张票，每个线程都卖自己的票  
		mt3.start();//没有达到资源共享  
		}
		 
}

class MyThread extends Thread{  
private int ticket=10;  
public void run(){  
for(int i=0;i<20;i++){  
if(this.ticket>0){  
System.out.println(Thread.currentThread().getName()+"卖票：ticket"+this.ticket--);  
}  
}  
}
}
/*class MyThread implements Runnable{  
private int ticket=10;  
public void run(){  
for(int i=0;i<20;i++){  
if(this.ticket>0){  
System.out.println(Thread.currentThread().getName()+"卖票：ticket"+this.ticket--);  
}  
}  
}
}*/
/*class Runner1 implements Runnable { // 实现了Runnable接口，jdk就知道这个类是一个线程
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("进入Runner1运行状态——————————" + i);
		}
	}
}

class Runner2 implements Runnable { // 实现了Runnable接口，jdk就知道这个类是一个线程
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("进入Runner2运行状态==========" + i);
		}
	}
}*/