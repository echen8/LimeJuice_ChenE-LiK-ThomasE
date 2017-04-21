// Team LimeJuice - Eric Chen, Kevin Li, Eugene Thomas
// APCS2 pd4
// lab03
// 2017-04-21

public class Ticket {

    private int priority;
    private String problem;
    private String username;
    private int id;
    private boolean resolved;
    private String solution;

    public Ticket() {
	priority = 0;
    }

    public int getPriority() {
	return priority;
    }

    public int compareTo( Ticket t ) {
	if ( priority > t.getPriority() ) return 1;
	else if ( priority == t.getPriority() ) return 0;
	else return -1;
    }

}
