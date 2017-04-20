// Team Lemon Juice: Eric Chen, Kevin Li, Eugene Thomas
// APCS2 pd4
// HW32 -- Getting Past the Velvet Rope 
// 2017-04-19

/*
BACK OF QUEUE =====> FRONT OF QUEUE
HIGHEST VALUE =====> LOWEST VALUE
*/


import java.util.ArrayList; 

public class ArrayPriorityQueue implements PriorityQueue { 

    private ArrayList<Integer> _data; 

    public ArrayPriorityQueue() { 
	_data = new ArrayList<Integer>(); 
    } 
    
    public void add (int x) { 
	boolean isAdded = false; 
	for (int i = 0; i < _data.size(); i++) { 
	    if (x >= _data.get(i)) { 
		_data.add(i, x);
		isAdded = true; 
		break; 
	    } 
	}  
	if (!isAdded) { _data.add(x); } 
    } 
    
    public boolean isEmpty() { 
	return _data.size() == 0; 
    } 
    
    public int peekMin() { 
	return _data.get(_data.size()-1); 
    } 

    public int removeMin() { 
	return _data.remove(_data.size()-1);
    } 
    
    public String toString() { 
	String retStr = "LAST <--"; 
	for (int i: _data) { 
	    retStr += " " + i; 
	} 
	retStr += " --> FIRST"; 
	return retStr; 
    } 

    public static void main (String[] args) { 
        PriorityQueue a = new ArrayPriorityQueue(); 
	a.add(10); 
	System.out.println(a); 
	a.add(5); 
	System.out.println(a); 
	a.add(7); 
	System.out.println(a); 
	a.add(6); 
	System.out.println(a); 
	a.add(8); 
	System.out.println(a); 
	a.add(1); 
	System.out.println(a); 
	a.add(2); 
	System.out.println(a); 
	a.add(3); 
	System.out.println(a); 
	System.out.println("isEmpty... " + a.isEmpty() + "\n");
	System.out.println(a.peekMin());
	a.removeMin(); 
	System.out.println(a); 
	System.out.println(a.peekMin());
	a.removeMin(); 
	System.out.println(a); 
	System.out.println(a.peekMin());
	a.removeMin(); 
	System.out.println(a); 
	System.out.println(a.peekMin());
	a.removeMin(); 
	System.out.println(a); 
	System.out.println(a.peekMin());
	a.removeMin(); 
	System.out.println(a); 
	System.out.println(a.peekMin());
	a.removeMin(); 
	System.out.println(a); 
	System.out.println(a.peekMin());
	a.removeMin(); 
	System.out.println(a); 
	System.out.println(a.peekMin());
	a.removeMin(); 
	System.out.println(a); 
	System.out.println("isEmpty... " + a.isEmpty());
    } 
} 