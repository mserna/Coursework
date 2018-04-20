/**************************************************
*. This class is the main game start menu
*  Will add more options for main menu in later builds
*
*  By Matthew Serna
*
***************************************************/

import java.util.*;

class TechCEODemo {

	public static void main(String[] args) {
		TechCEOGame demo;

		if(args.length > 0) {
			demo = new TechCEOGame(Integer.parseInt(args[0]));
		} else {
			demo = new TechCEOGame();
		}

		demo.play();
	}
}