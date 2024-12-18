package collection.link;

public class NodeMain2 {

    public static void main(String[] args) {
        //노드 생성하고 연결하기: A -> B -> C
        Node first = new Node("A");//x01
        first.next = new Node("B");//x02
        first.next.next = new Node("C");//x03

        System.out.println("연결된 노드 출력하기");
        System.out.println(first);

        //Node{item = A, next=x02}
        //Node{item = A, next={item=B, next={item=3, next=null}}}
    }
}
