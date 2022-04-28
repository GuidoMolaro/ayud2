package AlgoritmoYEstructuraDeDatos.Lists;

public class Node<T> {
    T data;
    Node<T> next;

    public Node(T x){
        data=x;
    }
    public Node(T x, Node<T> n){
        data=x;
        next = n;
    }
}
