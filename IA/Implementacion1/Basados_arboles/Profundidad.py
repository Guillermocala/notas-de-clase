# Taken from: https://eddmann.com/posts/depth-first-search-and-breadth-first-search-in-python/
# a sample graph

graph = {'A': ['B', 'C', 'D'],
         'B': ['A', 'E', 'F'],
         'C': ['A', 'G', 'H'],
         'D': ['A', 'G', 'H'],
         'E': ['B', 'I'],
         'F': ['B', 'I', 'K'],
         'G': ['C', 'D', 'K'],
         'H': ['C', 'D', 'L'],
         'I': ['E','F', 'J', 'L'],
         'J': ['I', 'K', 'L'],
         'K': ['F', 'G', 'J', 'L'],
         'L': ['H', 'I', 'K']}

config = [[2,4,3],
          [7,1,6],
          [0,5,8]]
          
goal = [[1,2,3],
        [4,5,6],
        [7,8,0]]

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


print (next(dfs_paths(graph, 'A', 'L')))

