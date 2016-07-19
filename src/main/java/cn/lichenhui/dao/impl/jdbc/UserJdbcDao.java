package cn.lichenhui.dao.impl.jdbc;

import cn.lichenhui.dao.UserDao;
import cn.lichenhui.dao.impl.JdbcDao;
import cn.lichenhui.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@PropertySource("classpath:sql/user.properties")
public class UserJdbcDao extends JdbcDao implements UserDao {

	@Value("${sql.user.get_user_by_id}")
	private String GET_USER_BY_ID;

	@Override
	public User getUerById(long id) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		return this.queryForObject(this.GET_USER_BY_ID, paramMap, User.class);
	}
}
