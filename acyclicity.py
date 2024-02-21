# Uses python3

import sys

def acyclic(adj):
    n=len(adj)
    visited = [0] * n
    def dfs(v):
        visited[v] = 1
        for i in adj[v]:
            if visited[i] == 0:
                if dfs(i) == 1:
                    return 1
            elif visited[i] == 1:
                return 1
        visited[v] =-1

    for i in range(n):
        if visited[i]==0:
            if dfs(i)==1:
                return 1
    return 0

if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    # with open('input.txt', 'r') as file:
    #     input_data = file.read()
    # data = list(map(int, input_data.split()))
    # print(data)

    n, m = data[0:2]
    data = data[2:]
    edges = list(zip(data[0:(2 * m):2], data[1:(2 * m):2]))
    adj = [[] for _ in range(n)]
    for (a, b) in edges:
        adj[a - 1].append(b - 1)
    # print(adj)
    print(acyclic(adj))