# Problem 1

end = 1000
sum = 0

for i in range(3, end, 3):
    if i % 5 != 0:
        sum += i


for i in range(5, end, 5):
    sum += i


print(sum)
