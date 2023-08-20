import java.util.*;

public class priorityQueueClass {
    public static void main(String[] args) {
        PriorityQueue<String> pq= new PriorityQueue<String>();
        pq.insert("abc", 15);
        pq.insert("def", 13);
        pq.insert("fsas", 90);
        pq.insert("fsafsafa", 150);
        pq.insert("xvxzxvssa", 120);

        while(!pq.isEmpty()){
            System.out.println(pq.getMin());
            pq.removeMin();
        }
    }
}

class PriorityQueue<T>{
    ArrayList<PQNode<T>> heap;
    PriorityQueue(){
        heap = new ArrayList<>();
    }

    void insert(T value, int priority){
        PQNode<T> newNode = new PQNode<>(value, priority);
        heap.add(newNode);
        int childIndex=heap.size()-1;
        int parentIndex=(childIndex-1)/2;
        while(childIndex>0){
            if(heap.get(childIndex).priority<heap.get(parentIndex).priority){
                PQNode<T> temp=heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);

                childIndex=parentIndex;
                parentIndex=(childIndex-1)/2;
            }else{
                return;
            }
        }
    }

    T removeMin(){
        if(isEmpty()){
            return null;
        }
        T ans=heap.get(0).value;
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int parentIndex=0;
        int rightChildIndex=(parentIndex*2)+2;
        int leftChildIndex=(parentIndex*2)+1;
        while(rightChildIndex<heap.size()){
            int minIndex= parentIndex;
            if( heap.get(leftChildIndex).priority < heap.get(minIndex).priority){
                minIndex= leftChildIndex;
            }
            if(heap.get(rightChildIndex).priority < heap.get(minIndex).priority){
                minIndex= rightChildIndex;
            }
            PQNode<T> temp= heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            parentIndex= minIndex;
            leftChildIndex= 2*parentIndex+1;
            rightChildIndex= 2*parentIndex +2;
        }
        return ans;
    }

    T getMin(){
        if(isEmpty()){
            return null;
        }
        return heap.get(0).value;
    }

    boolean isEmpty(){
        return heap.size() == 0;
    }

    int size(){
        return heap.size();
    }



}

class PQNode<T>{
    T value;
    int priority;
    PQNode(T value,int priority){
        this.value = value;
        this.priority = priority;
    }
}