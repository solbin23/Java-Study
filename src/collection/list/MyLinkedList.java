package collection.list;

public class MyLinkedList<E> implements MyList<E> {

    private Node<E> first;
    private int size = 0;


    @Override
    public void add(E e){
        Node<E> newNode = new Node<>(e);
        if(first == null){
            first = newNode;
        } else {
            Node<E> lastNode = getLastNode();
            lastNode.next = newNode;
        }
       size++;
    }

    private Node<E> getLastNode() {
        Node<E> x = first; //first 부터 뒤짐
        while(x.next != null){ // null 이 아니면
            x = x.next; // 계속 이동
        }
        return x;
    }

    @Override
    public void add(int index, E e) {
       Node<E> newNode = new Node<>(e);
       if (index == 0) {
           newNode.next = first;
           first = newNode;
       } else {
         Node<E> prev = getNode(index -1);
         newNode.next = prev.next;
         prev.next = newNode;
       }
       size++;
    }

    @Override
    public E set(int index, E e){
        //index 에 대한 노드를 찾는다.
        Node<E> x = getNode(index);
        //왜냐하면 item을 꺼내야 하기 때문에
        E oldValue = x.item;
        x.item = e;
        return oldValue;
    }

    @Override
    public E remove(int index){
        Node<E> removeNode = getNode(index);
        E removedItem = removeNode.item;
        if(index == 0){
            first = removeNode.next;

        }else {
           Node<E> prev = getNode(index - 1);
           prev.next = removeNode.next;
        }
        removeNode.item = null;
        removeNode.next = null;
        size--;
        return removedItem;
    }

    @Override
    public E get(int index){
        Node<E> node = getNode(index);
        return node.item;
    }

    private Node<E> getNode(int index) {
        Node<E> x = first;
        for(int i = 0; i < index; i++){
            x = x.next;
        }
        return x;
    }

    @Override
    public int indexOf(E o){
        int index = 0;
        for (Node<E> x = first; x != null; x = x.next){
            if(o.equals(x.item)){ //들어온 값과 item 값이 같다면
                return index; //index 반환
            }
            index++;
        }
        return -1; //못찾으면 -1 반환
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkedListV1{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }

    private static class Node<E>{

        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }

        //[A->B->C]
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<E> x = this;
            sb.append("[");
            while (x != null) {
                sb.append(x.item);
                if (x.next != null) {
                    sb.append("->");
                }
                x = x.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
