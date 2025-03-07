select a.id,c.fish_name,a.length
from fish_info as a
join (select fish_type, max(length) as max_length
      from fish_info
      group by fish_type) as b
on a.fish_type = b.fish_type and a.length = max_length
left join fish_name_info as c
on c.fish_type = a.fish_type
order by a.id