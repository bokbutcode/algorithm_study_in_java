package LinkedList;

import stack.Stack;

class SinglyLinkedList {
    /**
     * getNode() : 파라미터로 받은 item과 동일한 노드 조회
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

    private Node head;

    public Node getHead(){
        return this.head;
    }

    public Node getNode(int item) {
        Node n = this.head;
        if (n.data == item) {
            return n;
        } else {
            while (n.next != null) {
                n = n.next;
                if (n.data == item) {
                    break;
                }
            }
        }
        return n;
    }

    public void append(int item) {
        if (this.head == null) {
            this.head = new Node(item);
        } else {
            Node n = this.head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = new Node(item);
        }
    }

    public void delete(int item) {
        Node n = this.head;
        if (n.data == item) {
            this.head = n.next;
        } else {
            while (n.next != null) {
                if (n.next.data == item) {
                    n.next = n.next.next;
                } else {
                    n = n.next;
                }
            }
        }
    }

    public void retrieve() {
        Node n = this.head;
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    void removeDups() {
        Node n = this.head;
        while (n != null && n.next != null) {
            Node r = n;
            while (r.next != null) {
                if (n.data == r.next.data) {
                    r.next = r.next.next;
                } else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }

    Node kThToLast(Node n, int k, Reference r) {
        if (n == null) {
            return null;
        }

        Node found = kThToLast(n.next, k, r);
        r.count++;
        if (r.count == k) {
            return n;
        }
        return found;
    }

    Node kThToLastPoint(Node n, int k) {
        Node p1 = this.head;
        Node p2 = this.head;

        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    boolean deleteMidNode(Node n) {
        if (n == null || n.next == null) {
            return false;
        }

        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    Node partitionPointFour(Node n, int x) {
        Node s1 = null;
        Node e1 = null;
        Node s2 = null;
        Node e2 = null;

        while (n != null) {
            Node next = n.next;
            n.next = null;
            if (n.data < x) {
                if (s1 == null) {
                    s1 = n;
                    e1 = s1;
                } else {
                    e1.next = n;
                    e1 = n;
                }
            } else {
                if (s2 == null) {
                    s2 = n;
                    e2 = s2;
                } else {
                    e2.next = n;
                    e2 = n;
                }
            }
            n = next;
        }
        if (s1 == null) {
            return s2;
        }
        e1.next = s2;
        return s1;
    }

    Node partitionPointTwo(Node n, int x) {
        Node header = n;
        Node tail = n;

        while (n != null) {
            Node next = n.next;
            if (n.data < x) {
                n.next = header;
                header = n;
            } else {
                tail.next = n;
                tail = n;
            }
            n = next;
        }
        tail.next = null;
        return header;
    }

    public static Node sumLists(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        Node result = new Node();
        int value = carry;

        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }
        result.data = value % 10;

        if (l1 != null || l2 != null) {
            Node next = sumLists(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value >= 10 ? 1 : 0);
            result.next = next;
        }
        return result;
    }

    private static int getListLength(Node l){
        int total = 0;
        while(l != null){
            total++;
            l = l.next;
        }
        return total;
    }
    private static Node insertBefore(Node node, int data){
        Node before = new Node(data);
        if(node != null){
            before.next = node;
        }
        return before;
    }

    private static Node LPadList(Node l, int length){
        Node head = l;
        for(int i = 0; i < length; i++){
            head = insertBefore(head,0);
        }
        return head;
    }
    public static Node reversSumList(Node l1, Node l2){
        int len1 = getListLength(l1);
        int len2 = getListLength(l2);

        if(len1 < len2){
            l1 = LPadList(l1, len2 - len1);
        }else{
            l2 = LPadList(l2, len1 - len2);
        }
        Storage storage = addLists(l1, l2);
        if(storage.getCarry() == 0){
            return storage.getResult();
        }else{
            storage.setResult(insertBefore(storage.getResult(), storage.getCarry()));
        }
        return storage.getResult();
    }

    private static Storage addLists(Node l1, Node l2){
        if(l1 == null && l2 == null){
            Storage storage = new Storage();
            return storage;
        }
        Storage storage = addLists(l1.next, l2.next);
        int value = storage.getCarry() + l1.data + l2.data;
        int data = value % 10;
        storage.setResult(insertBefore(storage.getResult(), data));
        storage.setCarry(value / 10);
        return storage;
    }

    public static boolean isPalindrome(Node head){
        Node reversed = reversAndClone(head);
        return isEqual(head, reversed);
    }

    private static Node reversAndClone(Node node){
        Node header = null;
        while (node != null){
            Node n = new Node(node.data);
            n.next = header;
            header = n;
            node = node.next;
        }
        return header;
    }

    private static boolean isEqual(Node one, Node two){
        while(one != null && two != null){
            if(one.data != two.data){
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null ? true : false;
    }

    public static boolean isPalidromePoint(Node head){
        Node fastPoint = head;
        Node slowPoint = head;

        Stack<Character> stack = new Stack<>();

        while(fastPoint != null && fastPoint.next != null){
            stack.push((char) slowPoint.data);
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
        }

        if(fastPoint != null){
            slowPoint = slowPoint.next;
        }

        while(slowPoint != null){
            char c = stack.pop();

            if(slowPoint.data != c){
                return false;
            }
            slowPoint = slowPoint.next;
        }
        return true;
    }

    public static boolean isPalidromeRecursive(Node head){
        int nodeLength = getListLength(head);
        Storage storage = palidromeRecursive(head, nodeLength);
        return storage.getResultBoolean();
    }

    private static Storage palidromeRecursive(Node head, int nodeLength) {
        if(head == null || nodeLength <= 0){
            return new Storage(head, true);
        }else if(nodeLength == 1){
            return new Storage(head.next, true);
        }

        Storage storage = palidromeRecursive(head.next, nodeLength - 2);

        if(!storage.getResultBoolean() || storage.getNode() == null){
            return storage;
        }

        storage.setResultBoolean(head.data == storage.getNode().data);

        storage.setNode(storage.getNode().next);

        return storage;
    }
}