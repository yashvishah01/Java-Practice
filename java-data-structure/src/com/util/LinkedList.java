package com.util;

public class LinkedList<E> {

	private Node head = null;
	private int count=0;
	public void add(E e) {
		Node newNode = new Node(e);
		if (head == null) {
			head = newNode;
		} else {
			Node last = head;
			while(last.getNext() != null) {
				last = last.getNext();
			}
			last.setNext(newNode);
		}
		count++;
		System.out.println(count);
	}

	public void add(int idx, E e) {
		Node newNode = new Node(e);
		Node temp = head;
		if(idx==0) {
			newNode.setNext(head);
			head = newNode;
		}
		for(int i=1 ; i<idx ; i++) {
			temp = temp.getNext();
		}
		newNode.setNext(temp.getNext());
		temp.setNext(newNode);
		count++;

	}

	public void set(int idx, E e) {
		if(idx >= 0 && idx <=count-1) {
			if(idx==0) {
				head.setData(e);
			}
			Node temp = head;
			for(int i=0 ; i<idx ; i++) {
				temp = temp.getNext();
			}
			temp.setData(e);
		}
		else throw new ArrayIndexOutOfBoundsException();
	}

	public E get(int idx) {
		Node temp = head;
		for(int i=0 ; i<idx ; i++) {
			temp = temp.getNext();
		}
		return (temp.getData());
	}

	public void reverse() {
		Node prev = null;
		Node curr = head;
		Node temp = head.getNext();

		while(curr.getNext()!=null) {
			curr.setNext(prev);
			prev = curr;
			curr = temp;
			temp = temp.getNext();
			//System.out.println(curr.getData());
		}
		curr.setNext(prev); // bcz not changed the last node next field
		head = curr;
	}

	public void remove(int idx) {
		Node temp = head;
		//Node before_temp = head;
		if(idx==0) {
			head = head.getNext();
		}
		int i=1;
		for(i=1 ; i<idx ; i++) {
			temp = temp.getNext();
		}
		temp.setNext(temp.getNext().getNext());
		if(i==count-1) temp.setNext(null);
		count--;
	}

	public void remove(E e) {
		Node temp = head;
		Node before_temp = head;
		
		if(head.getData()==e)	head = head.getNext();
		while(temp.getData()!=e) {
			before_temp = temp;
			temp=temp.getNext();
		}
		before_temp.setNext(temp.getNext());
		if(temp.getNext() == e)
			before_temp.setNext(null);
		
		count--;
	}

	public void iterator() {
		Node last = head;
		while(last.getNext() != null) {
			System.out.println(last.getData());
			last = last.getNext();
		}
		System.out.println(last.getData());
		
	}

	private class Node{
		private E data;
		private Node next;

		public Node(E data) {
			super();
			this.data = data;
		}

		public Node(E data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

		public E getData() {
			return data;
		}

		public void setData(E data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

}