// Team LimeJuice - Eric Chen, Kevin Li, Eugene Thomas
// APCS2 pd4
// lab03
// 2017-04-21

public class Ticket implements Comparable<Ticket> {

    // I N S T A N C E   V A R I A B L E S 

    private String _name;
    private int _id;
    private int _priority;
    private String _problem;
    private String _solution;
    private boolean _resolved;

    public Ticket( String name, int id, int priority, String problem ) {
	_name = name;
	_id = id;
	_priority = priority;
	_problem = problem;
	_solution = "";
	_resolved = false;
    }

    // ACCESSORS

    public int getPriority() {
	return _priority;
    }
    public String getProblem() {
	return _problem;
    }
    public String getName() {
	return _name;
    }
    public int getID() {
	return _id;
    }
    public boolean isResolved() {
	return _resolved;
    }
    public String getSolution() {
	return _solution;
    }

    // MUTATORS =============================================

    public int setPriority( int priority ) {
	int oldPriority = _priority;
	_priority = priority;
	return oldPriority;
    }
    public String setProblem( String problem ) {
	String oldProblem = _problem;
	_problem = problem;
	return oldProblem;
    }
    public String setName( String name ) {
	String oldName = _name;
	_name = name;
	return oldName;
    }
    public int setID( int id ) {
        int oldID = _id;
	_id = id;
	return oldID;
    }
    public boolean setResolved( boolean resolved ) {
        boolean oldResolved = _resolved;
	_resolved = resolved;
	return oldResolved;
    }
    public String setSolution( String solution ) {
        String oldSolution = _solution;
	_solution = solution;
	return oldSolution;
    }

    // TOSTRING METHOD =======================================

    public String toString() {
	String retStr = "";
	retStr += "\nTicket No. " + _id;
	retStr += "\nName: " + _name;
	retStr += "\nProblem: " + _problem;
	retStr += "\nResolved: " + _resolved;
	return retStr;
    }

    public int compareTo( Ticket t ) {
	if ( _priority > t.getPriority() ) return 1;
	else if ( _priority == t.getPriority() ) return 0;
	else return -1;
    }

}
