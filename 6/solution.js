const max_value = 100

const squares = []
const numbers = []

for(let i = 0; i <= max_value; i++) {
    numbers.push(i)
}

for(let i = 0; i <= max_value; i++) {
    squares.push(i * i)
}

const sum = (acc, val) => acc + val
const sum_of_squares = squares.reduce(sum)

let sum_of_vals = numbers.reduce(sum)
sum_of_vals *= sum_of_vals

console.log(Math.abs(sum_of_squares - sum_of_vals))