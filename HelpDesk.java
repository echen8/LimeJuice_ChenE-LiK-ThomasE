// Team LimeJuice - Eric Chen, Kevin Li, Eugene Thomas
// APCS2 pd4
// lab03
// 2017-04-23

public class HelpDesk {

    private ArrayPriorityQueue<Ticket> _tickets;
    private int _idCounter;

    public HelpDesk() {
	_tickets = new ArrayPriorityQueue<Ticket>();
	_idCounter = 1;
    }

    // Opens a new ticket with specified name and problem.  Auto-generates id using _idCounter.
    public void openTicket( String name, String problem ) {
	_tickets.add( new Ticket( name, _idCounter, 1, problem ) );
	_idCounter++;
    }

    // Sets the priority of ticket at index to highest(0).  Returns true if successful, false otherwise.
    public boolean prioritize( int id ) {
	for ( Ticket t : _tickets ) {
	    if ( t.getID() == id ) t.setPriority( 0 );
	    return true;
	}
	return false;
    }

    // Resolves the ticket and returns the old solution, if applicable.
    public String solveTicket( int id, String solution ) {
	String oldSolution = "";
	for ( Ticket t : _tickets ) {
	    if ( t.getID() == id ) {
		oldSolution = t.setSolution( solution );
		t.setResolved( true );
	    }
	}
	return oldSolution;
    }
}
