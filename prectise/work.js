
let randomNumbers = []

let sumOfthirty = 0;
let avaregeNumber = 0;
for (let i = 0; i < 1000; i++){
    let randomNumber = Math.random() * 1000
    randomDecimalNumber = parseFloat(randomNumber.toFixed(2))
    randomNumbers.push(randomDecimalNumber)
    sumOfthirty += randomDecimalNumber
    if (i > 29){
        avaregeNumber = sumOfthirty / 30;
        sumOfthirty -= randomNumbers[i-30]
    }
    console.log(avaregeNumber); 
}