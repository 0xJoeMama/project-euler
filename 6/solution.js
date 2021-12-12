const max_value = 100

let numbers = 0
let squares = 0

for(let i = 0; i <= max_value; i++) {
    numbers += i
}

for(let i = 0; i <= max_value; i++) {
    squares += i * i
}

numbers *= numbers
console.log(Math.abs(squares - numbers))