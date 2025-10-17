-- 코드를 입력하세요
-- 코드를 입력하세요
# CTE

# 11월에 대여가 가능한 세단 , SUV
WITH available_cars AS (
    SELECT
        c.CAR_ID,
        c.CAR_TYPE,
        c.DAILY_FEE
    FROM CAR_RENTAL_COMPANY_CAR AS c
    WHERE c.CAR_TYPE IN('세단', 'SUV')
        AND NOT EXISTS (
        SELECT 1
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS h
            WHERE h.CAR_ID = c.CAR_ID
                AND h.START_DATE <= '2022-11-30'
                AND h.END_DATE >= '2022-11-01'
        )
    ),
# 30일 이상 할인율 <- Join
car_with_discount AS (
    SELECT
        a.CAR_ID,
        a.CAR_TYPE,
        a.DAILY_FEE,
        d.DISCOUNT_RATE
    FROM available_cars AS a
    INNER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS d
    ON a.CAR_TYPE = d.CAR_TYPE
    AND d.DURATION_TYPE = '30일 이상'
),
# 요금 계산
car_with_fee AS(
    SELECT
        CAR_ID,
        CAR_TYPE,
        FLOOR(DAILY_FEE * 30 * (100 - DISCOUNT_RATE) / 100) AS FEE
    FROM car_with_discount
)
# 최종 정리
SELECT
    CAR_ID,
    CAR_TYPE,
    FEE
FROM car_with_fee
WHERE FEE >= 500000
    AND FEE < 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC;