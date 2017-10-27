T = int(input())

D = [None]*12
D[0:4] = [0, 1, 2, 4]

def solution(N) :

    if D[N] :
        return D[N]

    D[N] = solution(N-1) + solution(N-2) + solution(N-3)


    return D[N]


for i in range(T):
    N = int(input())
    print(solution(N))
