-- 코드를 작성해주세요
select count(*) as FISH_COUNT, month(TIME) MONTH
from FISH_INFO
group by MONTH
order by MONTH;