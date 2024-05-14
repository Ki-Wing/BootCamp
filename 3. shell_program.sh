# [쉘 (Shell) 프로그램]
# 사용자와 운영체제 간의 인터페이스 프로그램. 쉘은 사용자의 명령을 해석하여 운영체제 커널에 전달
# 대표적인 쉘 프로그램으로는 bash(기본), zsh 등

# 어떤 프로그램 쓰는지
echo $0

# [실습1]
echo "script start"
mkdir /home/사용자/my_dir4
cd /home/사용자/my_dir4
echo "hi file1" > file1.txt
echo "hi file2" > file2.txt
cp file1.txt file1_backup.txt
mv file2.txt file2_rename.txt
echo "script end"


# [if문]
if [ 1 -gt 2 ]; then
    echo "hello 1"
else
    echo "hello 2"
fi

# if문과 변수 활용 (파일 -f 디렉 -d)
file_name="text.txt"
if [ -f "$file_name" ]; then
    echo "$file_name yes"
else    
    echo "$file_name"
fi

# [if문 실습]

if [ -d my_test ]; then
else 
    mkdir my_test
fi


# [for문]
for a in {1..100}
do
     명령어
done

# [for문 실습]
if [ -f test.txt]; then
        for i in {1..100}
    do 
        echo "hello $i" >> test.txt
    done
else    
    touch test.txt
fi

# for문 활용한 count 세기
ㅑcount=0
for i in {1..100}
do
    ((count++))
    echo "$count"
done

#for문 활용한 모든 파일 디렉토리 목록 출력
for i in *
do  
    ((count++))
done

# for문 활용해서 특정 디렉토리 안에 file은 몇갠지 디렉토리 몇개인지 출력
count=0
fi_count=0
di_count=0

for i in *
do 
    if [ -f $i ]; then
        ((fi_count++))
    elif [ -d $i ]; then
        ((di_count++))
    else    
        ((count++))
    fi
else

echo "file : $fi_count"
echo "dic : $di_count"
echo "other : $count"
