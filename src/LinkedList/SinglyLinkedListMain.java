package LinkedList;

public class SinglyLinkedListMain{
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.append(7);
        linkedList.append(2);
        linkedList.append(8);
        linkedList.append(5);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.retrieve();
        linkedList.delete(1);
        linkedList.retrieve();
        int k = 3;
        Reference r = new Reference();
        Node found = linkedList.kThToLast(linkedList.getHead(), k, r);
        System.out.println(found.data);

        found = linkedList.kThToLastPoint(linkedList.getHead(), k);
        System.out.println(found.data);
        linkedList.deleteMidNode(linkedList.getNode(15));
        linkedList.retrieve();

        Node fN = linkedList.partitionPointFour(linkedList.getHead(), 5);
        while (fN.next != null) {
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
        Node tN = linkedList.partitionPointTwo(sLinkedList.getHead(), 5);
        while (tN.next != null) {
            System.out.print(tN.data + " -> ");
            tN = tN.next;
        }
        System.out.println(tN.data);

        /*
            문제 : 연결리스트에 수를 각 자리별로 입력
                  하지만 일의 자리를 헤더에 입력하도록 하였다.
                  이런식의 두 수를 받아 합해 똑같은 방식으로 입력하도록 한다.

            I/O :
                    L1 = 9 -> 1 -> 4 = 419
                    L2 = 6 -> 4 -> 3 = 346
                    L3 = 5 -> 6 -> 7 = 765
         */
        SinglyLinkedList l1 = new SinglyLinkedList();
        l1.append(9);
        l1.append(1);
        l1.append(4);
        l1.retrieve();
        SinglyLinkedList l2 = new SinglyLinkedList();
        l2.append(6);
        l2.append(4);
        l2.append(3);
        l2.retrieve();

        Node result = SinglyLinkedList.sumLists(l1.getHead(),l2.getHead(),0);
        while (result.next != null) {
            System.out.print(result.data + " -> ");
            result = result.next;
        }
        System.out.println(result.data);


        SinglyLinkedList l3 = new SinglyLinkedList();
        l3.append(9);
        l3.append(1);
        l3.retrieve();
        SinglyLinkedList l4 = new SinglyLinkedList();
        l4.append(1);
        l4.append(1);
        l4.retrieve();
        result = SinglyLinkedList.reversSumList(l3.getHead(),l4.getHead());
        while (result.next != null) {
            System.out.print(result.data + " -> ");
            result = result.next;
        }
        System.out.println(result.data);
    }
}

