package AlgoritmoYEstructuraDeDatos.Interfaces;

import AlgoritmoYEstructuraDeDatos.utils.IsEmptyException;

public class DynamicQueue<T> implements QueueInterface<T>{

    private Node<T> front;
    private Node<T> back;
    private int size;

    public DynamicQueue(){
        front=new Node<>(null,null);
        back=new Node<>(null,null);
        size=0;
    }
    @Override
    public void enqueue(T element) {
        if(isEmpty()){
            back = new Node<>(element);
            front=back;
        }else {
            Node<T> aux = new Node<>(element,null);
            back.next = (aux);
            back=aux;
        }
        ++size;
    }

    @Override
    public T dequeue() throws IsEmptyException {
        if(isEmpty()){
            throw new IsEmptyException();
        }else {
            T dequeued = front.data;
            front = front.next;
            --size;
            return dequeued;
        }
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }
}
