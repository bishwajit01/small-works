package com.bishwajit.vikram.scheduling;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Bishwajit
 *
 */
public class SchedulingABackgroundTask {

	public static int i = 0;

	public static void main(String[] args) throws Exception {
		
		scheduledOperation();

		while (true) {
			System.out.println(i++);
			Thread.sleep(1000);
		}
	}

	private static void scheduledOperation() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (i >= 10) {
					i = 0;
				}
			}
		};
		/**
		 * Timer.schedule takes in three parameter
		 * task : <TimerTask> :task to be performed.
		 * date : <Date> :time to start current time or later
		 * period : <long> : time between the two execution task
		 * 1000 * 10 = 10 seconds
		 */
		timer.schedule(task, new Date(), 1000 * 10);
	}

}
