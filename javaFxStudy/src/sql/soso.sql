SELECT *
FROM   tab;

SELECT *
FROM   member;

CREATE TABLE work_temp AS
    SELECT *
    FROM   WORK
    WHERE  worknum LIKE '1%';

DELETE FROM WORK
WHERE  worknum LIKE '1%';

SELECT *
FROM   employees
WHERE  empnum = 61;

SELECT e.empname
      ,TO_CHAR(w.workstart
              ,'dy') AS week
      ,TO_CHAR(w.workstart
              ,'mm/dd') AS MONTH
      ,TO_CHAR(w.workstart
              ,'hh24:mi') AS workstart
      ,NVL(TO_CHAR(w.workend
                  ,'hh24:mi')
          ,' ') AS workend
      ,ROUND(TRUNC((w.workend - w.workstart) * 24
                  ,1)
            ,3) AS sumtime
FROM   employees e
      ,WORK      w
WHERE  w.empnum = e.empnum
      --AND    storeid = 'test'
AND    TO_CHAR(w.workend
              ,'YYYY-MM') = '2020-08'
AND    e.empnum = '61';

SELECT *
FROM   WORK
WHERE  empnum = '106';

SELECT *
FROM   employees e
WHERE  e.empnum = 106;

SELECT TRUNC(SUM(TRUNC((workend - workstart) * 24
                      ,1))
            ,2) AS totaltime
      ,TRUNC(SUM(TRUNC((workend - workstart) * 24
                      ,0)) * 8350
            ,0) AS totalsal
FROM   WORK      w
      ,employees e
WHERE  w.empnum = e.empnum
      --AND    storeid = #{storeid}
AND    TO_CHAR(w.workend
              ,'YYYY-MM') = '2020-08'
AND    e.empnum = #{empnum};

UPDATE payment
SET    status = '1'
WHERE  paynum = '3';
