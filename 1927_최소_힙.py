import heapq
import sys

n = int(sys.stdin.readline())

heap = []

for _ in range(n):
    command = int(sys.stdin.readline())

    if command == 0:
        if heap:
            print(heapq.heappop(heap))
        else:
            print(0)
        continue
    heapq.heappush(heap, command)
