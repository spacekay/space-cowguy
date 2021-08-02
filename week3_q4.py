# 두 개의 수 입력 받음
a = int(input("첫 번째 수 입력 : "))
b = int(input("두 번째 수 입력 : "))

# 소수 여부를 판별할 bool type list 초기화
primes = [True]

# 소수 개수를 측정할 counter variable 초기화
t = 0


# 입력된 수 중 큰 수보다 작은 소수를 모두 찾기 위한 알고리즘
def find_prime(n, m):
    global primes

    # 두 수 중 어느 수가 더 크고 작은지 알 수 없음
    # 소수 찾기 알고리즘에서는 최대값만 확인하면 됨
    max_num = max(n, m)
    primes = [True] * (max_num + 1)

    # 4 이상 양의 정수의 최대 약수는 항상 제곱근 이하
    sqrt_m = int(max_num ** 0.5)

    # 0과 1은 소수가 아님
    primes[0] = primes[1] = False

    # 소수의 모든 배수는 소수가 아님
    for i in range(2, sqrt_m + 1):
        if primes[i]:
            for j in range(i + i, max_num + 1, i):
                primes[j] = False


# 입력값 중 최대값 이하의 모든 소수를 찾음
find_prime(a, b)


# 입력 범위의 모든 소수 개수를 찾음
def print_prime(n, m):
    global t

    # 역시 어느 수가 더 크고 작은지 알 수 없음
    # 범위 내의 소수 개수를 찾아야 하므로 두 수 중 최대/최소값 둘다 구해줌
    max_num = max(n, m)
    min_num = min(n, m)

    # prime list를 통해 소수인 경우에만 counter에 1을 더해줌
    for i in range(min_num, max_num + 1):
        if primes[i]:
            t += 1
    print('범위 내 모든 소수의 개수는 %d개' % t)


# counter에 저장한 수를 출력함
print_prime(a, b)
