/*
denna klass är lik den andra hahs tabellen men den har en linked list i klassen istället för att använda en annan klass.
detta gör genom att skapa en nod array.

 */
public class SeparateChainingLiteHashmodST<Key, Value> {

    private int n;       // Antalet of key-value pairs
    private int m;       // hash table storlek
    private Node[] st;   // array of linked-list symbol tables

    // a helper linked list data type
    private static class Node {
        private Object key;
        private Object val;
        private Node next;

        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    // create separate chaining hash table
    public SeparateChainingLiteHashmodST() {
        this(997);
    }

    // create separate chaining hash table with m lists
    public SeparateChainingLiteHashmodST(int m) {
        this.m = m;
        st = new Node[m];
    }


    // hash value between 0 and m-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    // return number of key-value pairs in symbol table
    public int size() {
        return n;
    }

    // is the symbol table empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // is the key in the symbol table?
    public boolean contains(Key key) {
        return get(key) != null;
    }

    // return value associated with key, null if no such key
    public Value get(Key key) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return (Value) x.val;
        }
        return null;
    }

    // insert key-value pair into the table
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        int i = key.hashCode() % 97;
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        n++;
        st[i] = new Node(key, val, st[i]);
    }

    // delete key (and associated value) from the symbol table
    public void delete(Key key) {
        throw new UnsupportedOperationException("delete not currently supported");
    }

    // return all keys as an Iterable
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Node x = st[i]; x != null; x = x.next) {
                queue.enqueue((Key) x.key);
            }
        }
        return queue;
    }




}
