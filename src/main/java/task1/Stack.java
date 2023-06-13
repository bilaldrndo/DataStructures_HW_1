package task1;

public class Stack<Item> {
    private Queue<Item> q1;
    private Queue<Item> q2;
    private int size = 0;

    public Stack() {
        q1 = new Queue<>();
        q2 = new Queue<>();
        size = 0;
    }

    public void push(Item data) {
        q2.enqueue(data);
        while (!q1.isEmpty()) {
            q2.enqueue(q1.dequeue());
        }
        Queue<Item> temp = q1;
        q1 = q2;
        q2 = temp;
        size++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty.");
        }
        size--;
        return q1.dequeue();
    }

    public Item peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty.");
        }

        Item top = null;
        int size = q1.size();

        Item topToReturn = null;
        int j = 0;

        for (int i = 0; i < size; i++) {
            top = q1.dequeue();
            if (j == 0) {
                topToReturn = top;
                j++;
            }
            q2.enqueue(top);
        }

        Queue<Item> temp = q1;
        q1 = q2;
        q2 = temp;

        return topToReturn;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
