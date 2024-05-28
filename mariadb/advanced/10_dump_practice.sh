# local의 board DB -> 마이그레이션 -> (linux) 이전
    # linux에 db 설치 -> local에 dum 작업 후 sql 쿼리 생성 -> 
    # github에 upload -> git clone -> linux에서 해당 쿼리 실행

# local에서 sql 덤프파일 생성 // 한글 깨질때 -r
mysqldump -u root -p board -r > dumpfile.sql

# dump 파일 github에 업로드

# ubuntu 접속 
# mariadb 설치
sudo apt-get install mariadb-server

# mariadb 서버 시작 및 상태 확인
sudo systemstl start mariadb
sudo systemstl status mariadb

# mariadb 접속 테스트
sudo mariadb -u root -p

# db 생성
create database board;
show databases;
exit

# git
sudo apt install git
git --version
git clone 내 주소

# 
cd pathㄱㄱ
sudo mysql -u root -p board -r < dumpfile.sql
