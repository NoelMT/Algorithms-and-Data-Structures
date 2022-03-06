
public class SeparateChainingLiteHashST<Key, Value> {
    /*
    hash tabell som använder sig utan av chaining om collision sker.
     */
    private int n;       // number of key-value pairs antalet
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
    public SeparateChainingLiteHashST() {
        this(997);
    }

    // create separate chaining hash table with m lists
    public SeparateChainingLiteHashST(int m) {
        this.m = m;
        st = new Node[m];
    }


    // hash value between 0 and m-1, Maskerar MSB för att eliminera tecken biten sedan mod m för att.
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    // return n
    public int size() {
        return n;
    }

    // kollar om tabellen
    public boolean isEmpty() {
        return size() == 0;
    }

    // säger om nyckeln finns i tabellen
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
    //insert key-value pair into the table
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        int i = hash(key);
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


}
