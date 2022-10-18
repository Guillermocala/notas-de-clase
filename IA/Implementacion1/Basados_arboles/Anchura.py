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

def movements(actual_config, type_movement):
    respuesta_matrix = []
    actual_matrix = tupleToMatrix(actual_config)
    actual_position = calculatePosition(actual_matrix)
    x = actual_position[0]
    y = actual_position[1]
    #moveDown
    if type_movement == 1:
        if x == 0:
            return -1
        else:
            actual_matrix[x][y], actual_matrix[x - 1][y] = actual_matrix[x - 1][y], 0
            respuesta_tuple = matrixToTuple(actual_matrix)
            return respuesta_tuple
    #moveLeft
    if type_movement == 2:
        if y == (len(actual_matrix) - 1):
            return -1
        else:
            actual_matrix[x][y], actual_matrix[x][y + 1] = actual_matrix[x][y + 1], 0
            respuesta_tuple = matrixToTuple(actual_matrix)
            return respuesta_tuple
    #moveUp
    if type_movement == 3:
        if x == (len(actual_matrix) - 1):
            return -1
        else:
            actual_matrix[x][y], actual_matrix[x + 1][y] = actual_matrix[x + 1][y], 0
            respuesta_tuple = matrixToTuple(actual_matrix)
            return respuesta_tuple
    #moveRight
    if type_movement == 4:
        if y == 0:
            return -1
        else:
            actual_matrix[x][y], actual_matrix[x][y - 1] = actual_matrix[x][y - 1], 0
            respuesta_tuple = matrixToTuple(actual_matrix)
            return respuesta_tuple
    #convertimos y retornamos

def expandCurrentState(actual_config):
    sucesores = []
    res = movements(actual_config, 3)
    if res != -1:
        sucesores.append(res)
    res = movements(actual_config, 4)
    if res != -1:
        sucesores.append(res)
    res = movements(actual_config, 1)
    if res != -1:
        sucesores.append(res)
    res = movements(actual_config, 2)
    if res != -1:
        sucesores.append(res)
    return sucesores

def showLikeMatrix(data):
    res = ""
    for i in range(len(data)):
        res += str(data[i])
        if i == 2 or i == 5 or i == 8:
            res += "\n"
    return res

def extractRoute(mapa, start, goal):
    print("extrayendo ruta...")
    ruta = set()
    ruta.add(goal)
    actual = goal
    activador = True
    cont = 0
    while activador:
        for key, value in mapa.items():
            if actual == start:
                activador = False
            if actual in value:
                if key in ruta:
                    break
                else:
                    actual = key
                    ruta.add(key)
    return ruta

def bfs_paths(start, goal):
    visitados = [start]
    queue = [start]
    mapa_expandidos = {}
    tam = 0
    while queue:
        path = queue.pop(0)  
        sucesores = expandCurrentState(path)
        mapa_expandidos[path] = sucesores
        for vecino in sucesores:
            if vecino not in visitados:
                if vecino == goal:
                    print("\t\tGOAL REACHED")
                    print("El tamaño max de cola fue: ", tam)
                    return mapa_expandidos
                else:
                    visitados.append(vecino)
                    queue.append(vecino)
                    if len(queue) > tam:
                        tam = len(queue)

def main():
    initial_config = openFile("./configs/config.txt")
    mapa = bfs_paths(initial_config, goal_config)
    ruta_objetivo = extractRoute(mapa, initial_config, goal_config)
    for item in ruta_objetivo:
        print(showLikeMatrix(item))

if __name__ == '__main__':
    main()