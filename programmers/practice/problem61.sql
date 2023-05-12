SELECT CONCAT('/home/grep/src/',BOARD_ID,'/',FILE_ID,FILE_NAME,FILE_EXT) as 'FILE_PATH'
FROM USED_GOODS_FILE
WHERE BOARD_ID = (SELECT UGB.BOARD_ID
                  FROM USED_GOODS_BOARD as UGB JOIN USED_GOODS_FILE as UGF ON UGB.BOARD_ID = UGF.BOARD_ID
                  GROUP BY UGB.BOARD_ID
                  ORDER BY UGB.VIEWS DESC
    LIMIT 1)
ORDER BY FILE_ID DESC