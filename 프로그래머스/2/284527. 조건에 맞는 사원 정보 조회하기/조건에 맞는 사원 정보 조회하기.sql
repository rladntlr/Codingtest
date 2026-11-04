-- 코드를 작성해주세요
select sum(g.SCORE) as SCORE, e.EMP_NO, e.EMP_NAME, e.POSITION, e.EMAIL
from HR_EMPLOYEES e
join HR_GRADE g using(EMP_NO)
where g.year = 2022
group by e.EMP_NO, e.EMP_NAME, e.POSITION, e.EMAIL
order by SCORE desc
limit 1;