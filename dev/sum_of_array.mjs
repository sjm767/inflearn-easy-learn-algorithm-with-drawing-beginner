function sumArray(arr){
    if(arr.length == 1){
        return arr[0];
    }
    return arr[arr.length-1] + sumArray(arr.slice(0,-1));
}

let arr = [1,2,3,4,5];
let sum = sumArray(arr);

console.log(sum);