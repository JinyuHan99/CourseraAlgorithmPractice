#Uses python3

import sys
import heapq


def distance(adj, cost, s, t):
    #write your code here
    distances={vertex:float('infinity') for vertex in range(len(adj))}
    distances[s]=0
    minheap = []
    heapq.heappush(minheap,(0,s))
    visited=[False]*len(adj)

    while minheap:
        min_dist, vertex = heapq.heappop(minheap)
        if visited[vertex]:
            continue
        for neighbor,edge_cost in zip(adj[vertex],cost[vertex]):
            distance = distances[vertex]+edge_cost
            if distances[neighbor] > distance:
                distances[neighbor] = distance
                heapq.heappush(minheap,(distance,neighbor))
        visited[vertex]=True
    if distances[t] != float('infinity'):
        return distances[t]
    else:
        return -1


if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    n, m = data[0:2]
    data = data[2:]
    edges = list(zip(zip(data[0:(3 * m):3], data[1:(3 * m):3]), data[2:(3 * m):3]))
    data = data[3 * m:]
    adj = [[] for _ in range(n)]
    cost = [[] for _ in range(n)]
    for ((a, b), w) in edges:
        adj[a - 1].append(b - 1)
        cost[a - 1].append(w)
    s, t = data[0] - 1, data[1] - 1
    print(distance(adj, cost, s, t))
