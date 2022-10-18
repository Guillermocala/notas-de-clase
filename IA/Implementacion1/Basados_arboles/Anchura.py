# Taken from: https://eddmann.com/posts/depth-first-search-and-breadth-first-search-in-python/
# a sample graph
import copy

"""en vez de usar un jodido sistema de array tridimensional
es por mucho más optimo usar un sistema de string
0123456789
fue lo primero que pense solo para hacer los movimientos faciles
al parecer tengo el cerebro de adorno...
"""

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
    ruta = [start]
    expandidos = 1
    while queue:
        print("La cantidad de expandidos es: ", expandidos)
        expandidos += 1
        path = queue.pop(0)
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
                    return ruta + vecino
                else:
                    visitados.append(vecino)
                    queue.append(vecino)
                    ruta.append(path + vecino)


def main():
    initial_config = openFile("./configs/config.txt")

    camino = bfs_paths(initial_config, goal_config)
    for x in camino:
        print(x)

    """if(isSolvable(initial_config)):

        
    else:
        print("No se puede solucionar!")"""
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