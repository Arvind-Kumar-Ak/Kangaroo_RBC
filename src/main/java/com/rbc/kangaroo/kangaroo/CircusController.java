package com.rbc.kangaroo.kangaroo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircusController {

	private CircusShow theCircusShow = new CircusShow();

	/*
	 * Below End point takes position and velocity of both kangaroos as request body
	 * and will set to an existing entity class.
	 */

	@PostMapping("/setPositions")
	public ResponseEntity<?> getKangarooPositions(@RequestBody CircusShow theCircusShow) {

		System.out.println(theCircusShow);
		this.theCircusShow = theCircusShow;
		return new ResponseEntity<String>("Kangaroo positions is now set", HttpStatus.ACCEPTED);
	}

	/* Below End point return the position of kangaroos which are being set */
	@GetMapping("/getPositions")
	public CircusShow getPositions() {

		return this.theCircusShow;
	}

	/*
	 * Once Kangaroos are set with their positions, Below endpoint will return the
	 * number of jumps needed for kangaroos to meet at same position
	 */

	@GetMapping("/willKangaroosMeet")
	public ResponseEntity<?> getStatusOfKangaroosMeet() {

		int noOfJumps = this.getJumpsOfKangaroosToMeet();

		if (noOfJumps == -1) {
			return new ResponseEntity<String>("Kangaroos does'nt meet and the result is " + noOfJumps, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Kangaroos will meet and No of Jumps Needed is " + noOfJumps,
					HttpStatus.OK);
		}
	}

	/*
	 * Below is the private method which calculate the jumps needed. It will return
	 * -1 if kangaroos does'nt meet
	 */
	private int getJumpsOfKangaroosToMeet() {

		int positionOfKangarooOne = this.theCircusShow.getPositionOfKangarooOne();
		int velocityOfKangarooOne = this.theCircusShow.getVelocityOfKangarooOne();
		int positionOfKangarooTwo = this.theCircusShow.getPositionOfKangarooTwo();
		int velocityOfKangarooTwo = this.theCircusShow.getVelocityOfKangarooTwo();
		int count = 0;

		/*
		 * The position of second kangaroo should be more than position of first
		 * kangaroo to get our logic executed. So swapping
		 */

		if (positionOfKangarooTwo < positionOfKangarooOne) {

			int temp = positionOfKangarooTwo;
			positionOfKangarooTwo = positionOfKangarooOne;
			positionOfKangarooOne = temp;

			int velocity = velocityOfKangarooTwo;
			velocityOfKangarooTwo = velocityOfKangarooOne;
			velocityOfKangarooOne = velocity;
		}

		/*
		 * if positions and velocity of first kangaroo is less than the second kangaroo,
		 * they wont meet at all.
		 */
		if (positionOfKangarooTwo > positionOfKangarooOne && velocityOfKangarooTwo > velocityOfKangarooOne) {
			return count - 1;
		} else {

			// increase the counts of jumps by adding the velocity to positions.
			while (positionOfKangarooTwo > positionOfKangarooOne) {
				positionOfKangarooTwo = positionOfKangarooTwo + velocityOfKangarooTwo;
				positionOfKangarooOne = positionOfKangarooOne + velocityOfKangarooOne;
				count++;

				// if both positions are equal at an instance, return the count of jumps
				if (positionOfKangarooOne == positionOfKangarooTwo) {
					return count;
				}

				/*
				 * if first kangaroo crosses the second one in position, they wont meet and this
				 * functions will return -1.
				 */
						

				if (positionOfKangarooOne > positionOfKangarooTwo) {
					return count - 1;
				}
			}
		}
		return count - 1;

	}

}

