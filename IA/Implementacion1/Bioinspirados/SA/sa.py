import math
from random import randint, random
import time
from main import *
from matplotlib.pyplot import *


class NQueensSimulatedAnnealing(object):

    def __init__(self, t0, tf, n, kmax, alpha = 0.95, graphical = False):
        print("\nEnfriamiento simulado:")
        start = time.time()
        self.t0 = t0
        self.n = len(n)
        self.alpha = alpha
        self.tf = tf
        s = n
        best_eval = self.f_eval(s)
        self.evals = [ best_eval ]
        k = 0
        
        while t_0 > tf and k < kmax:
            new_s = self.neighbour(s)
            evaln = self.f_eval(new_s)
            if self.probability(best_eval, evaln, k, self.alpha) > random():
                s = new_s
                best_eval = evaln
            self.evals.append(best_eval)
            if evaln == 0:
                break
            self.t_0 = self.temp(k, self.alpha)
            k+=1
        self.print_state(s)
        end = time.time()
        print(f'Tiempo computacional: {end - start} segundos')
        print(f'Número de iteraciones: {len(self.evals)}')
        if graphical:
            plot(self.evals)
            ylim([min(self.evals)-1, max(self.evals) + 1])
            xlabel('Iteraciones')
            ylabel('Número de ataques')
            show()

    def f_eval(self, s):
        beats = [ set() for _ in range(self.n) ]
        for col in range(self.n):
            for other_col in range(self.n):
                if col == other_col:
                    continue
                if s[col] == s[other_col] or abs(other_col - col) == abs(s[other_col] - s[col]):
                    beats[min(col, other_col)].add(max(col, other_col))
        beat_pairs = sum([ len(x) for x in beats ])
        return beat_pairs

    def probability(self, s_energy, new_s_energy, k, alpha):
        t = self.temp(k, alpha)
        if s_energy - new_s_energy < 0:
            return math.exp((s_energy - new_s_energy) / t)
        return 1

    def temp(self, k, alpha=0.95):
        return math.pow(alpha, k + 1) * self.t0

    def neighbour(self, s):
        new_s = list(s)
        col_to_move = randint(0, self.n - 1)
        while True:
            new_pos = randint(0, self.n - 1)
            if new_pos != s[col_to_move]:
                break
        new_s[col_to_move] = new_pos
        return new_s

    def print_state(self, s):
        if self.n < 20:
            rows_arr = []
            for row in range(self.n):
                row_arr = []
                for col in range(self.n):
                    if s[col] == row:
                        row_arr.append('[ 1 ]')
                    else:
                        row_arr.append('[ 0 ]')
                rows_arr.append('' + ''.join(row_arr))
            print((''.join('\n')).join(rows_arr))
        else:
            print(', '.join([str(x) for x in s ]))

def promAndIterations(t_0, tf, n, kmax, alpha):
    promIterations = 0
    promTime = 0
    for _ in range(10):
        timeStart = time.time()
        promIterations += len(NQueensSimulatedAnnealing(t_0, tf, n, kmax, alpha).evals)
        promTime = promTime + (time.time() - timeStart)
    promIterations /= 10
    promTime /= 10
    print(f'\n\nPromedio de iteraciones: {promIterations}')
    print(f'Promedio de tiempo computacional: {promTime} segundos')
    NQueensSimulatedAnnealing(t_0, tf, n, kmax, alpha, True)
# parametros
t_0 = 100000 # temp inicial
tf = 0.0001 # temp final
n = load_board() # vector de las reinas del tablero
kmax = 9999 # numero maximo de iteraciones
alpha = 0.99 # factor de enfriamiento
promAndIterations(t_0, tf, n, kmax, alpha)

