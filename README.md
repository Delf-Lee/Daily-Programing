# Daily-Programing (DP)

## Question

### DP001 (매일프로그래밍 - 실리콘밸리 패키지 문제14)
문자열 배열(string array)이 주어지면, 제일 긴 공통된 접두사(prefix)의 길이를 찾으시오.

- Input: [“apple”, “apps”, “ape”]  
output: 2 // “ap”
- Input: [“hawaii”, “happy”]  
Output: 2 // “ha”
- Input: [“dog”, “dogs”, “doge”]  
Output: 3 // “dog”

### DP002 (매일프로그래밍 - 실리콘밸리 패키지 문제13)
정수 배열(int array)과 정수 N이 주어지면, N번째로 큰 배열 원소를 찾으시오.

- Input: [-1, 3, -1, 5, 4], 2  
Output: 4
- Input: [2, 4, -2, -3, 8], 1  
Output: 8
- Input: [-5, -3, 1], 3  
Output: -5

### DP003 (매일프로그래밍 - 실리콘밸리 패키지 문제12)
정수로된 배열이 주어지면, 각 원소가 자신을 뺀 나머지 원소들의 곱셈이 되게하라.
단, 나누기 사용 금지, O(n) 시간복잡도

- input: [1, 2, 3, 4, 5]  
output: [120, 60, 40, 30, 24]

### DP004 (매일프로그래밍 - 실리콘밸리 패키지 문제11)
길이가 같은 두 문자열(string) A 와 B가 주어지면, A 가 B 로 1:1 암호화 가능한지 찾으시오.

예제)
- Input: “EGG”, “FOO”  
Output: True // E->F, G->O
- Input: “ABBCD”, “APPLE”  
Output: True // A->A, B->P, C->L, D->E
- Input: “AAB”, “FOO”  
Output: False

### DP005 (매일프로그래밍 - 실리콘밸리 패키지 문제10)
String이 주어지면, 중복된 char가 없는 가장 긴 서브스트링 (substring)의 길이를 찾으시오.

예제)
- Input: “aabcbcbc”  
Output: 3 // “abc”
- Input: “aaaaaaaa”  
Output: 1 // “a”
- Input: “abbbcedd”
Output: 4 // “bced”

### DP006 (매일 프로그래밍 - 실리콘밸리 패키지 문제08)
정수 배열(int array)이 주어지면 두번째로 큰 값을 프린트하시오.

예제)
- Input: [10, 5, 4, 3, -1]  
Output: 5
- Input: [3, 3, 3]  
Output: Does not exist.

### DP007 (매일프로그래밍 - 실리콘밸리 패키지 문제09)
정수 배열(int array)이 주어지면 0이 아닌 정수 순서를 유지하며 모든 0을 배열 오른쪽 끝으로 옮기시오. 단, 시간복잡도는 O(n), 공간복잡도는 O(1)여야 합니다.

예제)
- Input: [0, 5, 0, 3, -1]  
Output: [5, 3, -1, 0, 0]
- Input: [3, 0, 3]  
Output: [3, 3, 0]

### DP008 (매일프로그래밍 - 문제07)
주어진 string 에 모든 단어를 거꾸로 하시오.

(예제)
- Input: “abc 123 apple”  
Output: “cba 321 elppa”

### DP009 (매일프로그래밍 - 문제06)
간격(interval)로 이루어진 배열이 주어지면, 겹치는 간격 원소들을 합친 새로운 배열을 만드시오. 간격은 시작과 끝으로 이루어져 있으며 시작은 끝보다 작거나 같습니다.

(예제)
- Input: {{2,4}, {1,5}, {7,9}}  
Output: {{1,5}, {7,9}}
- Input: {{3,6}, {1,3}, {2,4}}  
Output: {{1,6}}
