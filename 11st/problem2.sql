SELECT Name, Description, CASE IsEnabled WHEN 0 THEN 'DISABLED' ELSE 'ENABLED' END as Status
FROM UserRole
WHERE Description IS NOT NULL AND
        LOWER(CreatedBy) LIKE '%john smith%' AND
    DATE_FORMAT(Created, '%Y-%m-%d') BETWEEN DATE_FORMAT('2020-01-04', '%Y-%m-%d') AND DATE_FORMAT('2020-01-06', '%Y-%m-%d')
  AND  Updated IS NULL
ORDER BY NAME DESC