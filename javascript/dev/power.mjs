function power(x,n){
    if(n==1){
        return x;
    }
    return x * power(x,n-1);
}
console.log(power(3,2));
console.log(power(2,5));