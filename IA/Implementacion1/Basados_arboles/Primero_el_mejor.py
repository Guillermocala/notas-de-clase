import heapq
import sys
import time
import timeit

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
        self.boards = []
        self.start = Board(start)
        self.goal = Board(goal)

    def get_heuristic(self, board):
        value = 0
        for i in range(len(self.goal.board)):
            if board[i] != self.goal.board[i]:
                value += 1
        return value

    def calculatePosition(self, actual):
        for x in range(len(actual)):
            for y in range(len(actual)):
                if actual[x][y] == 0:
                    position = (x, y)
                    return position

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

    def display_path(self):
        board = self.goal
        print("display board", board.board)
        print("display parent", board.parent)
        while board.parent != self.start:
            board = board.parent
            print('path: board: %d,%d' % (board.board))

    def compare(self, board1, board2):
        """
        Compare 2 boards F values

        @param board1 1st board
        @param board2 2nd board
        @returns -1, 0 or 1 if lower, equal or greater
        """
        if board1.f < board2.f:
            return -1
        elif board1.f > board2.f:
            return 1
        return 0
    
    def update_board(self, adj, board):
        """
        Update adjacent board

        @param adj adjacent board to current board
        @param board current board being processed
        """
        adj.g = board.g + 5
        adj.h = self.get_heuristic(adj.board)
        adj.parent = board
        adj.f = adj.h 

    def __lt__(self, other):
        return self.intAttribute < other.intAttribute

    def process(self):
        # add starting board to open heap queue
        count = 0
        max_len = 0
        heapq.heappush(self.opened, (self.start.f, count, self.start))
        
        iteracion = 0
        while len(self.opened):
            iteracion += 1
            print("iteracion: ", iteracion)
            # pop board from heap queue 
            f, c, board = heapq.heappop(self.opened)
            # add board to expanded list so we don't process it twice
            self.expanded.add(board)
            # if ending board, display found path

            print("path: ", board.board)
            if board.parent != None:
                print("path parent", board.parent.board)
            if board.board == self.goal.board:
                print("\t\tGOAL REACHED")
                self.display_path()
                break
            # get adjacent boards for board
            adj_boards = self.expandCurrentState(board.board)
            
            for adj_board in adj_boards:
                if adj_board not in self.expanded:
                    if (adj_board.f, adj_board) in self.opened:
                        # if adj board in open list, check if current path is
                        # better than the one previously found
                        # for this adj board.
                        
                        if adj_board.g > board.g + 5:
                            self.update_board(adj_board, board)
                    else:
                        self.update_board(adj_board, board)
                        # add adj board to open list
                        count = count + 1
                        heapq.heappush(self.opened, (adj_board.f, count, adj_board))
            
            if max_len < len(self.opened):
                max_len = len(self.opened)
                       
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
    a.process()

if __name__ == '__main__':
    main()