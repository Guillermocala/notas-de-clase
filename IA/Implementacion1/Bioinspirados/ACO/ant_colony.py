#!/usr/bin/env python2
# -*- coding: utf-8 -*-

import os
from pheromonetrail import PheromoneTrail
from ant import Ant
import matplotlib.pyplot as plt
import time



def load_board():
    path = r'/Datos/reinas8.txt'
    separador = os.path.sep
    dir_actual = os.path.dirname(os.path.abspath(__file__))
    dir = separador.join(dir_actual.split(separador)[:-1])
    newPath = dir + path
    f = open(newPath, "r")
    board = []
    acu = 0
    print('Tablero Inicial:')
    for x in f.readlines():
        x = [int(x.replace('\n', '')) for x in x.split(',')]
        acu += 1
        board.append(x)
        for y in x:
            print("[",y, end='')
            print(' ]', end='')
        print('')
    #print('\nSolucion tablero:')
    return acu



def ant_colony(ants, generations, alpha, beta):
    last_pheromone_trail = None
    global global_best_ant
    for epoch in range(max_epochs):
        last_pheromone_trail = PheromoneTrail(last_pheromone_trail, EVAPORATION_FACTOR)
        pheromone_trails.append(last_pheromone_trail)
        ants = []
        for _ in range(ants_count):
            ant = Ant(problem_size, last_pheromone_trail)
            ants.append(ant)
        for ant in ants:
            ant.place_pheromone()
        best_ant = max(ants, key=lambda a: a.count_not_beating())
        best_ants.append(best_ant)
        if best_ant.count_not_beating() == problem_size:
            print("Solucion encontrada en la iteracion: ", epoch)
            global_best_ant = best_ant
            break
    else:
        global_best_ant = max(best_ants, key=lambda a: a.count_not_beating())

    epochs_needed = len(best_ants)
    print('Iteracciones: ', epochs_needed)
    return epochs_needed


def table():
    rows_arr = []
    for i in range(len(global_best_ant.queens_rows)):
        x = global_best_ant.queens_rows[i]
        row_arr = []
        for j in range(len(global_best_ant.queens_rows)):
            if j == global_best_ant.queens_rows[i]:
                row_arr.append('[ 1 ]')
            else:
                row_arr.append('[ 0 ]')
        rows_arr.append('' + ''.join(row_arr))
    print((''.join('\n')).join(rows_arr))


def plot():
    plt.plot([a.count_not_beating() for a in best_ants])
    plt.xlabel('Epochs')
    plt.ylabel('mejor numero de hormigas')
    plt.show()


problem_size = load_board()
ants_count = 80
max_epochs = 500
PheromoneTrail.INITIAL_PHEROMONE = 0.0001
Ant.ALPHA = 0.9
Ant.BETA = 2
Ant.MAX_PHEROMONE_AMOUNT = 2
EVAPORATION_FACTOR = 0.9
pheromone_trails = []
best_ants = []
global_best_ant = None



def promIterationsAndTime():
    promIterations = 0
    promTime = 0
    n = 10
    for _ in range(n):
        start = time.time()
        promIterations += ant_colony(ants_count, max_epochs, Ant.ALPHA, Ant.BETA)
        promTime += time.time() - start
        table()
    plot()
    print('Promedio Iteracciones: ', promIterations/n)
    print('Promedio Tiempo: ', promTime/n)

promIterationsAndTime()