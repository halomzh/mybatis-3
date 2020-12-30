/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.transaction.jdbc;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * JDBC事务工厂
 * Creates {@link JdbcTransaction} instances.
 *
 * @author Clinton Begin
 * @see JdbcTransaction
 */
public class JdbcTransactionFactory implements TransactionFactory {

  /**
   * 新建事务
   *
   * @param conn Existing database connection 已存在的事务连接
   * @return 事务
   */
  @Override
  public Transaction newTransaction(Connection conn) {
    return new JdbcTransaction(conn);
  }

  /**
   * 新建事务
   *
   * @param ds         数据源
   * @param level      Desired isolation level 事务隔离级别
   * @param autoCommit Desired autocommit 是否自动提交
   * @return
   */
  @Override
  public Transaction newTransaction(DataSource ds, TransactionIsolationLevel level, boolean autoCommit) {
    return new JdbcTransaction(ds, level, autoCommit);
  }
}
