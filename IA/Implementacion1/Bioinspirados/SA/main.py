import os
import sys
import pandas as pd

def load_board():
    path = r'/Datos/reinas8.txt'
    separador = os.path.sep
    dir_actual = os.path.dirname(os.path.abspath(__file__))
    dir = separador.join(dir_actual.split(separador)[:-1])
    newPath = dir + path
    f = open(newPath, "r")
    board = []
    vect = []
    print('Tablero Inicial:')
    for x in f.readlines():
        x = [int(x.replace('\n', '')) for x in x.split(',')]
        board.append(x)
        for y in x:
            print("[",y, end='')
            print(' ]', end='')
        print('')
    #print('\nSolucion tablero:')

    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j] == 1:
                vect.append(j)
    
    return vect


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    load_board()
