# 인메모리 db
# 레디스 설치
sudo apt-get redis-server 
redis-server --version

# 레디스 접속
    # cli : command line interface
redis-cli

# db 선택
    # redis는 0~15번 까지 db로 구성됨
select 번호

# 모든 database내 key 조회
keys *

# String 자료구조(기본)
set key명 value명
    # ex) 사용자 email
    # key값은 중복 x
    set user:eamil:1  test@naver.com
    # key값 이미 존재하면 덮어쓰기 (맵 저장소에서 key값 유일성 보장)
    # nx : not exist
    set user:eamil:1  test1@naver.com nx  # 안들어가짐
    # ex(만료시간-초단위) : ttl(time to live)
    set user:eamil:2  test2@naver.com ex 20


# 값 받아오기
get key명

# 특정 key 삭제
del key명
    # 현재 db 전체 key 삭제
    flushsb

# 좋아요 기능
set likes:posting:1 0
incr likes:posting:! #특정 key값의 values를 1만큼 증가
decr likes:posting:1 #1만큼 감소
get likes:posting:1 

# 재고 기능
set product:1:stock 100
decr product:1:stock
get product:1:stock

# 캐싱 기능 구현
    # 1번 author 회원 정보 조회
    # select name, email, age from author where id = 1;
    # 위 데이터의 결과값을 redis로 캐싱 : json 데이터 형식으로 저장
set user:1:detail "{\"name\":\"ynlee\", \"email\":\"test@naver.com\", \"age\":25}" ex 15

# list
# redis의 list는 java의 deque와 같은 구조(양방형// double-ended queu 구조)
    # 데이터 왼/오른쪽 삽입
    LPUSH key명  value값
    RPUSH key명  value값
    # 데이터 왼/오른쪽 꺼내기 
    LPOP key명
    RPOP key명

    lpush name ynlee1
    lpush name ynlee2
    lpush name ynlee3      # ynlee3 ynlee2 ynlee1
    lpop name # ynlee3
    rpush name ynlee3      # ynlee2 ynlee1 ynlee3

    # 조회만 하기
    lrange key명 -1 -1

    # 데이터 개수 조회
    llen key명

    # list 요소 조회시에는 범위 지정
    lrange key명 0 -1 # 처음부터 끝까지 // index는 0부터 시작
    lrange key명 1 2      # 1,2번 index만 출력 

    # TTL 적용
    expire key명 30
    # TTL 조회
    TTL key먕

    # pop과 push를 동시에
    rpoplpush a리스트 b리스트  # (a리스트에 rpop되고 동시에 b리스트에 lpush)

    # 최근 방문한 페이지 -> sorted set (zset)이 효율
    # 5개 정도 push
    # 최근 방문한 페이지 3개 정도 조회
    lpush user:1:recent_page http://naver.com1
    lpush user:1:recent_page http://naver.com2
    lpush user:1:recent_page http://naver.com3
    lpush user:1:recent_page http://naver.com4
    lpush user:1:recent_page http://naver.com5
    lrange user:1:recent_page 0 2
        # 위 방문 페이지 5개에서 뒤로가기 앞으로가기 구현
        # 뒤로 가기 페이지 누르면 뒤로가기 페이지 뭔지 출력 // 앞으로 가기도 동일
        rpoplpush user:1:recent_page user:1:recent_pages
        rpoplpush user:1:recent_page user:1:recent_pages

# set 자료구조
sadd set명 value명
sadd set명 value명
sadd set명 value명

# set 값 조회
smembers set명

# set 길이 조회
scard set명

# set에서 멤버 삭제
srem set명 value명

# set안에 멤버가 있는지 존재 여부 확인
sismember set명 value명

# 매일 방문자 수 계산
sadd visit:2024-05-27 ynlee@naver.com

# zset(sorted set)
zadd zmembers 3 member1
zadd zmembers 4 member2
zadd zmembers 1 member3
zadd zmembers 2 member4

# score기준 오름/내림차순 정렬
zrange zmembers 0 -1
zrevrange members 0 -1

# zset 삭제
zrem zmembers 

# value index 찾기
zrank zmembers member2

# 최근 본 상품목록 -> sorted set (zset) 활용
    # 가장 최근에 본 상품 출력하면 apple, orange, banana가 출력 될거임(zrevrange)
zadd recent:products 192411 apple
zadd recent:products 192413 banana 
zadd recent:products 192415 pineapple 
zadd recent:products 192420 orange 
zadd recent:products 192430 apple 
zadd recent:products 192435 apple 

- zrevrange recent:products 0 2

# 예제
while true;do  
    echo "Add product or exit"
    read product
    if [ "$product" == "exit" ]; then
        echo "exit"
        break
    fi
    timestamp=$(date+ %s)
    redis-cli zadd recent:products $timestamp $product
done
redis-cli zrevrange recent products 0 4

# hashes
    # 해당 자료구조에서는 문자, 숫자가 구분
hset product:1 name "apple" price 1000 stock 50
# 값 조회
hget product:1 name
hgetall product:1
# 특정 요소값 수정
hest product:1 stock 40

# 특정 요소값 증/감소
hincrby product:1 stock 5
hincrby product:1 stock -5


# sub & pub
subscribe channel명
publish channel명 "hello world java"











