import java.util.*;

public class hashmapClass {
    public static void main(String[] args) {
        Map<String, Integer> map = new Map<>();
        for(int i=0;i<20;i++) {
            map.insert("abc" +i, i+1);
            System.out.println(map.loadFactor());
        }
        map.removeKey("abc3");
        map.removeKey("abc7");
        for(int i=0;i<20;i++) {
            System.out.println("abc"+ i+":" + map.getValue("abc" + i));
        }
    }
}

class Map<K,V>{
    ArrayList<mapNode<K,V>> buckets;
    int bucketsize;
    int size;
    Map(){
        buckets=new ArrayList<mapNode<K,V>>();
        bucketsize=20;
        size=20;
        for(int i=0;i<bucketsize;i++){
            buckets.add(null);
        }
    }

    int getBucketIndex(K key) {
        int index=key.hashCode();
        return index%bucketsize;
    }

    double loadFactor() {
        return (1.0*size)/bucketsize;
    }

    void insert(K key, V value){
        int bucketindex=getBucketIndex(key);
        mapNode<K,V> head=buckets.get(bucketindex);
        while(head!=null){
            if(head.key.equals(key)){
                head.value=value;
                return;
            }
            head=head.next;
        }
        head=buckets.get(bucketindex);
        mapNode<K, V> temp=new mapNode<K, V>(key, value);
        temp.next=head;
        buckets.set(bucketindex, temp);
        size++;

        double loadfactor=(1.0*size)/bucketsize;
        if(loadfactor>0.6){
            rehash();
        }

    }

    int getSize(){
        return size;
    }

    V getValue(K key){
        int bucketindex=getBucketIndex(key);
        mapNode<K,V> head=buckets.get(bucketindex);
        while(head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head=head.next;
        }
        return null;
    }

    V removeKey(K key){
        int bucketindex=getBucketIndex(key);
        mapNode<K,V> head=buckets.get(bucketindex);
        mapNode<K,V> prev=null;
        while (head!=null){
            if(head.key.equals(key)){
                if(prev!=null){
                    prev.next=head.next;
                }else{
                    buckets.set(bucketindex, head.next);
                }
                size--;
                return head.value;
            }
        }
        return null;
    }

    private void rehash(){
        ArrayList<mapNode<K, V>> temp=buckets;
        buckets = new ArrayList<>();
        for(int i=0; i<bucketsize*2;i++){
            buckets.add(null);
        }
        bucketsize*=2;
        for(int i=0; i<temp.size(); i++){
            mapNode<K, V> head=temp.get(i);
            while(head!=null){
                V value=head.value;
                K key=head.key;
                insert(key, value);
                head=head.next;
            }
        }
    }

}

class mapNode<K,V>{
    K key;
    V value;
    mapNode<K,V> next;
    mapNode(K key, V value){
        this.key = key;
        this.value = value;
    }
}
