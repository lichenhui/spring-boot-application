package cn.lichenhui.dao.impl;

import cn.lichenhui.dao.commons.RowMapperFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public abstract class JdbcDao {

	@Resource
	private NamedParameterJdbcTemplate template;

	/**
	 * Query one row and return it as an object.
	 *
	 * @param sql
	 * @param paramMap
	 * @param requiredType
	 * @return
	 * @see NamedParameterJdbcTemplate
	 */
	protected <T> T queryForObject(String sql, Map<String, ?> paramMap, Class<T> requiredType) {
		List<T> results = queryForListOfObjects(sql, paramMap, requiredType);
		if (results == null || results.size() == 0) {
			return null;
		} else {
			return results.get(0);
		}
	}

	/**
	 * Query one row and return it as a Map<column name, value>.
	 *
	 * @param sql
	 * @param paramMap
	 * @return
	 * @see NamedParameterJdbcTemplate
	 */
	protected Map<String, Object> queryForMap(String sql, Map<String, ?> paramMap) {
		List<Map<String, Object>> results = queryForListOfMaps(sql, paramMap);
		if (results == null || results.size() == 0) {
			return null;
		} else {
			return results.get(0);
		}
	}

	/**
	 * Query multiple rows and return them as a list of objects.
	 *
	 * @param sql
	 * @param paramMap
	 * @param requiredType
	 * @return
	 * @see NamedParameterJdbcTemplate
	 */
	protected <T> List<T> queryForListOfObjects(String sql, Map<String, ?> paramMap, Class<T> requiredType) {
		return template.query(sql, new MapSqlParameterSource(paramMap),
				RowMapperFactory.getRowMapper(requiredType));
	}

	/**
	 * Query multiple rows and return them as a list of Map<column name, value>s.
	 *
	 * @param sql
	 * @param paramMap
	 * @return
	 * @see NamedParameterJdbcTemplate
	 */
	protected List<Map<String, Object>> queryForListOfMaps(String sql, Map<String, ?> paramMap) {
		return template.queryForList(sql, new MapSqlParameterSource(paramMap));
	}

	/**
	 * Insert into, update, or delete from the table.
	 *
	 * @param sql
	 * @param paramMap
	 * @return the number of rows affected
	 * @see NamedParameterJdbcTemplate
	 */
	protected int update(String sql, Map<String, ?> paramMap) {
		return template.update(sql, new MapSqlParameterSource(paramMap));
	}

	/**
	 * Insert into, update, or delete from the table and return the generated id.
	 *
	 * @param sql
	 * @param paramMap
	 * @return the id of affected row
	 * @see NamedParameterJdbcTemplate
	 */
	protected Number updateForkey(String sql, Map<String, ?> paramMap) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		template.update(sql, new MapSqlParameterSource(paramMap), keyHolder);
		return keyHolder.getKey();
	}

	/**
	 * Batch insert into, update, or delete from the table.
	 *
	 * @param sql
	 * @param batchParamMap
	 * @return a list of numbers of corresponding rows affected
	 * @see NamedParameterJdbcTemplate
	 */
	protected List<Integer> batchUpdate(String sql, List<Map<String, ?>> batchParamMap) {
		SqlParameterSource[] batchArgs = new SqlParameterSource[batchParamMap.size()];
		for (int i = 0; i < batchArgs.length; ++i) {
			batchArgs[i] = new MapSqlParameterSource(batchParamMap.get(i));
		}

		int[] resultInts = template.batchUpdate(sql, batchArgs);

		List<Integer> result = new ArrayList<Integer>(resultInts.length);
		for (int resultInt : resultInts) {
			result.add(resultInt);
		}
		return result;
	}
}