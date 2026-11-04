-- 코드를 작성해주세요
select year(e.DIFFERENTIATION_DATE) as YEAR,
       m.max_size - e.SIZE_OF_COLONY as YEAR_DEV,
       e.ID
from ECOLI_DATA e
join (
    select year(DIFFERENTIATION_DATE) as yr, max(SIZE_OF_COLONY) as max_size
    from ECOLI_DATA
    group by year(DIFFERENTIATION_DATE)
) m on year(e.DIFFERENTIATION_DATE) = m.yr
order by YEAR, YEAR_DEV;