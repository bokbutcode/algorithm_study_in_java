package LinkedList;

class SinglyLinkedList{
    /**
     * append() : 단방향 링크드리스트에 데이터를 삽입
     * delete() : 단방향 링크드리스트에 데이터를 삭제
     * retrieve() : 단방향 링크드리스트에 있는 데이터를 모두 출력
     * removeDups() : 단방향 링크드리스트에 중복 데이터를 삭제
     * kThToLast() : 단방향 링크드리스트를 끝에서 n번쨰 데이터 찾기
     * kThToLastPoint() : 단방향 링크드리스트를 끝에서 n번째 데이터를 포인터를 이용해서 찾기
     * deleteMidNode() : 단방향 링크드리스트에서 head를 모른체 중간 노드 삭제
     * partitionPointFour() : 포인트 4개를 이용한 기준값으로 분류하기
     * partitionPointTwo() : 포인트 2개를 이용한 기준값으로 분류하기
     */

    static class Node{
        private int data;
        private Node next = null;
        public Node(int data){
            this.data = data;
        }
    }

    private Node head;

    public Node getNode(int item){
        Node n = this.head;
        if(n.data == item){
            return n;
        }else{
            while(n.next != null){
                n = n.next;
                if(n.data == item){
                    break;
                }
            }
        }
        return n;
    }

    public void append(int item){
        if(this.head == null){
            this.head = new Node(item);
        }else{
            Node n = this.head;
            while(n.next != null){
                n = n.next;
            }
            n.next = new Node(item);
        }
    }

    public void delete(int item){
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

    Node kThToLast(Node n, int k, Reference r) {
        if(n == null){
            return null;
        }

        Node found = kThToLast(n.next, k, r);
        r.count++;
        if(r.count == k){
            return n;
        }
        return found;
    }

    Node kThToLastPoint(Node n, int k){
        Node p1 = this.head;
        Node p2 = this.head;

        for(int i = 0; i < k; i++){
            if(p1 == null) return null;
            p1 = p1.next;
        }

        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    boolean deleteMidNode(Node n){
        if(n == null || n.next == null){
            return false;
        }

        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    Node partitionPointFour(Node n, int x){
        Node s1 = null;
        Node e1 = null;
        Node s2 = null;
        Node e2 = null;

        while(n != null){
            Node next = n.next;
            n.next = null;
            if(n.data < x){
                if(s1 == null){
                    s1 = n;
                    e1 = s1;
                }else{
                    e1.next = n;
                    e1 = n;
                }
            }else{
                if(s2 == null){
                    s2 = n;
                    e2 = s2;
                }else{
                    e2.next = n;
                    e2 = n;
                }
            }
            n = next;
        }
        if(s1 == null){
            return s2;
        }
        e1.next = s2;
        return s1;
    }

    Node partitionPointTwo(Node n, int x){
        Node header = n;
        Node tail = n;

        while(n != null){
            Node next = n.next;
            if(n.data < x){
                n.next = header;
                header = n;
            }else{
                tail.next = n;
                tail = n;
            }
            n = next;
        }
        tail.next = null;
        return header;
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.append(7);
        linkedList.append(2);
        linkedList.append(8);
        linkedList.append(5);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.retrieve();
//        linkedList.removeDups();
        linkedList.delete(1);
        linkedList.retrieve();
        int k = 3;
        Reference r = new Reference();
        Node found = linkedList.kThToLast(linkedList.head,k,r);
        System.out.println(found.data);
        found = linkedList.kThToLastPoint(linkedList.head,k);
        System.out.println(found.data);
        linkedList.deleteMidNode(linkedList.getNode(15));
        linkedList.retrieve();

        Node fN = linkedList.partitionPointFour(linkedList.head, 5);
        while(fN.next != null){
            System.out.print(fN.data + " -> ");
            fN = fN.next;
        }

        SinglyLinkedList sLinkedList = new SinglyLinkedList();
        sLinkedList.append(7);
        sLinkedList.append(2);
        sLinkedList.append(8);
        sLinkedList.append(5);
        sLinkedList.append(3);
        sLinkedList.append(4);

        System.out.println(fN.data);
        Node tN = linkedList.partitionPointTwo(sLinkedList.head, 5);
        while(tN.next != null){
            System.out.print(tN.data + " -> ");
            tN = tN.next;
        }
        System.out.println(tN.data);
    }
}
