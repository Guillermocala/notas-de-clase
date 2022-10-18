def tupleToMatrix(data):
    res = [[data[0], data[1], data[2]],
           [data[3], data[4], data[5]],
           [data[6], data[7], data[8]]]
    return res

matrix = tupleToMatrix((1, 2, 3, 4, 5, 6, 7, 8, 0))
print(matrix)


"""a = list()
for item in matrix:
    for i in item:
        a.append(i)

b = tuple(a)

print("a", a)
print("b", b)"""