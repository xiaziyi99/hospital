package hospital.authserver.config.service;
import hospital.authserver.service.TbPermissionService;
import hospital.authserver.service.TbUserService;
import hospital.authserver.domain.TbPermission;
import hospital.authserver.domain.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TbUserService userService;
    @Autowired
    private TbPermissionService permissionService;
    /**
     * 查询数据库用户信息
     *
     * @param username 登录账户
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser tbUser = userService.getUserByUsername(username);
        //验证账户为username的用户是否存在
        if (null == tbUser){
            throw new UsernameNotFoundException("username:  " + username + "is not exist!");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        //获取用户权限
        List<TbPermission> permissions = permissionService.getByUserid(tbUser.getId());
        //设置用户权限
        permissions.forEach(permission -> {
            authorities.add(new SimpleGrantedAuthority(permission.getEname()));
        });

        //返回认证用户
        return new User(tbUser.getUsername(), tbUser.getPassword(), authorities);
    }
}
