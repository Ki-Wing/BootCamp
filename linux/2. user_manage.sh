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
