package com.zyla.assignment.mapper;

import com.zyla.assignment.model.PhoneNumber;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneNumbersMapper implements ResultSetMapper<PhoneNumber> {
    private static final String PHONE = "phone";

    @Override
    public PhoneNumber map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new PhoneNumber(resultSet.getLong(PHONE));
    }
}
