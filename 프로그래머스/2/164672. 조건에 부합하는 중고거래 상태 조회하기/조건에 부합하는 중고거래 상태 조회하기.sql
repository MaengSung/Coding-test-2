SELECT board_id, writer_id, title, price, (
    case
        when status = 'SALE' then '판매중'
        when status = 'DONE' then '거래완료'
        else '예약중'
) as status
from USED_GOODS_BOARD
where date_format(created_date, '%Y%m%d') = 20221005;