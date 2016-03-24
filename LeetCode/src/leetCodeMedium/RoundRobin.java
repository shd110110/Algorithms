package leetCodeMedium;

import java.util.LinkedList;

/**
 * @author Poirot
 * 2015年9月17日
 */
public class RoundRobin {
	public float watingTimeRobin(int[] arriveTime, int[] runTime, int t) {
		if (arriveTime.length == 0) {
			return 0;
		}
		int[] finishTime = new int[runTime.length];
		for (int i = 0; i < finishTime.length; i++) {
			finishTime[i] = arriveTime[i];
		}
		int totalLength = arriveTime.length;
		int totalTime = 0;
		float totalRuntime = 0;
		for (int i = 0; i < runTime.length; i++) {
			totalRuntime += runTime[i];
		} 
		LinkedList<Integer> runList = new LinkedList<>();
		runList.add(0); 
		int jobNumber = 0;
		while (true) { 
			if (runList.isEmpty() && jobNumber >= runTime.length-1) {
				break;
			}
			if (runList.isEmpty()) {
				jobNumber++;
				runList.add(jobNumber);
			} 
			while (!runList.isEmpty()) {
				int i = runList.pop();
				if (runTime[i] != 0) {
					if (arriveTime[i] > totalTime) {
						totalTime = arriveTime[i];
					}
					if (runTime[i] > t) {
						totalTime += t;
						runTime[i] -= t;
						runList.addLast(i);
					} else {
						totalTime += runTime[i];
						runTime[i] = 0;
						finishTime[i] = totalTime;
					}
					
				}
			} 
		}
		int totalLifeTime = 0;
		for (int i = 0; i < finishTime.length; i++) {
//			   System.out.println(finishTime[i]);
			totalLifeTime += (finishTime[i] - arriveTime[i]);
		}
		return (totalLifeTime- totalRuntime) / totalLength;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arriveTime = {0,1,3,9};
		int[] runTime = {2,1,7,5};
		int time = 2;
		RoundRobin t = new RoundRobin();
		System.out.println(t.watingTimeRobin(arriveTime, runTime, time));
	}

}
