# LimeJuice
<p> Eric Chen, Kevin Li, Eugene Thomas </p>

<h2> TO DO LIST / PROGRESS: </h2>
<ol> 
<li> <b> COMPLETED </b> One teammate: create a Git repo, named as you please. </li>
<li> <b> COMPLETED </b> Same teammate: add teammates as collaborators with write access. </li>
<li> <b> COMPLETED </b> All teammates: consult the Java API entries for interface PriorityQueue and class ArrayPriorityQueue. </li>
<li> <b> COMPLETED </b> Collaboratively design your helpdesk app. Your guiding principles: </li>
  <ol>
  <li> Simplicity <b> check Design section </b> </li>
  <li> Reliability <b> check Design section </b> </li>
  <li> Sensibility <b> check Design section </b> </li>
  </ol>
<li> <b> COMPLETED </b> Write your own local PriorityQueue interface in accordance with subset API. </li>
<li> <b> COMPLETED </b> Augment the best of your trio’s ArrayPriorityQueue implementations to accommodate generics. </li>
<li> <b> COMPLETED </b> Write class Ticket, which will model a helpdesk request as discussed in class. </li>
<li> Write class HelpDesk, which will have as an instance variable an ArrayPriorityQueue of Tickets. </li>
<li> Explain in your README.md, in the root of your team’s repo, </li>
  <ol> 
  <li> <b> COMPLETED </b> Your design. </li>
  <li> Your embellishments beyond the basic design collaboratively developed in class. </li>
  <li> <b> COMPLETED </b> Make sure README.md contains, near the top, your team name and roster. </li>
  </ol>
<li> <b> COMPLETED </b> Add your repo as a submodule to the lab03 repo (https://github.com/ap251/lab03). </li>
</ol>

<h2> DESIGN: </h2>
<h3> General </h3>
<h4> ArrayPriorityQueue.java </h4>
  <ul>
  <li> Generically typed: T extends Comparable, since our Ticket was required to implement Comparable, and to use the APQ in HelpDesk, we needed our APQ implementation to use compareTo. </li>
  <li> Implements PriorityQueue: interface that details four methods, being add(), isEmpty(), peekMin() and removeMin() </li>
  <li> ArrayList Structure: 
    <p> BACK OF QUEUE =====> FRONT OF QUEUE <br>
    HIGHEST VALUE =====> LOWEST VALUE </p>
    Our add method loops through the array to place new elements in the correct priority, while our removeMin method simply removes the element at the back of the ArrayList. We chose this setup over the alternative, which was to implement removeMin by looping through and finding the highest priority and always adding to the same side, because it would maintain that priority order matches index order, which would make a toString method more efficient. In addition, the alternative would require that everytime removeMin is run, it loops through the entire ArrayList to guarantee that it finds the highest priority, while our implementation only requires looping through the queue up until the correct priority number.
    </li>
  </ul>
<h4> Ticket.java </h4>
  <ul>
  <li> implements Comparable, by requirement: this allows each Ticket to be compared to another based on priority.
  <li> Our Ticket implementation included the following instance variables: 
    <ul>
    <li> <code> private String _name </code>: gives each Ticket an identity to be referred to by. </li>
    <li> <code> private int _id </code>: a unique numeric number, useful when multiple tickets are being organized, like in HelpDesk. </li>
    <li> <code> private int _priority </code>: the number that explains the urgency of a Ticket's inquiry, 0 being highest priority. </li>
    <li> <code> private String _problem </code>: the inquiry of the Ticket. </li>
    <li> <code> private String _solution </code>: a solution, when given. </li>
    <li> <code> private boolean _resolved </code>: Marks whether the Ticket's problem was resolved or not. </li>
    </ul>
    </li>
   <li> toString(): shows the ticket No., name, problem, and _resolved status. </li>
   </ul>
<h4> HelpDesk.java </h4>
  <ul>
  <li> Underlying Data Structure: ArrayPriorityQueue, which is able to organize Tickets and readily add or remove them.
  <li> Our HelpDesk contains the following instance variable: 
    <ul>
    <li> <code> private int _idCounter </code>: We decided that each Ticket's id should be determined based on the HelpDesk designation, because that is the place where a Ticket's id would be useful. By creating an instance variable, we can designate a unique id to each Ticket when it is added, and the idcounter is simply incremented. </li>
    </ul>
    </li>
   <li> Our HelpDesk contains the following methods: 
    <ul>
    <li> <code> openTicket( String name, String problem ) </code>: Opens a new ticket with specified name and problem.  Auto-generates id using _idCounter. </li>
    <li> <code> prioritize( int id ) </code>: Sets the priority of ticket at index to highest(0).  Returns true if successful, false otherwise. </li>
    <li> <code> solveTicket( int id, String solution ) </code>: Resolves the ticket and returns the old solution, if applicable. </li>
    </ul>
    </li>
   </ul>
<h3> Embellishments </h3>
