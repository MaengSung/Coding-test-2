SELECT concat(
    '/home/grep/src',
    '/',b.board_id,
    '/',f.file_id,file_name,f.file_ext
) as FILE_PATH
from USED_GOODS_BOARD as b 
join USED_GOODS_FILE as f
on b.board_id = f.board_id
where b.views = (select max(views) from used_goods_board)
order by f.file_id desc

SELECT concat(
    '/home/grep/src',
    '/',board_id,
    '/',file_id,file_name,file_ext
) as FILE_PATH
from USED_GOODS_FILE
where board_id = (select board_id
                 from used_goods_board
                order by VIEWS desc
                limit 1)
order by file_id desc
