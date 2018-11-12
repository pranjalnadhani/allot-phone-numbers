package com.zyla.assignment.db;

import com.zyla.assignment.mapper.ConfigMapper;
import com.zyla.assignment.model.Config;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(ConfigMapper.class)
public interface ConfigDAO {
    @SqlQuery("SELECT * FROM config WHERE key = 'LAST_ALLOTTED_NO'")
    Config getLastAllottedNum();

    @SqlUpdate("INSERT OR REPLACE INTO config (key, val) VALUES ('LAST_ALLOTTED_NO', coalesce(:val, (SELECT val FROM config WHERE key = 'LAST_ALLOTTED_NO')))")
    void editLastAllottedNum(@Bind("val") final long val);
}
