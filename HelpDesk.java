// Team LimeJuice - Eric Chen, Kevin Li, Eugene Thomas
// APCS2 pd4
// lab03
// 2017-04-23

import java.util.Scanner;
import cs1.Keyboard;

public class HelpDesk {

    private static ArrayPriorityQueue<Ticket> _tickets;
    private static int _idCounter;

    public HelpDesk() {
	_tickets = new ArrayPriorityQueue<Ticket>();
	_idCounter = 1;
    }

    // Opens a new ticket with specified name and problem.  Auto-generates id using _idCounter.
    public static int openTicket( String name, String problem ) {
	_tickets.add( new Ticket( name, _idCounter, 1, problem ) );
	return _idCounter++;
    }

    // Sets the priority of ticket at index to highest(0).  Returns true if successful, false otherwise.
    public boolean prioritize( int id ) {
	ArrayPriorityQueue<Ticket> holder = _tickets;
	for ( int i = 0; i < holder.size(); i++ ) {
	    if ( holder.peekMin().getID() == id ) {
		holder.peekMin().setPriority( 0 );
	    return true;
	    } 
	    else {holder.removeMin();}
	}
	return false;
    }

    // Resolves the ticket and returns the old solution, if applicable.
    public static String solveTicket( int id, String solution ) {
	String oldSolution = "";
	ArrayPriorityQueue<Ticket> holder = _tickets;
	for ( int i = 0; i < holder.size(); i++ ) {
	    if ( holder.peekMin().getID() == id ) {
		oldSolution = holder.peekMin().setSolution( solution );
		holder.peekMin().setResolved( true );
		holder.peekMin().setPriority( 2 );
		break;
	    }
	}
	return oldSolution;
    }

    public static void printer() {

	boolean finished = false; 
	while (!finished) { 
	 
	System.out.println( "\nDo you have an inquiry? (y/n)\n" );
	char yesno = Keyboard.readChar();
	if ( yesno == 'y' ) {
	    System.out.println( "\nThank you! Please enter your name:\n" );
	    String name = Keyboard.readString();
	    System.out.println( "\nHello, " + name + ". What do you need assistance with?\n" );
	    String prblm = Keyboard.readString();
	    _tickets.add( new Ticket( name, _idCounter, 1, prblm ) );
	    System.out.println( "\nTicket created with ID No. " + _idCounter + ".  Please allow some time for a solution to be posted.\n" );
	    _idCounter++; 
	}
	else if ( yesno == 'n' ) {
	    if (_tickets.size() == 0) {finished = true;} 
	    else { 
	    System.out.println( "\nPlease enter github username here (lowercase only): \n" );
	    String username = Keyboard.readWord();
	    if ( username.equals("echen8") || username.equals("kli16") || username.equals("eugenethomas") ) {
		System.out.println( "\nSuccessfully logged in.  Please choose what you would like to do below...\n" );
		System.out.println( "  1 | Check next unresolved ticket." );
		System.out.println( "  2 | Resolve next ticket." );
		System.out.println( "  3 | Log out.\n" );
		int choice = Keyboard.readInt();
		if ( choice == 1 ) {
		    System.out.println( "\nDisplaying unresolved ticket.\n" );
		    System.out.println( _tickets.peekMin() );
		}
		else if ( choice == 2 ) {
		    System.out.println( "\nPlease input the solution to resolve the ticket with.\n" );
		    String soln = Keyboard.readString();
		    if ( !soln.equals(null) ) {
		        solveTicket( _tickets.peekMin().getID(), soln );
		        System.out.println("\nHello ID# " + _tickets.peekMin().getID() + "! Your solution is " + soln); 
			_tickets.removeMin(); 
		    }
		    else {
			System.out.println( "Did not specify solution. Ticket was not resolved." );
		    }
		}
		else if ( choice == 3 ) {
		    System.out.println( "Logging out..." );
		}
	    }}
	}
	else {
	    System.out.println( "Incorrect input detected." );
	}  } 
    }
    
    public static void main( String[] args ) {
	HelpDesk test = new HelpDesk(); 
	test.printer();
    }
}
