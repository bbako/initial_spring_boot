package com.henry.initial.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    UserDao userDao;

    /**
     * Spring Security 필수 메소드 구현
     *
     * @param username
     * @return UserDetails
     * @throws UsernameNotFoundException 유저가 없을 때 예외 발생
     */
    @Override // 기본적인 반환 타입은 UserDetails, UserDetails를 상속받은 UserInfo로 반환 타입 지정 (자동으로 다운 캐스팅됨)
    public UserInfo loadUserByUsername(String username) throws UsernameNotFoundException { // 시큐리티에서 지정한 서비스이기 때문에 이 메소드를 필수로 구현
        return userRepository.findByUserId(username)
                .orElseThrow(() -> new UsernameNotFoundException((username)));
    }

    /**
     * 회원정보 저장
     *
     * @param infoDto 회원정보가 들어있는 DTO
     * @return 저장되는 회원의 PK
     */
    public String save(UserInfoDto infoDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        infoDto.setPassword(encoder.encode(infoDto.getPassword()));

        return userRepository.save(UserInfo.builder()
                .userId(infoDto.getUserId())
                .auth(infoDto.getAuth())
                .password(infoDto.getPassword())
                .enabled(false)
                .build()).getUserId();
    }

    public List<UserInfo> getUserList() {
        List<UserInfo> a = userRepository.findAll();
        return a;
    }

    public void makeUserEnabled(String userId) {
        userDao.makeUserEnabled(userId);
    }

    public void delUser(int no) {
        userDao.delUser(no);
    }
}
