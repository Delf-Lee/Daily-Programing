# Daily-Programing

## Question

### DP001
문자열 배열(string array)이 주어지면, 제일 긴 공통된 접두사(prefix)의 길이를 찾으시오.

- Input: [“apple”, “apps”, “ape”]  
output: 2 // “ap”
- Input: [“hawaii”, “happy”]  
Output: 2 // “ha”
- Input: [“dog”, “dogs”, “doge”]  
Output: 3 // “dog”

### DP002
정수 배열(int array)과 정수 N이 주어지면, N번째로 큰 배열 원소를 찾으시오.

- Input: [-1, 3, -1, 5, 4], 2  
Output: 4
- Input: [2, 4, -2, -3, 8], 1  
Output: 8
- Input: [-5, -3, 1], 3  
Output: -5

### DP003
정수로된 배열이 주어지면, 각 원소가 자신을 뺀 나머지 원소들의 곱셈이 되게하라.
단, 나누기 사용 금지, O(n) 시간복잡도

- input: [1, 2, 3, 4, 5]  
output: [120, 60, 40, 30, 24]
