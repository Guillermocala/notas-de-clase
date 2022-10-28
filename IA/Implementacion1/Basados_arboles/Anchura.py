import timeit
from isSolvable import isSolvable

""" El tablero final tiene la sgte forma
1,2,3
4,5,6
7,8,0
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

def bfs_paths(start, goal):
    queue = [(start, [start])]
    global iteracion
    iteracion = 0
    global max_queue
    max_queue = 0
    while queue:
        if max_queue < len(queue):
            max_queue = len(queue)
        iteracion += 1
        print("iteracion: ", iteracion)
        (vertex, path) = queue.pop(0)
        l = list(set(expandCurrentState(vertex)) - set(path))
        for next in sorted(l):
            if next == goal:
                print("\t\tGoal Reached!")
                return path + [next]
            else:
                queue.append((next, path + [next]))

def main():
    initial_config = openFile("./configs/config.txt")
    # verificamos si se puede solucionar
    if isSolvable(tupleToMatrix(initial_config)):
        init_time = timeit.default_timer()
        respuesta = bfs_paths(initial_config, goal_config)
        end_time = timeit.default_timer()
        execution_time = end_time - init_time
        #for item in respuesta:
            #print(showLikeMatrix(item))
        print("\t\tEstadisticas --- Anchura")
        print("\tTiempo de ejecucción fue de: ", format(execution_time, '.8f'))
        print("\tEl camino solucion consta de ", len(respuesta), " pasos.\n")
        print("\t\tMemory info...")
        print("\tTamaño maximo de pila: ", max_queue)
        print("\tNum nodos expandidos: ", iteracion)
    else:
        print("""
            Segun el verificador esta solucion no se puede resolver
            Presione 1 para continuar o cualquier otra tecla para salir: 
        """)
        opcion = input()
        if opcion == '1':
            respuesta = bfs_paths(initial_config, goal_config)
            for item in respuesta:
                print(showLikeMatrix(item))
            print("\t\tEstadisticas --- Anchura")
            print("\tTiempo de ejecucción fue de: ", format(execution_time, '.8f'))
            print("\tEl camino solucion consta de ", len(respuesta), " pasos.\n")
            print("\t\tMemory info...")
            print("\tTamaño maximo de pila: ", max_queue)
            print("\tNum nodos expandidos: ", iteracion)

if __name__ == '__main__':
    main()