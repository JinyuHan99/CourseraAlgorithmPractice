#Uses python3

import sys
from queue import Queue

def distance(adj, s, t):
    #write your code here
    n=len(adj)
    q = Queue()
    q.put((s,0))
    visited = [False] * n
    while not q.empty():
        temp,dist = q.get()
        if not visited[temp]:
            visited[temp]=True
            for i in adj[temp]:
                if not visited[i]:
                    q.put((i,dist+1))
            if temp == t:
                return dist
    return -1

if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    n, m = data[0:2]
    data = data[2:]
    edges = list(zip(data[0:(2 * m):2], data[1:(2 * m):2]))
    adj = [[] for _ in range(n)]
    for (a, b) in edges:
        adj[a - 1].append(b - 1)
        adj[b - 1].append(a - 1)
    s, t = data[2 * m] - 1, data[2 * m + 1] - 1
    print(distance(adj, s, t))
