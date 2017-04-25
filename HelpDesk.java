// Team LimeJuice - Eric Chen, Kevin Li, Eugene Thomas
// APCS2 pd4
// lab03
// 2017-04-23

import java.util.Scanner;
import cs1.Keyboard;

public class HelpDesk {

    private ArrayPriorityQueue<Ticket> _tickets;
    private int _idCounter;

    public HelpDesk() {
	_tickets = new ArrayPriorityQueue<Ticket>();
	_idCounter = 1;
    }

    // Opens a new ticket with specified name and problem.  Auto-generates id using _idCounter.
    public int openTicket( String name, String problem ) {
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
    public String solveTicket( int id, String solution ) {
	String oldSolution = "";
	ArrayPriorityQueue<Ticket> holder = _tickets;
	for ( int i = 0; i < holder.size(); i++ ) {
	    if ( holder.peekMin().getID() == id ) {
		oldSolution = holder.peekMin().setSolution( solution );
		holder.peekMin().setResolved( true );
		holder.peekMin().setPriority( 2 );
		break;
	    }
	    else { 
		holder.removeMin(); 
	    } 
	}
	return oldSolution;
    }

    public static void printer() {
	System.out.println( "Do you have an inquiry? (y/n)" );
	char yesno = Keyboard.readChar();
	if ( yesno == 'y' ) {
	    System.out.println( "Please enter your name:\n" );
	    String name = Keyboard.readString();
	    System.out.println( "Hello, " + name + ".  What do you need assistance with?" );
	    String prblm = Keyboard.readString();
	    System.out.println( "Ticket created with ID No." + openTicket( name, prblm ) + ".  Please allow some time for a solution to be posted." );
	}
	else if ( yesno == 'n' ) {
	    
	    System.out.println( "Please enter github username here (lowercase only): " );
	    String username = Keyboard.readWord();
	    if ( username == "echen8" || username == "kli16" || username == "eugenethomas" ) {
		System.out.println( "Successfully logged in.  Please choose what you would like to do below." );
		System.out.println( "  1 | Check next unresolved ticket." );
		System.out.println( "  2 | Resolve a ticket." );
		System.out.println( "  3 | Log out." );
		int choice = Keyboard.readInt();
		if ( choice == 1 ) {
		    System.out.println( "Displaying unresolved ticket." );
		    System.out.println( _tickets.peekMin() );
		}
		else if ( choice == 2 ) {
		    System.out.println( "Please enter the ID of ticket to be resolved." );
		    int idTBR = Keyboard.readInt(); // id to be resolved
		    System.out.println( "Please input the solution to resolve the ticket with." );
		    String soln = Keyboard.readString();
		    if ( soln != null ) solveTicket( idTBR, soln );
		    else {
			System.out.println( "Did not specify solution. Ticket was not resolved." );
			printer();
		    }
		}
		else if ( choice == 3 ) {
		    System.out.println( "Logging out..." );
		    printer();
		}
	    }
	}
	else {
	    System.out.println( "Incorrect input detected." );
	    printer();
	}
    }
    
    public static void main( String[] args ) {
	printer();
    }
}
