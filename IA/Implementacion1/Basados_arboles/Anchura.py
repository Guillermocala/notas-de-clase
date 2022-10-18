# Taken from: https://eddmann.com/posts/depth-first-search-and-breadth-first-search-in-python/
# a sample graph
import copy

"""en vez de usar un jodido sistema de array tridimensional
es por mucho más optimo usar un sistema de string
0123456789
fue lo primero que pense solo para hacer los movimientos faciles
al parecer tengo el cerebro de adorno...
"""

goal_config = (1, 2, 3, 4, 5, 6, 7, 8, 0)

def openFile(ruta):
    temp = list()
    with open(ruta) as f:
        for line in f.readlines():
            for i in line.split(","):
                temp.append(int(i))
    res = tuple(temp)
    return res

def calculatePosition(actual):
    for x in range(len(actual)):
        for y in range(len(actual)):
            if actual[x][y] == 0:
                position = (x, y)
                return position

def tupleToMatrix(data):
    res = [[data[0], data[1], data[2]],
           [data[3], data[4], data[5]],
           [data[6], data[7], data[8]]]
    return res

def matrixToTuple(data):
    a = list()
    for item in data:
        for i in item:
            a.append(i)
    b = tuple(a)
    return b

#hay que arreglar esto porque esta devolviendo los 4 estados
def movements(actual_config, type_movement):
    respuesta_matrix = []
    actual_matrix = tupleToMatrix(actual_config)
    actual_position = calculatePosition(actual_matrix)
    x = actual_position[0]
    y = actual_position[1]
    #moveDown
    if type_movement == 1:
        if x != 0:
            actual_matrix[x][y], actual_matrix[x - 1][y] = actual_matrix[x - 1][y], 0
    #moveLeft
    if type_movement == 2:
        if y != (len(actual_matrix) - 1):
            actual_matrix[x][y], actual_matrix[x][y + 1] = actual_matrix[x][y + 1], 0
    #moveUp
    if type_movement == 3:
        if x != (len(actual_matrix) - 1):
            actual_matrix[x][y], actual_matrix[x + 1][y] = actual_matrix[x + 1][y], 0
    #moveRight
    if type_movement == 4:
        if y != 0:
            actual_matrix[x][y], actual_matrix[x][y - 1] = actual_matrix[x][y - 1], 0
    #convertimos y retornamos
    respuesta_tuple = matrixToTuple(actual_matrix)
    return respuesta_tuple

def expandCurrentState(actual_config):
    sucesores = []
    res = movements(actual_config, 3)
    sucesores.append(res)
    res = movements(actual_config, 4)
    sucesores.append(res)
    res = movements(actual_config, 1)
    sucesores.append(res)
    res = movements(actual_config, 2)
    sucesores.append(res)
    return sucesores

def showLikeMatrix(data):
    for i in range(len(data)):
        print(data[i], end="")
        if i == 2 or i == 5 or i == 8:
            print()
    
def bfs_paths(start, goal):
    visitados = [start]
    queue = [start]
    mapa = {}
    expandidos = 1
    while queue:
        print("La cantidad de expandidos es: ", expandidos)
        expandidos += 1
        path = queue.pop(0)
        showLikeMatrix(path)

        sucesores = expandCurrentState(path)
        mapa[path] = sucesores
        for vecino in sucesores:
            if vecino not in visitados:
                if vecino == goal:
                    print("\t\tGOAL REACHED")
                    return mapa
                else:
                    visitados.append(vecino)
                    queue.append(vecino)


def main():
    initial_config = openFile("./configs/config.txt")
    camino = bfs_paths(initial_config, goal_config)
    for key,value in camino.items():
        print(key, "value: ", value)

if __name__ == '__main__':
    main()