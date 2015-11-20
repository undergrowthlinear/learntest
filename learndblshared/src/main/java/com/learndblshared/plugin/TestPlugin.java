package com.learndblshared.plugin;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.springframework.util.ReflectionUtils;

@Intercepts({ @Signature(args = { Connection.class }, method = "prepare", type = StatementHandler.class) })
public class TestPlugin implements Interceptor {

	private Properties properties;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		RoutingStatementHandler handler = (RoutingStatementHandler) invocation
				.getTarget();
		BaseStatementHandler deleteHandler = getField(
				BaseStatementHandler.class, handler, "delegate");
		MappedStatement mappedStatement = getField(MappedStatement.class,
				deleteHandler, "mappedStatement");
		disStatementInfos(deleteHandler, mappedStatement);
		return invocation.proceed();
	}

	/**
	 * 显示MappedStatement相关信息
	 * 
	 * @param mappedStatement
	 */
	private void disStatementInfos(BaseStatementHandler deleteHandler,
			MappedStatement mappedStatement) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append("id").append(":").append(mappedStatement.getId())
				.append("\n");
		builder.append("statementType").append(":")
				.append(mappedStatement.getStatementType()).append("\n");
		builder.append("sqlCommandType").append(":")
				.append(mappedStatement.getSqlCommandType()).append("\n");
		builder.append("boundSql.sql").append(":")
				.append(deleteHandler.getBoundSql().getSql()).append("\n");
		builder.append("boundSql.parameterObject").append(":")
				.append(deleteHandler.getBoundSql().getParameterObject())
				.append("\n");
		System.out.println(builder.toString());
	}

	/**
	 * 查找到制定对象字段的对象
	 * 
	 * @param clazz
	 * @param target
	 * @param attributeName
	 * @return
	 */
	private <T> T getField(Class<T> clazz, Object target, String attributeName) {
		// TODO Auto-generated method stub
		Field field = ReflectionUtils.findField(target.getClass(),
				attributeName);
		field.setAccessible(true);
		return (T) ReflectionUtils.getField(field, target);
	}

	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		this.properties = properties;
	}

}
