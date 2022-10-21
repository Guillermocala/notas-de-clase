import heapq
import sys
import time
import timeit


class Cell(object):
    def __init__(self, x, y, reachable):
        """
        Initialize new cell

        @param x cell x coordinate
        @param y cell y coordinate
        @param reachable is cell reachable? not a wall?
        """
        self.reachable = reachable
        self.x = x
        self.y = y
        self.parent = None
        self.g = 0
        self.h = 0
        self.f = 0

class BestFirst(object):
    def __init__(self):
        self.opened = []
        heapq.heapify(self.opened)
        self.closed = set()
        self.cells = []
        self.grid_height = 6
        self.grid_width = 6

    def init_grid(self):
        walls = ((0, 3), (0, 4), (1, 5), (2, 0), (2, 2), (2, 3), (2, 4), 
                 (3, 0), (3, 2), (3, 3), (4, 0), (5, 0), (5, 1), (5, 2), (5, 4))
        for x in range(self.grid_width):
            for y in range(self.grid_height):
                if (x, y) in walls:
                    reachable = False
                else:
                    reachable = True
                self.cells.append(Cell(x, y, reachable))
        self.start = self.get_cell(0, 0)
        self.end = self.get_cell(5, 5)

    def get_heuristic(self, cell):
        """
        Compute the heuristic value H for a cell: distance between
        this cell and the ending cell multiply by 10.

        @param cell
        @returns heuristic value H
        """
        return (abs(cell.x - self.end.x) + abs(cell.y - self.end.y))

    def get_cell(self, x, y):
        """
        Returns a cell from the cells list

        @param x cell x coordinate
        @param y cell y coordinate
        @returns cell
        """
        return self.cells[x * self.grid_height + y]

    def get_adjacent_cells(self, cell):
        """
        Returns adjacent cells to a cell. Clockwise starting
        from the one on the right.

        @param cell get adjacent cells for this cell
        @returns adjacent cells list 
        """
        cells = []
        if cell.y < self.grid_height-1:
            cells.append(self.get_cell(cell.x, cell.y+1)) #derecha
        if cell.x < self.grid_width-1:
            cells.append(self.get_cell(cell.x+1, cell.y)) #abajo
        if cell.y > 0:
            cells.append(self.get_cell(cell.x, cell.y-1)) #Izquierda
        if cell.x > 0:
            cells.append(self.get_cell(cell.x-1, cell.y)) #arriba
       
        return cells

    def display_path(self):
        cell = self.end
        while cell.parent is not self.start:
            cell = cell.parent
            print('path: cell: %d,%d' % (cell.x, cell.y))

    def compare(self, cell1, cell2):
        """
        Compare 2 cells F values

        @param cell1 1st cell
        @param cell2 2nd cell
        @returns -1, 0 or 1 if lower, equal or greater
        """
        if cell1.f < cell2.f:
            return -1
        elif cell1.f > cell2.f:
            return 1
        return 0
    
    def update_cell(self, adj, cell):
        """
        Update adjacent cell

        @param adj adjacent cell to current cell
        @param cell current cell being processed
        """
        adj.g = cell.g + 5
        adj.h = self.get_heuristic(adj)
        adj.parent = cell
        adj.f = adj.h 

    def __lt__(self, other):
        return self.intAttribute < other.intAttribute

    def process(self):
        # add starting cell to open heap queue
        count = 0
        max_len = 0
        
        heapq.heappush(self.opened, (self.start.f, count, self.start))

        while len(self.opened):
            # pop cell from heap queue 
            f, c, cell = heapq.heappop(self.opened)
            # add cell to closed list so we don't process it twice
            self.closed.add(cell)
            # if ending cell, display found path
            if cell is self.end:
                self.display_path()
                print('Expandio % d nodos, y el máximo tamaño alcanzado por la cola fue %d' % (len(self.closed), max_len))
                break
            # get adjacent cells for cell
            adj_cells = self.get_adjacent_cells(cell)
            
            
            for adj_cell in adj_cells:
                if adj_cell.reachable and adj_cell not in self.closed:
                    if (adj_cell.f, adj_cell) in self.opened:
                        # if adj cell in open list, check if current path is
                        # better than the one previously found
                        # for this adj cell.
                        
                        if adj_cell.g > cell.g + 5:
                            self.update_cell(adj_cell, cell)
                            
                    else:
                        self.update_cell(adj_cell, cell)
                        # add adj cell to open list
                        count = count + 1
                        heapq.heappush(self.opened, (adj_cell.f, count, adj_cell))
            
            if max_len < len(self.opened) :
                max_len = len(self.opened)
                       

a = BestFirst()
a.init_grid()

ini_time = timeit.default_timer()
a.process()
stop_time = timeit.default_timer()
end_time = stop_time - ini_time
print("running_time: ",format(end_time, '.8f'))

