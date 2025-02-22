with value as(
    select h.history_id, c.car_type, c.daily_fee, datediff(h.end_date,h.start_date)+1 as period,(
        case
            when datediff(h.end_date, h.start_date) + 1 >= 90 then '90일 이상' 
            when datediff(h.end_date, h.start_date) + 1 >= 30 then '30일 이상'
            when datediff(h.end_date, h.start_date) + 1 >= 7 then '7일 이상'
                        else 'NONE' 
        end
    ) as duration_type
    from CAR_RENTAL_COMPANY_CAR as c
    join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
    on c.car_id = h.car_id
    where c.car_type = '트럭'
)

select value.history_id, (
    round(value.daily_fee * value.period *
         (100 - ifnull(p.discount_rate,0)) / 100) )as fee
from value
left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p
on value.duration_type = p.DURATION_TYPE and value.car_type = p.car_type
order by fee desc, value.history_id desc