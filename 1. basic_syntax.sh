# 현 위치
pwd

# 파일,폴더 목록
ls 

# 목록 자세히
ls -l

# 숨김파일
ls -al

# 시간순 등등...
ls -alrt

# 디렉토리 생성
mkdir test

# 디렉토리 이동
cd test

# 루트 디렉토리(최상단) 이동
cd /

# 홈 디렉토리로 이동
cd

# 절대경로
cd /home/ubuntu/test

## 상위 폴더 이동
cd ..

## 직전 디렉토리
cd -

# 빈 파일 생성
touch first_file.txt

# 파일 내용 조회
cat first_file.txt

# 페이지 단위 출력
more first_file.txt

# 터미널에 문자열 출력
echo "hello world"

# echo를 통해 파일에 문자열 쓰기
echo "hello world" > first_file.txt

# echo를 통해 파일에 문자열 추가(삽입)
echo "hello world2" >> first_file.txt

# 사용한 명령어 list
history

# 터미널 청소
clear

# [mv 명령어]
# 파일명 변경시 사용
mv a.txt b.txt
# 파일이나 디렉토리 이동(잘라내기 효과) 
mv a.txt ../b.txt

# [cp 명령어] 
#파일 복사
cp second_file.txt third_file.txt
# 디렉토리 까지 복사
cp -r test test2

# [rm 명령어]
# 파일 삭제
rm third_file.txt
# 디렉토리까지 삭제
rm -r
# 디렉토리까지 묻지 않고 삭제
rm -rf test3

# 텍스트를 작성된 파일의 상위 n행 출력
head -5 first_file.txt   #기본 10줄

# 텍스트로 작성된 파일의 하위 n행 출력
tail -5 first_file.txt

# [nano 편집기]
# ctrl+o : 저장
# ctrl+x : 나가기
nano file.txt

# 파이프라인 왼쪽 명령어 실행 값을 오른쪽 명령어로 전달
"명령어1" | "명령어2"

# 파일 내에서 특정 패턴이나 문자열을 검색
# grep [옵션] [패턴] [파일명]
grep -rin "hello" mydir

# 디렉토리내 모든 검색
grep -r

# 대소문자 구분없이 검색
grep -i

# 라인수 출력
grep -n

# 입력받은 파일은 하나씩 읽는다
xargs

# 파일이나 디렉토리를 찾아 위치 출력
# find [경로] [옵션] [행동]
find . -name "*.txt"
# -name 옵션 : 파일명 검색
# -type : 타입으로 검색 (-d -f)
# -exec : 찾은 파일은 실행 
# - \   : exec의 종료지점을 의미
# - {}  : find로 찾은 대상이 담기는 공간을 의미

# 사용예시
# find . -type -f -name "*.txt" : 현재폴더에서 파일타입중 .txt로 끝나는 파일명 검색
# 활용예시
# find . -name "*.txt" | xargs grep -n "hello"
# find . -name "*.txt" -exec cp -r {} ./testfolder \;

find . -name "*.txt" -exec grep -rni "hello" {} \;

