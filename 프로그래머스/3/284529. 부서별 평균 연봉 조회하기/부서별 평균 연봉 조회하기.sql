select d.DEPT_ID, d.DEPT_NAME_EN, round(avg(e.sal)) as AVG_SAL
from HR_DEPARTMENT d, HR_EMPLOYEES e
WHERE d.DEPT_ID = e.DEPT_ID
group by d.DEPT_ID
order by AVG_SAL desc;