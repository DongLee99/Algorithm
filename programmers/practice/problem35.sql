-- 코드를 입력하세요
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, CASE
                                              WHEN STATUS = 'SALE' THEN '판매중'
                                              WHEN STATUS = 'RESERVED' THEN '예약중'
                                              WHEN STATUS = 'DONE' THEN '거래완료'
    END AS STATUS
FROM USED_GOODS_BOARD
WHERE CREATED_DATE BETWEEN '2022-10-05 00:00:00' AND '2022-10-05 23:59:59'
ORDER BY BOARD_ID DESC