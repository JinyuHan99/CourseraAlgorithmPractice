#Uses python3
import sys
import math
import heapq

def minimum_distance(x, y):
    distance_list = [float('infinity')]*len(x)
    distance_list[0]=0
    minheap=[]
    heapq.heappush(minheap,(0,0))
    visited=[False]*len(x)
    result = 0.0
    while minheap:
        mindist,source = heapq.heappop(minheap)
        if visited[source]:
            continue
        result += mindist
        for neighbor in [i for i in range(len(x)) if i != source]:
            edge_cost = math.sqrt((x[source]-x[neighbor])**2+(y[source]-y[neighbor])**2)
            if not visited[neighbor] and distance_list[neighbor]>edge_cost:
                distance_list[neighbor] = edge_cost
                heapq.heappush(minheap,(edge_cost,neighbor))
        visited[source] = True
    return result


if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    n = data[0]
    x = data[1::2]
    y = data[2::2]
    print("{0:.9f}".format(minimum_distance(x, y)))
