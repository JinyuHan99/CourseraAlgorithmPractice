#!/usr/bin/python3

import sys, threading

sys.setrecursionlimit(10**7) # max depth of recursion
threading.stack_size(2**27)  # new thread will get stack of such size

def IsBinarySearchTree(tree):
  # Implement correct algorithm here
  if not tree:
    return True
  lower = float('-inf')
  upper = float('inf')
  def helper(node_idx,lower,upper):
    if node_idx == -1:
      return True
    node_key, left_idx, right_idx = tree[node_idx]
    if node_key < lower or node_key >= upper:
      return False
    return helper(left_idx,lower,node_key) and helper(right_idx,node_key,upper)
  return helper(0,lower,upper)



def main():
  nodes = int(sys.stdin.readline().strip())
  tree = []
  for i in range(nodes):
    tree.append(list(map(int, sys.stdin.readline().strip().split())))
  if IsBinarySearchTree(tree):
    print("CORRECT")
  else:
    print("INCORRECT")

threading.Thread(target=main).start()
