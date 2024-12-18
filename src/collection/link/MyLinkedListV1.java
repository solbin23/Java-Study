package collection.link;

public class MyLinkedListV1 {

    private Node first;
    private int size = 0;


    public void add(Object e){
        Node newNode = new Node(e);
        if(first == null){
            first = newNode;
        } else {
            Node lastNode = getLastNode();
            lastNode.next = newNode;
        }
       size++;
    }

    private Node getLastNode() {
        Node x = first; //first 부터 뒤짐
        while(x.next != null){ // null 이 아니면
            x = x.next; // 계속 이동
        }
        return x;
    }
    
    public Object set(int index, Object e){
        //index 에 대한 노드를 찾는다.
        Node x = getNode(index);
        //왜냐하면 item을 꺼내야 하기 때문에
        Object oldValue = x.item;
        x.item = e;
        return oldValue;
    }
    public Object get(int index){
        Node node = getNode(index);
        return node.item;
    }

    private Node getNode(int index) {
        Node x = first;
        for(int i = 0; i < index; i++){
            x = x.next;
        }
        return x;
    }

    public int indexOf(Object o){
        int index = 0;
        for (Node x = first; x != null; x = x.next){
            if(o.equals(x.item)){ //들어온 값과 item 값이 같다면
                return index; //index 반환
            }
            index++;
        }
        return -1; //못찾으면 -1 반환
    }

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
}
