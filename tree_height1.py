# python3

import sys
import threading


def compute_height(n, parents):
    # Replace this code with a faster implementation
    height_record = [0]*n
    def height(vertex):
        if parents[vertex]==-1:
            return 1
        if height_record[vertex] !=0:
            return height_record[vertex]
        height_record[vertex] = height(parents[vertex])+1
        return height_record[vertex]
    for i in range(n):
        height(i)
    return max(height_record)


def main():
    n = int(input())
    parents = list(map(int, input().split()))
    print(compute_height(n, parents))


# In Python, the default limit on recursion depth is rather low,
# so raise it here for this problem. Note that to take advantage
# of bigger stack, we have to launch the computation in a new thread.
sys.setrecursionlimit(10**7)  # max depth of recursion
threading.stack_size(2**27)   # new thread will get stack of such size
threading.Thread(target=main).start()
