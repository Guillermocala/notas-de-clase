# Taken from: https://eddmann.com/posts/depth-first-search-and-breadth-first-search-in-python/
# a sample graph
import copy
import numpy as np

goal_config = [[1,2,3],
               [4,5,6],
               [7,8,0]]

###########################################
# Python3 program to check if a given
# instance of 8 puzzle is solvable or not
 
# A utility function to count
# inversions in given array 'arr[]'
def getInvCount(arr):
    inv_count = 0
    empty_value = -1
    for i in range(0, 9):
        for j in range(i + 1, 9):
            if arr[j] != empty_value and arr[i] != empty_value and arr[i] > arr[j]:
                inv_count += 1
    return inv_count
 
     
# This function returns true
# if given 8 puzzle is solvable.
def isSolvable(puzzle) :
 
    # Count inversions in given 8 puzzle
    inv_count = getInvCount([j for sub in puzzle for j in sub])
 
    # return true if inversion count is even.
    return (inv_count % 2 == 0)
     
    # Driver code
"""puzzle = [[8, 1, 2],[-1, 4, 3],[7, 6, 5]]
if(isSolvable(puzzle)) :
    print("Solvable")
else:
    print("Not Solvable")"""
     
    # This code is contributed by vitorhugooli
##############################################
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

def moveDown(actual_config):
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

def moveLeft(actual_config):
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


def moveUp(actual_config):
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

def moveRight(actual_config):
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
    visitados = [start]
    queue = [start]
    while queue:
        print("el tamaño de visitados es: ", len(visitados))

        path = queue.pop(0)
        #print(path)
        #print("el path antes de expandir es...")
        #print("path", path)
        for i in path:
            print(i)

        sucesores = expandCurrentState(path)
        for vecino in sucesores:
            if vecino not in visitados:
                if vecino == goal:
                    print("\t\tGOAL REACHED")
                    """for x in vecino:
                        print(x)
                    visitados.append(vecino)"""
                    return visitados
                else:
                    visitados.append(vecino)
                    queue.append(vecino)

        """if path not in visitados:
            visitados.append(path)
            for i in sucesores:
                if i == goal:
                    print("\t\tGOAL REACHED")
                    return camino
                else:
                    queue.append(i)
                    camino.append(i)"""


def main():
    initial_config = openFile("./configs/config.txt")
    if(isSolvable(initial_config)) :
        camino = bfs_paths(initial_config, goal_config)
        #print("Camino", camino)
    else:
        print("No se puede solucionar!")
    """for item in camino:
        for x in item:
            print(x)
        print()"""
    """print("el camino tiene: ", len(camino[1]))
    for item in camino[1]:
        print(item)"""
    #print("resultado", camino)

if __name__ == '__main__':
    main()