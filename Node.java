public class Node {
    private String value;
    private Node next;

    public Node(String value, Node next) {
        this.value = value;
        this.next = next;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    @Override
    public String toString() {
        String temp = "";
        Node curr = this;
        while (curr != null) {
            temp = temp + curr.value + " -> ";
            curr = curr.next;
        }
        return temp;
    }
}