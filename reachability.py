#Uses python3

import sys


def reach(adj, x, y):
    #write your code here
    visited = [False] * len(adj)
    def explore(vertice,y):
        for i in adj[vertice]:
            if not visited[i]:
                visited[i]=True
                if i==y:
                    return 1
                if explore(i,y)==1:
                    return 1
        return 0
    return explore(x,y)



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
    x, y = data[2 * m:]
    x, y = x - 1, y - 1
    print(reach(adj, x, y))
