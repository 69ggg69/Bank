package ru.vsuet.bank.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
@FunctionalInterface
public interface SQLConsumer {
    void accept(PreparedStatement statement) throws SQLException;
}
