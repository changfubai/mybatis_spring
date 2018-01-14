import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.xiaobai.mybaits.common.baseMapper.IBaseMapper;
import com.xiaobai.mybaits.mapper.UserMapper;
import com.xiaobai.mybaits.common.page.PageBean;
import com.xiaobai.mybaits.pojo.User;
import com.xiaobai.mybaits.util.logger.LogUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class MybatisTest {
    private ApplicationContext context = null;
    @Before
    public void init() throws Exception {

        context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    }

    @Test
    public void testFindUser() {

        long start = System.currentTimeMillis();

        UserMapper mapper = this.context.getBean(UserMapper.class);
        Example example = new Example(User.class);
        PageHelper.startPage(1, 5);
        List<User> list = mapper.selectByExample(example);
        PageBean<User> users = new PageBean<>(list);
        LogUtil.info(users.getPages());
        for (User user : users.getList()) {
            LogUtil.info(user.toString());
        }

        Long end = System.currentTimeMillis();
        LogUtil.info("耗时:" + (end - start));

    }
}
