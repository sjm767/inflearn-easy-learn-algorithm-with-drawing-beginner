import { Queue } from "./Queue.mjs";

let queue = new Queue();

console.log("===== enqueue() 세 번 호출 =====");
queue.enque(1);
queue.enque(2);
queue.enque(3);

console.log(queue.front());

console.log("===== dequeue() 네 번 호출 =====");
console.log(queue.dequeue());
console.log(queue.dequeue());
console.log(queue.dequeue());
console.log(queue.dequeue());

console.log(`isEmpty: ${queue.isEmpty()}`);
