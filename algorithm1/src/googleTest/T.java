package googleTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class T {
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		
		int N = cin.nextInt();
		int M = cin.nextInt();
		int K = cin.nextInt();
		
		List<PriorityQueue<Student>> list = new ArrayList<>();
		for(int i = 0; i < M; i++){
			list.add(new PriorityQueue<Student>());
		}

		Student[] students=new Student[N];
		for(int i = 0; i < N; i++){
			students[i]=new Student(cin.nextInt(),cin.nextInt()+K,cin.nextInt());
			for(int j = 0; j < students[i].os; j++){
				students[i].offices[j]=cin.nextInt();
				students[i].serviceTime[j]=cin.nextInt();
			}
			list.get(students[i].offices[0]-1).add(students[i]);
		}
		
		PriorityQueue<Queues> now = new PriorityQueue<Queues>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).size()!=0){
				now.offer(new Queues(i,list.get(i).peek().arriveTime));
			}
		}
		while(!now.isEmpty()){
			Queues queues = now.poll();
			Student s = list.get(queues.id).poll();
			s.arriveTime += s.serviceTime[s.curr];
			s.curr++;
			if(s.curr!=s.os){
				s.arriveTime += K;
				list.get(s.offices[s.curr]-1).add(s);
			}else{
				s.leaveTime =s.arriveTime;
			}
			now.clear();
			for(int i=0;i<list.size();i++){
				if(list.get(i).size()!=0){
					now.offer(new Queues(i,list.get(i).peek().arriveTime));
				}
			}
		}
		
		
		for(int i = 0; i < N; i++){
			System.out.println(students[i].leaveTime);
		}
		cin.close();
	}


	static class Student implements Comparable<Student>{
		int id;
		int arriveTime;
		int os;
		int[] offices;
		int[] serviceTime;
		int leaveTime;
		int curr;
		public Student(int id,int arriveTime,int offices){
			this.id=id;
			this.arriveTime=arriveTime;
			this.os=offices;
			this.offices=new int[offices];
			serviceTime=new int[offices];
			curr=0;
		}

		@Override
		public int compareTo(Student other) {
			if(this.arriveTime!=other.arriveTime){
				return this.arriveTime-other.arriveTime;
			}else{
				return this.id-other.id;
			}
		}
	}
	
	static class Queues implements Comparable<Queues>{
		int id;
		int time;
		public Queues(int id, int time) {
			super();
			this.id = id;
			this.time = time;
		}
		@Override
		public int compareTo(Queues other) {
			return this.time-other.time;
		}
		
	}
}
