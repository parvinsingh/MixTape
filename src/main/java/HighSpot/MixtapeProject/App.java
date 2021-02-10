package HighSpot.MixtapeProject;

import java.util.Scanner;

/**
 * MixTape Take Home Assignment
 * @author Parvin Singh
 */
public class App 
{
	/**
	 * This is the entry point
	 */
    public static void main( String[] args )
    {
    	displayHelpContent(); //displays helpful content on the screen
		
		Scanner s = new Scanner(System.in);
		String cmd = s.next();
		
		if(cmd.equalsIgnoreCase("Q")) {
			System.exit(1);	
		}

		ModifyMixTapeData actions = new ModifyMixTapeData();
		
		actions.readInput();
		
		while(!cmd.equalsIgnoreCase("Q"))
        {
			if(cmd.contains("Modify")) {
				actions.modifyData();
			}
			
			System.out.println("Continue making edits ! Enter the change file path or Q for Quit");
			cmd = s.next();
        }
		
		System.exit(1);
	
    }
    
	private static void displayHelpContent() {
		System.out.println("====================");
		System.out.println("==Use the following commands.");
		System.out.println("==action Modify  : To make changes provided in the change file");
		System.out.println("Q - Quit");
		System.out.println("====================");
	}
}
