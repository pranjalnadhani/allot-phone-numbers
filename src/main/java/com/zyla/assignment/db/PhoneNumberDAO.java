package com.zyla.assignment.db;

import com.zyla.assignment.mapper.PhoneNumbersMapper;
import com.zyla.assignment.model.PhoneNumber;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(PhoneNumbersMapper.class)
public interface PhoneNumberDAO {
    @SqlUpdate("INSERT INTO users (phone) VALUES (:phone)")
    int createNumber(@BindBean PhoneNumber phoneNumber);
}
