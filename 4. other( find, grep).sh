# NGINX 웹 서버
sudo systemctl start nginx
sudo systemctl stop nginx

# 프로세스 죽이기
kill -9 [PID]

# -e :모든 프로세스    -f full format
ps -ef | grep -i "nginx"

# [grep 명령어]특정 패턴이나 문자열을 검색
# grep [옵션] [패턴] [파일명]
# -r : 디렉토리내 검색
#-i : 대소문자 구분없이 검색
# -n : 라인수 출력
grep -rin "hello" mydir

# 파일이나 디렉토리를 찾아 위치 출력
# find [경로] [옵션] [행동]
# . : 현재 위치
# -name : 파일명 검색
# -type : 타입으로 검색 (-d -f)
# -exec : 찾은 파일은 실행 
# \   : exec 종료지점
# {}  : find로 찾은 대상이 담기는 공간
find . -name "*.txt"
find . -name "*.txt" | xargs grep -rin "hello"  # 파일 검색 후 해당 내용에서 원하는 문자열 찾기
find . -name "*.txt" -exec cp -r {} ./testfolder \;
find . -name "*.txt" -exec grep -rni "hello" {} \;

# 현재폴더에서 .txt로 끝나는 파일명 검색
find . -type -f -name "*.txt"

# 입력받은 파일 목록 하나씩 읽음
xargs
