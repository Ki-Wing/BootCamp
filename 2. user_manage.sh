# 사용자목록 조회
cat /etc/passwd

# [sudo]
# sudo 키워드는 현재 계정에서 root 권한을 이용하여 명령어를 실행하는 명령어
# root권한이 아닌 현재 사용자의 비밀번호를 입력해야 함을 반드시 기억
# /etc/sudoers 파일에 sudo를 쓸수 있는 사용자와 명령어가 따로 정의돼 있어서 아무사용자가 아무명령어를 사용하는 것은 불가
# 새로운 유저를 만들면서 그룹지정 및 홈 디렉토리 지정
sudo useradd -g gyeongnam -d /home/사용자명 사용자명

# 사용자 추가
useradd 사용자명

# 사용자 패스워드 지정 : 1234
sudo passwd 사용자명

mkdir newuser1

# 사용자 계정 전환
sudo su - 사용자명

# 계정전환 종료
exit

# 계정삭제
sudo userdel 사용자명

# [권한변경]
# 권한은 3파트로 구성 : user/group/others
# r(4)w(2)x(1) -> rwx : 7
chmod 777 test.sh
chmod u+w test.sh
chmod g-x test.sh
chmod o+r test.sh

# 폳더 소유자 변경
sudo chown 소유자:그룹 파일명

# NGINX 웹 서버 실습
sudo systemctl start nginx
sudo systemctl stop nginx

# 프로세스 관련 (작업중인)
kill -9 [PID]

# 특정 프로세스 찾기
ps -ef | grep -i "nginx"

# ip 정보등 네트워크 설정정보 출력
ifconfig

#네트워크 원결 상태 확인
ping

# 넷켓 패스체크
nc-zv naver.com 443

# 현재 서버에 연결된 네트워크 정보 출력
netstat

# 원격 호스트와의 터미널 세션을 제공 ex) ssh [username]@[hosrtname/ip] 
ssh 

# 파일 전송 ex) scp [source] [destination]
scp

# [vi 에디터]
# vi는 명령모드와 입력모드로 구성
# +) nano는 배포판마다 다른데 vi는 거의 o
vi [파일명]

# 입력모드
# i     : 현재 커서부터 입력
# o     : 다음줄 커서부터 입력
# x     : 현재 커서가 위치한 단어 삭제
# dd    : 현재 커서가 위치한 행 삭제
# yy    : 현재 커서가 위치한 행 복사
# p     : 현재 행 이후에 붙여넣기
# a     : 그다음 커서 입력

# 명령모드
# esc
# 파일 저장
:w!
# 저장없이 vi 종료
:q!
 # 저장후 vi 종료
:wq!
# G         : 파일의 마지막 줄로 이동
# gg        : 파일의 첫 줄로 이동
# Crtl + f  : 한페이지 아래로 이동
# Crtl + b  : 한페이지 위로 이동
# /         : 검색하기
