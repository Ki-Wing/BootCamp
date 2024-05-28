while true; do
    ## 사용자가 product를 입력할때마다, 현재 시간을 score로 zadd
    echo "Add products or exit"
    read product
    if [ "$product" == "exit" ]; then
        echo "exit"
        break
    fi
    timestamp=$(date + %s)
    redis-cli zadd recent:prodicts $timestamp $product
done
redis-cli zrevreange recent:products 0 4