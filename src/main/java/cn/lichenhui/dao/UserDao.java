package cn.lichenhui.dao;

import cn.lichenhui.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

	User getUerById(long id);
}
