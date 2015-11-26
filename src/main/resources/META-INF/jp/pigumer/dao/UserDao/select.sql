-- package: jp.pigumer.dao
-- interface: UserDao
-- annotation: @Select(strategy = SelectType.STREAM)
-- method: Long select(Function<Stream<User>, Long> mapper)
select
 id
,name
from
 user
