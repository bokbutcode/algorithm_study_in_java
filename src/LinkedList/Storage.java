package LinkedList;

public class Storage {
    private int carry = 0;
    private Node result;
    private Node node;
    private Boolean resultBoolean;

    Storage(){

    }

    Storage(Node node, boolean resultBoolean){
        this.node = node;
        this.resultBoolean = resultBoolean;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Boolean getResultBoolean() {
        return resultBoolean;
    }

    public void setResultBoolean(Boolean resultBoolean) {
        this.resultBoolean = resultBoolean;
    }

    public int getCarry() {
        return carry;
    }

    public void setCarry(int carry) {
        this.carry = carry;
    }

    public Node getResult() {
        return result;
    }

    public void setResult(Node result) {
        this.result = result;
    }
}
