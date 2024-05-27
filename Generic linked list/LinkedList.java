class EmptyListException extends Exception {
    public EmptyListException(String message) {
        super(message);
    }
}

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Node<T>[] getFirstLastNodes() {
        Node<T>[] nodes = new Node[2];
        nodes[0] = this.head;
        nodes[1] = this.tail;
        return nodes;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.setNext(newNode);
        tail = newNode;
    }

    public T remove() throws EmptyListException {
        if (head == null) {
            throw new EmptyListException("The list is empty");
        }

        Node<T> tmp = head;
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return tmp.getData();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData()).append(" -> ");
            current = current.getNext();
        }
        sb.append("None");
        return sb.toString();
    }

    public LinkedList<T> reverse() {
        LinkedList<T> reversedList = new LinkedList<>();
        Node<T> current = this.head;
        while (current != null) {
            reversedList.addFirst(current.getData());
            current = current.getNext();
        }
        return reversedList;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public T max() throws EmptyListException {
        if (head == null) {
            throw new EmptyListException("The list is empty");
        }

        Node<T> current = head;
        T max = head.getData();

        while (current != null) {
            if (((Comparable<T>) current.getData()).compareTo(max) > 0) {
                max = current.getData();
            }
            current = current.getNext();
        }
        return max;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node<T> getFirst() {
        return head;
    }
}

