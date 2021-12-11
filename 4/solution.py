# Problem 4

def is_palindrome(num):
    i_str = str(num)
    reversed_i = i_str[::-1]

    return i_str == reversed_i


max_product = 0
for i in range(999, 0, -1):
    for j in range(999, 0, -1):
        product = i * j
        if is_palindrome(product) and product > max_product:
            max_product = product
            break

print(max_product)
