let T = Int(readLine()!)!

var D: [Int:Int] = [:]
D[0] = 0
D[1] = 1
D[2] = 2
D[3] = 4

func solution(_ N: Int) -> Int {
    
    if let answer = D[N] {
        return answer
    }
    
    D[N] = solution(N-1) + solution(N-2) + solution(N-3)
    
    return D[N]!
}

for i in 0..<T {
    
    let N = Int(readLine()!)!
    print( solution(N))
}
