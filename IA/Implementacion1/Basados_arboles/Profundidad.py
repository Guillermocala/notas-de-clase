# Taken from: https://eddmann.com/posts/depth-first-search-and-breadth-first-search-in-python/
# a sample graph
import copy


initial_config = [[3,4,1],
                  [2,5,8],
                  [7,6,0]]
          
goal_config = [[1,2,3],
               [4,5,6],
               [7,8,0]]

def calculatePosition(actual):
    for x in range(len(actual)):
        for y in range(len(actual)):
            if actual[x][y] == 0:
                position = (x, y)
                return position
                

def moveUp(actual_config):
    print("moving up...")
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
    print("moving right...")
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
    print("moving down...")
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
    print("moving left...")
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

    """print("los sucesores son: ")
    for i in sucesores:
        for x in i:
            print(x)
        print("\n")"""
    return sucesores
    

def dfs_paths(start, goal):
    visitados = set()
    stack = [start]
    while stack:
        path = stack.pop()
        
        print("visitados ", visitados)
        print("el path antes de expandir es...")
        for i in path:
            print(i)

        if calculatePosition(path) not in visitados:
            sucesores = expandCurrentState(path)
            print(sucesores)
            for i in sucesores:
                stack.append(i)

        visitados.add(calculatePosition(path))


        if path == goal:
            print("goal reached")
            break
        """l = list(set(expandCurrentState(path)) - set(path))
        for next in sorted(l, reverse=True):           
            if next == goal:
                yield path + [next]
            else:
                stack.append((next, path + [next]))"""

dfs_paths(initial_config, goal_config)

#print (next(dfs_paths(initial_config, goal_config)))

"""print("calculating position...")
moveDown(initial_config)
for i in initial_config:
    print(i)

moveDown(initial_config)
for i in initial_config:
    print(i)

moveDown(initial_config)
for i in initial_config:
    print(i)"""