# Taken from: https://eddmann.com/posts/depth-first-search-and-breadth-first-search-in-python/
# a sample graph

config = [[2,4,3],
          [7,1,6],
          [0,5,8]]
          
goal = [[1,2,3],
        [4,5,6],
        [7,8,0]]

def calculatePosition(actual):
    for x in range(len(actual)):
        for y in range(len(actual)):
            if actual[x][y] == 0:
                position = [x, y]
                return position
                

def moveUp(actual_config):
    print("moving up...")
    actual_position = calculatePosition(actual_config)
    x = actual_position[0]
    y = actual_position[1]
    if x == 0:
        print("cant move")
    else:
        #data = actual_config[x - 1][0]
        #actual_config[x - 1][0] = 0
        #actual_config[x][y] = data
        actual_config[x][y], actual_config[x - 1][0] = actual_config[x - 1][0], 0

def moveRight():
    print("moving right...")
    actual_position = calculatePosition(actual_config)
    x = actual_position[0]
    y = actual_position[1]
    if x == len(actual_config):
        print("cant move")
    else:
        data = actual_config[x - 1][0]
        actual_config[x - 1][0] = 0
        actual_config[x][y] = data
        #actual_config[x][y], actual_config[x - 1][0] = actual_config[x - 1][0], 0


def moveDown():
    pass

def moveLeft():
    pass


def dfs_paths(graph, start, goal):
    stack = [(start, [start])]
    while stack:
        (vertex, path) = stack.pop()
        print ('path: ' , path)
        l = list(set(graph[vertex]) - set(path))
        for next in sorted(l, reverse=True):           
            if next == goal:
                yield path + [next]
            else:
                stack.append((next, path + [next]))


#print (next(dfs_paths(graph, 'A', 'L')))

print("calculating position...")
print(calculatePosition(config))

for i in config:
    print(i)

moveUp(config)

for i in config:
    print(i)

