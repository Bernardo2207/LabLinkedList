package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import linkedLists.LinkedList;
import linkedLists.AbstractSLList.SNode;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 
	
	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		// TODO Auto-generated method stub
		((SNode<E>) nuevo).setNext(first); 
		first = (SNode<E>) nuevo; 
		length++;
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		((SNode<E>) nuevo).setNext(((SNode<E>) target).getNext()); 
		((SNode<E>) target).setNext((SNode<E>) nuevo); 
		
		length++;
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		if (target == first)
			this.addFirstNode(nuevo); 
		else { 
			Node<E> prevNode = getNodeBefore(target);  
			this.addNodeAfter(prevNode, nuevo);} 
		length++;
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(first==null)throw new NoSuchElementException();
		
		return first;
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(last==null)throw new NoSuchElementException();
		SNode<E> lastN = first; 
		while (lastN.getNext() != null) {
			lastN = lastN.getNext();  }
		
		return lastN;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(target==null){throw new NoSuchElementException();}
		
		
		return ((SNode<E>)target).getNext();
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (target == first)  
			throw new NoSuchElementException("getPrevNode(...) : target is the first node."); 
		
		else{
			SNode<E> prev = first; 
		while (prev != null && prev.getNext() != target) 
			prev = prev.getNext();  
		return prev; }
		
	}

	public int length() {
		// TODO Auto-generated method stub
		return length;
	}

	public void removeNode(Node<E> target) {
		// TODO Auto-generated method stub
		if(((SNode<E>)target).equals(first)) {
//			((SNode<E>)target).setNext(first);
//			first=(SNode<E>)target;
			first=first.getNext();
			length--;
		}
	 else if(target!=null) {
		((SNode<E>)(this.getNodeBefore((SNode<E>)target))).setNext(((SNode<E>)target).getNext());
		target=null;
		length--;}
		
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}
//	public Object[] toArray() {
//		int i=0;
//		Object[] array = new Object[this.length()]; 
//	  
//		SNode<E> x= first;
//		  while(x.getNext()!=null) {
//			  
//			  array[i]= x.getElement();
//			  x=x.getNext();
//			  i++;
//	    }
//	    
//	    return array;
//	}
//
//
//	
//	public <E> E[] toArray(E[] array) {
//		int i=0;
//		if (array.length < this.length()) { 
//	       
//			array = (E[]) Array.newInstance(array.getClass().getComponentType(), this.length());
//	    } else if (array.length > this.length()) 
//	    	
//	    	for (int j=this.length(); j< array.length; j++) 
//	    		array[j] = null;
//	    
//	    
//	  SNode<E> x= (SNode<E>)this.getFirstNode();
//	  while(x.getNext()!=null) {
//		  array[i]= x.getNext().getElement();
//		  x=x.getNext();
//		  i++;
//	  }
//	        
//	    
//	    return array;	
//	}

}
