# Taken from: https://eddmann.com/posts/depth-first-search-and-breadth-first-search-in-python/
# a sample graph
import copy
import numpy as np

goal_config = [[1,2,3],
               [4,5,6],
               [7,8,0]]

def openFile(ruta):
    res = [[],[],[]]
    with open(ruta) as f:
        index = 0
        for line in f.readlines():
            for i in line.split(","):
                res[index].append(int(i))
            index += 1
    return res

def calculatePosition(actual):
    for x in range(len(actual)):
        for y in range(len(actual)):
            if actual[x][y] == 0:
                position = (x, y)
                return position

def moveUp(actual_config):
    # se usa deepcopy para que no altere la lista original
    res_config = copy.deepcopy(actual_config)
    actual_position = calculatePosition(res_config)
    x = actual_position[0]
    y = actual_position[1]
    if x == 0:
        return -1
    else:
        #data = res_config[x - 1][y]
        #res_config[x - 1][y] = 0
        #res_config[x][y] = data
        res_config[x][y], res_config[x - 1][y] = res_config[x - 1][y], 0
        return res_config

def moveRight(actual_config):
    # se usa deepcopy para que no altere la lista original
    res_config = copy.deepcopy(actual_config)
    actual_position = calculatePosition(res_config)
    x = actual_position[0]
    y = actual_position[1]
    if y == (len(res_config) - 1):
        return -1
    else:
        #data = res_config[x][y + 1]
        #res_config[x][y + 1] = 0
        #res_config[x][y] = data
        res_config[x][y], res_config[x][y + 1] = res_config[x][y + 1], 0
        return res_config


def moveDown(actual_config):
    # se usa deepcopy para que no altere la lista original
    res_config = copy.deepcopy(actual_config)
    actual_position = calculatePosition(res_config)
    x = actual_position[0]
    y = actual_position[1]
    if x == (len(res_config) - 1):
        return -1
    else:
        #data = res_config[x + 1][y]
        #res_config[x + 1][y] = 0
        #res_config[x][y] = data
        res_config[x][y], res_config[x + 1][y] = res_config[x + 1][y], 0
        return res_config

def moveLeft(actual_config):
    # se usa deepcopy para que no altere la lista original
    res_config = copy.deepcopy(actual_config)
    actual_position = calculatePosition(res_config)
    x = actual_position[0]
    y = actual_position[1]
    if y == 0:
        return -1
    else:
        #data = res_config[x][y - 1]
        #res_config[x][y - 1] = 0
        #res_config[x][y] = data
        res_config[x][y], res_config[x][y - 1] = res_config[x][y - 1], 0
        return res_config

def expandCurrentState(actual_config):
    sucesores = []
    res = moveUp(actual_config)
    if res != -1:
        sucesores.append(res)

    res = moveRight(actual_config)
    if res != -1:
        sucesores.append(res)

    res = moveDown(actual_config)
    if res != -1:
        sucesores.append(res)

    res = moveLeft(actual_config)
    if res != -1:
        sucesores.append(res)

    return sucesores
    
def bfs_paths(start, goal):
    visitados = []
    queue = [(start, [start])]
    while queue:
        print("el tamaño de visitados es: ", len(visitados))
        print("len queue", len(queue))
        path = queue.pop(0)
        print("len path", len(path))
        print("path 0", path[0])
        print("path 1", path[1])
        #print("el path antes de expandir es...")
        #print("path", path)
        """for i in path:
            print(i)"""

        if path[0] not in visitados:
            sucesores = expandCurrentState(path[0])
            visitados.append(path[0])
            for i in sucesores:
                if i == goal:
                    print("\t\tGOAL REACHED")
                    return path
                else:
                    #print("path + tuple", path + tuple(i))
                    queue.append((i, path + tuple(i)))
                    #queue.append(i, path + i)


def main():
    initial_config = openFile("./configs/config.txt")
    camino = bfs_paths(initial_config, goal_config)
    print("len camino", len(camino))
    print("len camino 0", len(camino[0]))
    print("len camino 1", len(camino[1]))

    for item in camino[0]:
        print(item)
    """print("el camino tiene: ", len(camino[1]))
    for item in camino[1]:
        print(item)"""
    #print("resultado", camino)

if __name__ == '__main__':
    main()