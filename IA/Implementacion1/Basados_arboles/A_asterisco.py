import heapq
import sys
import time
import timeit
import numpy as np

goal_config = (1, 2, 3, 4, 5, 6, 7, 8, 0)

class Board(object):
    def __init__(self, board):
        """
        Initialize new board
        @param board is the current board state(tuple)
        @param g is the cost function
        @param h is the heuristic function
        @param f is g + h
        """
        self.board = board
        self.parent = None
        self.g = 0
        self.h = 0
        self.f = 0

class BestFirst(object):
    def __init__(self, start, goal):
        self.opened = []
        heapq.heapify(self.opened)
        self.expanded = set()
        self.start = Board(start)
        self.goal = Board(goal)

    def tupleToMatrix(self, data):
        res = [[data[0], data[1], data[2]],
               [data[3], data[4], data[5]],
               [data[6], data[7], data[8]]]
        return res

    def matrixToTuple(self, data):
        a = list()
        for item in data:
            for i in item:
                a.append(i)
        b = tuple(a)
        return b

    def calculatePosition(self, actual):
        for x in range(len(actual)):
            for y in range(len(actual)):
                if actual[x][y] == 0:
                    position = (x, y)
                    return position

    #heuristica fichas descolocadas
    def get_heuristicMisplaced(self, board):
        value = 0
        board_matrix = self.tupleToMatrix(board.board)
        goal_matrix = self.tupleToMatrix(self.goal.board)
        for i in range(len(board_matrix)):
            for j in range(len(board_matrix)):
                if (board_matrix[i][j] != goal_matrix[i][j]) and (board_matrix[i][j] != 0):
                    value += 1
        return value

    #ayuda a calcular distancia manhattan
    def getGoalPosition(self, board_tile):
        goal_matrix = self.tupleToMatrix(self.goal.board)
        for i in range(len(goal_matrix)):
            for j in range(len(goal_matrix)):
                if goal_matrix[i][j] == board_tile:
                    return i, j

    #heuristica distancia manhattan
    def get_heuristicManhattan(self, board):
        value = 0
        board_matrix = self.tupleToMatrix(board.board)
        for i in range(len(board_matrix)):
            for j in range(len(board_matrix)):
                current_tile = board_matrix[i][j]
                if board_matrix[i][j] != 0:
                    x1 = i
                    y1 = j
                    x2, y2 = self.getGoalPosition(current_tile)
                    manhattan = abs(x1 - x2) + abs(y1 - y2)
                    value += manhattan
        return value
    
    def get_heuristicEuclidean(self, board):
        value = 0
        board_matrix = self.tupleToMatrix(board.board)
        for i in range(len(board_matrix)):
            for j in range(len(board_matrix)):
                current_tile = board_matrix[i][j]
                if board_matrix[i][j] != 0:
                    x1 = i
                    y1 = j
                    x2, y2 = self.getGoalPosition(current_tile)
                    res = (pow((x1 - x2), 2) - pow((y1 - y2), 2))
                    print("res: ", res)
                    euclidean = np.linalg.norm((x1 - y1) - (x2 - y2))
                    value += euclidean
        return value


    def movements(self, actual_config, type_movement):
        respuesta_matrix = []
        actual_matrix = self.tupleToMatrix(actual_config)
        actual_position = self.calculatePosition(actual_matrix)
        x = actual_position[0]
        y = actual_position[1]
        #moveDown
        if type_movement == 1:
            if x == 0:
                return -1
            else:
                actual_matrix[x][y], actual_matrix[x - 1][y] = actual_matrix[x - 1][y], 0
                respuesta_tuple = self.matrixToTuple(actual_matrix)
                return respuesta_tuple
        #moveLeft
        if type_movement == 2:
            if y == (len(actual_matrix) - 1):
                return -1
            else:
                actual_matrix[x][y], actual_matrix[x][y + 1] = actual_matrix[x][y + 1], 0
                respuesta_tuple = self.matrixToTuple(actual_matrix)
                return respuesta_tuple
        #moveUp
        if type_movement == 3:
            if x == (len(actual_matrix) - 1):
                return -1
            else:
                actual_matrix[x][y], actual_matrix[x + 1][y] = actual_matrix[x + 1][y], 0
                respuesta_tuple = self.matrixToTuple(actual_matrix)
                return respuesta_tuple
        #moveRight
        if type_movement == 4:
            if y == 0:
                return -1
            else:
                actual_matrix[x][y], actual_matrix[x][y - 1] = actual_matrix[x][y - 1], 0
                respuesta_tuple = self.matrixToTuple(actual_matrix)
                return respuesta_tuple
        #convertimos y retornamos

    def expandCurrentState(self, actual_config):
        sucesores = []
        res = Board(self.movements(actual_config, 3))
        if res.board != -1:
            sucesores.append(res)
        res = Board(self.movements(actual_config, 4))
        if res.board != -1:
            sucesores.append(res)
        res = Board(self.movements(actual_config, 1))
        if res.board != -1:
            sucesores.append(res)
        res = Board(self.movements(actual_config, 2))
        if res.board != -1:
            sucesores.append(res)
        return sucesores

    def returnPath(self):
        camino = [self.start]
        board = self.goal
        while board.parent != self.start:
            board = board.parent
            camino.insert(1, board)
        return camino
    
    def update_board(self, adj, board):
        """
        Update adjacent board
        @param adj adjacent board to current board
        @param board current board being processed
        """
        adj.g = board.g + 1
        adj.h = self.get_heuristicManhattan(adj)
        adj.parent = board
        adj.f = adj.h + adj.g

    def process(self):
        # add starting board to open heap queue
        count = 0
        global iteracion
        iteracion = 0
        global max_queue
        max_queue = 0
        heapq.heappush(self.opened, (self.start.f, count, self.start))

        while len(self.opened):
            if max_queue < len(self.opened):
                max_queue = len(self.opened)
            iteracion += 1
            print("iteracion: ", iteracion)
            # pop board from heap queue 
            f, c, board = heapq.heappop(self.opened)

            # if ending board, display found path
            if board.board == self.goal.board:
                self.goal.parent = board
                print("\t\tGOAL REACHED")
                return self.returnPath()
            # get adjacent boards for board
            # add board to expanded list so we don't process it twice
            self.expanded.add(board)
            adj_boards = self.expandCurrentState(board.board)
            for adj_board in adj_boards:
                if adj_board not in self.expanded:
                    #print("adj board: ", adj_board.board)
                    if (adj_board.f, adj_board) in self.opened:
                        # if adj board in open list, check if current path is
                        # better than the one previously found
                        # for this adj board.
                        if adj_board.g > board.g + 1:
                            #print("update board 1: ", adj_board.board)
                            self.update_board(adj_board, board)
                    else:
                        #print("update board 1: ", adj_board.board)
                        self.update_board(adj_board, board)
                        # add adj board to open list
                        count = count + 1
                        heapq.heappush(self.opened, (adj_board.f, count, adj_board))

def showLikeMatrix(data):
    res = ""
    for i in range(len(data)):
        res += str(data[i])
        if i == 2 or i == 5 or i == 8:
            res += "\n"
    return res

def openFile(ruta):
    temp = list()
    with open(ruta) as f:
        for line in f.readlines():
            for i in line.split(","):
                temp.append(int(i))
    res = tuple(temp)
    return res

def main():
    initial_config = openFile("./configs/config.txt")
    a = BestFirst(initial_config, goal_config)
    init_time = timeit.default_timer()
    respuesta = a.process()
    end_time = timeit.default_timer()
    execution_time = end_time - init_time
    for item in respuesta:
        print(showLikeMatrix(item.board))
    print("\t\tEstadisticas --- A*")
    print("\tTiempo de ejecucción fue de: ", format(execution_time, '.8f'))
    print("\tEl camino solucion consta de ", len(respuesta), " pasos.\n")
    print("\t\tMemory info...")
    print("\tTamaño maximo de cola: ", max_queue)
    print("\tNum nodos expandidos: ", iteracion)

if __name__ == '__main__':
    main()