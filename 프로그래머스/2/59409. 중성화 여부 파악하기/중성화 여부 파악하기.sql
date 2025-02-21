select animal_id, name, (
    case
        when SEX_UPON_INTAKE like '%Neutered%' or SEX_UPON_INTAKE like '%Spayed%' then 'O'
        else 'X'
    end
) as SEX_UPON_INTAKE
from animal_ins