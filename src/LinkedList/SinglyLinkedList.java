package LinkedList;

class SinglyLinkedList<T>{

    /**
     * append() : 단방향 링크드리스트에 데이터를 삽입
     * delete() : 단방향 링크드리스트에 데이터를 삭제
     * retrieve() : 단방향 링크드리스트에 있는 데이터를 모두 출력
     * removeDups() : 단방향 링크드리스트에 중복 데이터를 삭제
     * @param <T>
     */

    static class Node<T>{
        private T data;
        private Node<T> next = null;
        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> head;

    public void append(T item){
        if(this.head == null){
            this.head = new Node(item);
        }
        Node n = this.head;
        while(n.next != null){
            n = n.next;
        }
        n.next = new Node(item);
    }

    public void delete(T item){
        Node n = this.head;
        if(n.data == item){
            this.head = n.next;
        }else{
            while(n.next != null){
                if(n.next.data == item){
                    n.next = n.next.next;
                }else{
                    n = n.next;
                }
            }
        }
    }

    public void retrieve(){
        Node n = this.head;
        while(n.next != null){
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    void removeDups(){
        Node n = this.head;
        while(n != null && n.next != null){
            Node r = n;
            while(r.next != null){
                if(n.data == r.next.data){
                    r.next = r.next.next;
                }else{
                    r = r.next;
                }
            }
            n = n.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.append(1);
        linkedList.append(10);
        linkedList.append(15);
        linkedList.append(20);
        linkedList.append(30);
        linkedList.append(1);
        linkedList.retrieve();
        linkedList.append(20);
        linkedList.removeDups();
        linkedList.delete(1);
        linkedList.retrieve();
    }
}
