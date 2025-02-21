SELECT history_id, car_id, date_format(start_date, '%Y-%m-%d'), date_format(end_date, '%Y-%m-%d'),(
    case
        when datediff(end_date, start_date)+1 >= 30 then '장기 대여'
        else '단기 대여'
    end
) as rent_type
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where date_format(start_date, '%Y%m') = '202209'
order by history_id desc