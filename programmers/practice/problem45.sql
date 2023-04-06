# -- 코드를 입력하세요
SELECT HISTORY_ID, CAR_ID, DATE_FORMAT(START_DATE, '%Y-%m-%d') as START_DATE, DATE_FORMAT(END_DATE, '%Y-%m-%d') as END_DATE, CASE
                                                                                                                                 WHEN DATEDIFF(DATE_FORMAT(END_DATE, '%Y-%m-%d'), DATE_FORMAT(START_DATE, '%Y-%m-%d')) >= 29
                                                                                                                                     THEN '장기 대여'
                                                                                                                                 ELSE
                                                                                                                                     '단기 대여'
    END as RENT_TYPE

FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE DATE_FORMAT(START_DATE, '%Y-%m-%d') BETWEEN DATE_FORMAT('2022-09-01', '%Y-%m-%d') AND DATE_FORMAT('2022-09-30', '%Y-%m-%d')
ORDER BY HISTORY_ID DESC



