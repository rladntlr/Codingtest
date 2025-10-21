-- 코드를 작성해주세요
with avg_score as (
select EMP_NO, avg(SCORE) as avg_score 
from HR_GRADE
where YEAR = 2022
group by EMP_NO)
select 
e.EMP_NO, e.EMP_NAME, 
case
    when a.avg_score >= 96 then 'S'
    when a.avg_score >= 90 then 'A'
    when a.avg_score >= 80 then 'B'
    else 'C'
    end as GRADE,
case
    when a.avg_score >= 96 then e.SAL * 0.2
    when a.avg_score >= 90 then e.SAL * 0.15
    when a.avg_score >= 80 then e.SAL * 0.1
    else 0
    end as BONUS
from HR_EMPLOYEES as e
inner join avg_score as a
on e.EMP_NO = a.EMP_NO
order by e.EMP_NO;