function power(x,n){
    if(n==1){
        return x;
    }
    return x * power(x,n-1);
}

let result = power(3,2);
console.log(result);

result = power(2,5);
console.log(result);