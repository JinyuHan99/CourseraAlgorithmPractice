# python3

from collections import namedtuple
import heapq

AssignedJob = namedtuple("AssignedJob", ["worker", "started_at"])


def assign_jobs(n_workers, jobs):
    # TODO: replace this code with a faster algorithm.
    result = []
    minheap=[]
    for i in range(n_workers):
        heapq.heappush(minheap,(0,i))
    for j in range(len(jobs)):
        top = heapq.heappop(minheap)
        result.append(AssignedJob(top[1],top[0]))
        heapq.heappush(minheap,(top[0]+jobs[j],top[1]))
    return result


def main():
    n_workers, n_jobs = map(int, input().split())
    jobs = list(map(int, input().split()))
    assert len(jobs) == n_jobs

    assigned_jobs = assign_jobs(n_workers, jobs)

    for job in assigned_jobs:
        print(job.worker, job.started_at)


if __name__ == "__main__":
    main()
