import copy
import numpy

numberNodesGenerated = 0
numberNodesExpanded = 0

class Node:
    def __init__(self, data, parent, gval, hval, fval) -> None:
        self.data = data
        self.parent = parent
        self.gval = gval
        self.hval = hval
        self.fval = fval
    
    '''Function to generate successors of a current position'''
    def generateSuccessors(self):
        i,j = self.findBlankSpace('0')
        children = []
        '''Generate successors based on the position of the blank tile'''
        if(i+1 < len(self.data)):
            children.append(self.generateChildNode(self.data, i, j, i+1, j))
        if(j+1 < len(self.data)):
            children.append(self.generateChildNode(self.data, i, j, i, j+1))
        if(i-1 >= 0):
            children.append(self.generateChildNode(self.data, i, j, i-1, j))
        if(j-1 >= 0):
            children.append(self.generateChildNode(self.data, i, j, i, j-1))
        return children
    
    '''Find the position of blank tile'''
    def findBlankSpace(self, space):
        data = self.data
        for i in range(0,len(self.data)):
            for j in range(0, len(self.data)):
                if(data[i][j] == space):
                    return i,j
    
    def generateChildNode(self, data, old_x, old_y, new_x, new_y):
        copy_data = copy.deepcopy(data)
        temp = copy_data[old_x][old_y]
        copy_data[old_x][old_y] = data[new_x][new_y]
        copy_data[new_x][new_y] = temp
        child = Node(copy_data, None, self.gval+1, 0, 0)
        return child
   
class Puzzle:
    def __init__(self, size) -> None:
        self.size = size
        self.frontier = []
        self.expanded = []
    
    def getInput(self):
        matrix = []
        for i in range(0,self.size):
            temp = input().split(" ")
            matrix.append(temp)
        return matrix
    
    def printArr(self,data):
        for i in range(0,len(data)):
                print(data[i])

    def getIndex(self, current):
        for index, node in enumerate(self.frontier):
            if(numpy.array_equal(current.data,node.data)):
                return index
        return None

    '''Function to check if the problem is solvable based on initial and current states'''
    def checkSolvability(self,initial,goal):
        initialArray = numpy.array(initial).flatten()
        goalArray = numpy.array(goal).flatten()
        initialStateParity = self.checkParity(initialArray)
        goalStateParity = self.checkParity(goalArray)
        if initialStateParity == goalStateParity:
            return True
        else:
            return False
    
    def checkParity(self,state):
        noOfInversions = 0
        state = state[state != "0"]
        for i in range(9):
            for j in range(i+1,8):
                if state[i] > state[j]:
                    noOfInversions = noOfInversions + 1
        if noOfInversions % 2 == 0:
            return "even"
        else:
            return "odd"

    def solve(self):
        '''Get initial and goal state as well as heuristic function choice from the user'''
        print("Enter the initial state:")
        initial = self.getInput()
        print("Enter the goal state:")
        goal = self.getInput()
        '''Check if the problem is solvable'''
        isSolvable = self.checkSolvability(initial,goal)
        if not isSolvable:
            return None
        print("Enter the heuristic: 1.Misplaced Tiles 2.Manhattan Distance :")
        heuristicVal = input()
        if heuristicVal == "1":
            heuristicFunction = HeuristicMisplacedTiles(initial,goal)
        else:
            heuristicFunction = HeuristicManhattan(initial,goal)
        '''Initialize the problem'''
        initial = Node(initial, None, 0 , 0, 0)
        initial.hval = heuristicFunction.calculateHval(initial.data)
        initial.fval = initial.hval + initial.gval
        '''Insert the initial node in the frontier list'''
        self.frontier.append(initial)
        numberNodesGenerated = 1
        while(len(self.frontier) > 0):
            '''Take out the node from the frontier with the minimum fval'''
            current = self.frontier.pop(0)
            self.expanded.append(current.data)
            '''Check if the goal state is reached'''
            if(numpy.array_equal(current.data,goal)):
                print("Reached Goal")
                numberNodesGenerated = len(self.frontier) + len(self.expanded)
                print("No of nodes Generated = ", numberNodesGenerated)
                numberNodesExpanded = len(self.expanded)
                print("No of nodes Expanded = ", numberNodesExpanded)
                print("No of steps required for optimal solution:", current.gval)
                return current
            '''Generate successors of the current node'''
            for child in current.generateSuccessors():
                '''Check if the successor node is already explored'''
                if(not(any(numpy.array_equal(child.data, x) for x in self.expanded))):
                    child.hval = heuristicFunction.calculateHval(child.data)
                    child.fval = child.hval + child.gval
                    child.parent = current
                    index = self.getIndex(child)
                    '''Check if the frontier has the same node with greater fval, if yes then replace the node in frontier'''
                    if(index != None):
                        if(current.fval < self.frontier[index].fval):
                            self.frontier[index] = child
                    else:
                        '''Add the successor in the frontier list'''
                        self.frontier.append(child)  
            '''Sort the frontier list according to fval'''
            self.frontier.sort(key = lambda data:data.fval, reverse= False)
        return None


class HeuristicMisplacedTiles:
    def __init__(self, initial, goal) -> None:
        self.initial = initial
        self.goal = goal

    '''Heuristic function to calculate misplaced tiles'''
    def calculateHval(self, current):
        misplacedTilesCount = 0
        for i in range(3):
            for j in range(3):
                if current[i][j] != self.goal[i][j] and (current[i][j] != "0"):
                    misplacedTilesCount +=1
        return misplacedTilesCount

class HeuristicManhattan:
    def __init__(self, current, goal) -> None:
        self.current = current
        self.goal = goal

    def getGoalTileCoordinates(self,tile):
        for i in range(3):
            for j in range(3):
                if(self.goal[i][j] == tile):
                    return i,j

    '''Heuristic function to calculate Manhattan distance'''
    def calculateHval(self, current):
        sum = 0
        for i in range(3):
            for j in range(3):
                currentTile = current[i][j]
                if current[i][j] != "0":
                    x1 = i
                    y1 = j
                    x2,y2 = self.getGoalTileCoordinates(currentTile)
                    val = abs(x1-x2) + abs(y1-y2)
                    sum = sum + val
        return sum

puzzle = Puzzle(3)
solution = puzzle.solve()
if solution == None:
    print("The problem is not solvable")
else:
    print("Best Path from initial to Goal State:\n")
    solutionPath = []
    while(solution != None):
        solutionPath.append(solution.data)
        solution = solution.parent
    solutionPath.reverse()
    while(len(solutionPath) > 1):
        path = solutionPath.pop(0)
        puzzle.printArr(path)
        print(" ")
        print("       ||      ")
        print("       ||      ")
        print("       \/      ")
        print(" ")  
    path = solutionPath.pop(0)     
    puzzle.printArr(path)
print(" ")