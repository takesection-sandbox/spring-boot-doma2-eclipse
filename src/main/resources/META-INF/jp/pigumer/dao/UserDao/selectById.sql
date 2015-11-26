-- package: jp.pigumer.dao
-- interface: UserDao
-- annotation: @Select
-- method: User selectById(String id)
select
 id
,name
from
 user
where
 id = /*id*/'1'