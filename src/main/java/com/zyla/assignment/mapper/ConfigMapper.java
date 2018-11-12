package com.zyla.assignment.mapper;

import com.zyla.assignment.model.Config;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfigMapper implements ResultSetMapper<Config> {
    private static final String KEY = "key";
    private static final String VALUE = "val";

    @Override
    public Config map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Config(resultSet.getString(KEY), resultSet.getString(VALUE));
    }
}
