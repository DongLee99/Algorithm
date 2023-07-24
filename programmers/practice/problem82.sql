-- 코드를 입력하세요
SELECT AI.ANIMAL_ID, AI.NAME
FROM ANIMAL_INS as AI JOIN ANIMAL_OUTS as AO ON AI.ANIMAL_ID = AO.ANIMAL_ID
ORDER BY DATEDIFF(AO.DATETIME, AI.DATETIME) DESC
    LIMIT 2