select `db_julian`.`cidade`. `nome`,
 `db_julian`.`estado`.`uf` 
from `db_julian`.`cidade`,
`db_julian`.`estado`
where `db_julian`.`cidade`. `nome` like '%São luis%'
and `db_julian`. `cidade`. `uf`=
`db_julian`.`estado`. `id`;