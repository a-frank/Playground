package sample.remote.calculator;

import akka.actor.UntypedActor;

public class MultiActor extends UntypedActor {

	private static int counter = 0;

	private final int number;

	public MultiActor() {
		number = counter++;
	}

	@Override
	public void onReceive(Object arg0) throws Exception {
		while (true) {
			System.out.println("Working on actor number " + number + " (" + this + ")");
		}
	}

}
