function strLength(arr){
    if(arr.length == 1){
        return 1;
    }

    return 1 + strLength(arr.slice(0,-1));
}

let str = "apple";
let length = strLength(str);

console.log(length);