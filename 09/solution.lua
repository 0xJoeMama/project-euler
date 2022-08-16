-- find a pythagorean triplet where a + b + c = 1000
for a = 1, 1000 do
    for b = 1, 1000 do
        for c = 1, 1000 do
            if a + b + c == 1000 and a ^ 2 + b ^ 2 == c ^ 2 then
                print(a, b, c)
                print(a * b * c)
                goto out
            end
        end
    end
end

::out::
