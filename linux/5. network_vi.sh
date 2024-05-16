# 특정 도메인에 ip 주소매핑 조회
#  DNS 서버에 질의 후 도메인 정보 조회
nslookup 도메인

# 나의 ip 정보등 출력
# sudo apt install net-tools
ifconfig 

#네트워크 얀결 상태 확인
ping

# 넷켓 패스체크
# TCP/UDP 프로토콜을 사용하는 네트워크 환경에서 데이터를 읽고 씀
nc-zv naver.com 443

# 현재 서버에 연결된 네트워크 정보 출력
netstat

# 원격 호스트와 터미널 세션 제공 ex) ssh [username]@[hosrtname/ip] 
ssh 

# 파일 원격 전송 ex) scp [source] [destination]
scp


# [vi 에디터]
vi [파일명]

# [입력모드]
# i : 현재 커서부터 입력
# o : 다음줄 커서부터 입력
# x : 현재 커서가 위치한 단어 삭제
# dd : 현재 커서가 위치한 행 삭제
# yy : 현재 커서가 위치한 행 복사
# p : 현재 행 이후에 붙여넣기
# a : 그다음 커서 입력

# [명령모드 : esc]
# :w!   파일 저장
# :q!   저장없이 vi 종료
# :wq!  저장후 vi 종료
# G         : 파일의 마지막 줄로 이동
# gg        : 파일의 첫 줄로 이동
# Crtl + f  : 한페이지 아래로 이동
# Crtl + b  : 한페이지 위로 이동
# /         : 검색하기
