package it.unibo.oop.lab.nesting2;

import java.util.Iterator;
import java.util.List;

import it.unibo.oop.lab.nesting2.Acceptor.ElementNotAcceptedException;

/**
 * 
 * Represents a list implementing the {@link Acceptable} interface
 *
 * @param <T>
 */
public class OneListAcceptable<T> implements Acceptable<T> {

	private List<T> list;
	
	/** 
	 * 
	 * @param list
	 * 			contains the sequence of elements to accept
	 */
	public OneListAcceptable(List<T> list) {
		this.list = list;
	}
	
	/**
	 *	@return an anonymous class implementing {@link Acceptor} 
	 */
	public Acceptor<T> acceptor() {
		Iterator<T> iterator = this.list.iterator();
		return new Acceptor<T>() {
			
			public void accept(T newElement) {
				try {
					if((iterator.next().equals(newElement))) {	
						return;
					}
				} catch(Exception e) {
					System.err.println("No more elements to accept..");
				}
				throw new ElementNotAcceptedException(newElement);
			}

			public void end() {
				if(iterator.hasNext()) {
					throw new EndNotAcceptedException();
				}
				
			}
		};
	}

}
