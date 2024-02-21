#!/usr/bin/python3

import sys, threading

sys.setrecursionlimit(10**7) # max depth of recursion
threading.stack_size(2**27)  # new thread will get stack of such size

def IsBinarySearchTree(tree):
  # Implement correct algorithm here
  if not tree:
    return True
  lower = float('-inf')
  def recur(node_idx):
    nonlocal lower
    if node_idx == -1:
      return True
    node_key, left_idx, right_idx = tree[node_idx]
    left = recur(left_idx)
    if node_key <= lower:
      return False
    lower = node_key
    right = recur(right_idx)
    return left and right
  return recur(0)

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
