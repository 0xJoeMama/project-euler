# Problem 3

input_number = 600851475143
puts input_number

factors = []
i = 2

while i <= Integer.sqrt(input_number) do
    if i % 100000 == 0 then 
        puts i 
    end

    if factors.none? { |it| i % it == 0 } && (input_number % i == 0) then
        factors << i
    end

    i += 1
end

puts factors[-1]