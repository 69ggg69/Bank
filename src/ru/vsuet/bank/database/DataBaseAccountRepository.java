package ru.vsuet.bank.database;

import ru.vsuet.bank.domain.BankAccount;
import ru.vsuet.bank.repository.Repository;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseAccountRepository implements Repository<BankAccount> {
    private final Connection connection;

    public DataBaseAccountRepository(DataBaseConnector connector) { //чисто показывает имя бд
        this.connection = connector.getConnection();
        try {
            String databaseProductName = this.connection.getMetaData().getDatabaseProductName();
            System.out.println("Data base: " + databaseProductName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//иммутабельный объект

    
    @Override
    public void save(BankAccount source) {
        String insertQuery = "insert into bankdb.account (name) values (?) (amount) values (?)";
        String updateQuery = "update bankdb.account set name = ? set amount = ? where id = ? ";
        int rows;
        if (source.getId() == null) {
            rows = execute(insertQuery, statement -> {
                statement.setString(2, source.getName());
                statement.setBigDecimal(3, source.getAmount());
            });
        } else {
            rows = execute(updateQuery, statement -> {
                statement.setLong(1, source.getId());
                statement.setString(2, source.getName());
                statement.setBigDecimal(3, source.getAmount());
            });

        }
        System.out.println(rows);
    }

    @Override
    public void delete(BankAccount target) {
        String query = "delete from bankdb.account where id = ?";
        int rows = execute(query, statement -> statement.setLong(1, target.getId()));
        System.out.println("Delete stroki:" + rows);
    }

    private int execute(String query, SQLConsumer consumer) {
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            consumer.accept(statement);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error while Repository::save method executing: " + e);
        }
    }

    private final Mapper<BankAccount> map = resultSet -> {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        BigDecimal amount = resultSet.getBigDecimal("amount");
        return new BankAccount(id, name, amount);
    };

    private <T> List<T> executeSelect(String query, SQLConsumer consumer, Mapper<T> mapper) {
        try (
                PreparedStatement statement = connection.prepareStatement(query);
        ) {
            if (consumer != null) {
                consumer.accept(statement);
            }
            ResultSet resultSet = statement.executeQuery();
            List<T> accounts = new ArrayList<>();
            while (resultSet.next()) {
                T account = mapper.map(resultSet);
                accounts.add(account);
            }
            return accounts;
        } catch (SQLException e) {
            throw new RuntimeException("Error while Repository::list method executing: " + e);
        }
    }

    @Override
    public List<BankAccount> list() {
        String query = "select * from bankdb.account";
        return executeSelect(query, null, map);
    }

    @Override
    public BankAccount find(Long id) {
        String query = "select * from bankdb.account where id = ?";
        List<BankAccount> accounts = executeSelect(query, statement -> statement.setLong(1, id), map);
        if(accounts.isEmpty()){
            throw new RuntimeException("No elements found by given id");
        } else {
        return accounts.get(0);
        }
    }
}