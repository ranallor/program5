package csc220.program5.ranallor;

import csc220.list.AddIterator;
import csc220.list.Node;

/**
 * Robert Ranallo
 * Project 5
 * 5/3/2017
 * An extension of list.AddIterator, this Class allows GameCharacters to have their paths
 * altered from within the program.
 */

public class List<E> extends csc220.list.List<E> { 
       
   @Override
   public AddIterator<E> addIterator(){return new ListAddIterator<>();}
   
   
   //  This nested class replaces the one in csc220.list.List
   protected class ListAddIterator<T extends E> extends csc220.list.List<E>.ListAddIterator<E> {
       
       private static final boolean DEBUGGING = true;
      
        protected Node<E> prevNode = null;
        
        @Override
        public E next() {
            prevNode= nextNode;
            return super.next();
        }

        // For debugging purposes.
        private void printNodes(String s) {
            if (!DEBUGGING)
                return;
            System.out.print(s);
            if (prevNode != null) {
                System.out.print("--previous data = " + prevNode.data);
            }
            if (nextNode != null) {
                System.out.print("--next data = " + nextNode.data);               
            }
            System.out.println("");
        }
        
        @Override 
        public void addBeforeNext(E e) {
            Node<E> tmpNode = new Node();
            tmpNode.data = e;
            if(nextNode == null) {
                prevNode.next = tmpNode;
                tmpNode.next = nextNode;
            }
            else {
                if(first.data.equals(nextNode.data)) {
                    first.next = tmpNode;
                    tmpNode.next = nextNode;
                }
                else {
                    prevNode.next = tmpNode;
                    tmpNode.next = nextNode;
                }
            }
        }
        
        @Override
        public void remove() {
            if(prevNode == null) {
                throw new UnsupportedOperationException("Failing to generate You Win! message");
            }
            if (prevNode != first) {
                Node<E> tmpNode = first;
                while (tmpNode.next != prevNode) {
                    tmpNode = tmpNode.next;
                }
                tmpNode.next = nextNode;
                
            }
            if(prevNode == last) {
                last = prevNode;
            }
            
            prevNode = null;
            
        }
     }
   
   
}
