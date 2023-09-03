class Node {
    constructor(data, next = null, prev = null) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    printAll() {
        let currentNode = this.head;
        let text = "[";
        while (currentNode != null) {
            text += currentNode.data;
            currentNode = currentNode.next;
            if (currentNode != null) {
                text += ",";
            }
        }
        text += "]";
        console.log(text);
    }

    clear() {
        this.head = null;
        this.count = 0;
    }
    insertLast(data) {
        this.insertAt(this.count, data);
    }

    insertAt(index, data) {

        if (index > this.count || index < 0) {
            throw new Error("범위를 넘어갔습니다");
        }

        let newNode = new Node(data);
        if (index == 0) {
            newNode.next = this.head;
            if (this.head != null) {
                this.head.prev = newNode;
            }
            this.head = newNode;
        } else if (index == this.count) {
            newNode.next = null;
            newNode.prev = this.tail;
            this.tail.next = newNode;

        } else {
            let currentNode = this.head;

            for (let i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }

            newNode.next = currentNode.next;
            newNode.prev = currentNode;

            currentNode.next = newNode;
            newNode.next.prev = newNode;
        }

        if (newNode.next == null) {
            this.tail = newNode;
        }

        this.count++;
    }
    deleteLast(index) {
        return this.deleteAt(this.count - 1);
    }

    deleteAt(index) {
        if (index > this.count || index < 0) {
            throw new Error("제거할 수 없습니다");
        }

        let currentNode = this.head;

        if (index == 0) {
            let deletedNode = this.head;
            if (this.head.next == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = deletedNode.next;
                deletedNode.next.prev = null;
            }
            this.count--;
            return deletedNode;
        } else if (index == this.count - 1) {
            let deletedNode = this.tail;
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
            this.count--;
            return deletedNode;
        } else {
            for (let i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            let deletedNode = currentNode.next;
            currentNode.next = deletedNode.next;

            deletedNode.next.prev = currentNode;
            this.count--;

            return deletedNode;
        }

    }

    getNodeAt(index) {
        if (index >= this.count || index < 0) {
            throw new Error("범위를 넘어갔습니다.");
        }

        let currentNode = this.head;
        for (let i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

}


export { Node, DoublyLinkedList };