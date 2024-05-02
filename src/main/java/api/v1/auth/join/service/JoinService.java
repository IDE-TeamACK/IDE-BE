package api.v1.auth.join.service;

import api.v1.domain.User;
import api.v1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JoinService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(User user){
        return userRepository.save(user).getId();
    }

    public boolean isNickname(String nickname){
        return userRepository.existsByNickname(nickname);
    }

    public boolean isKakaoId(Long kakaoId){
        return userRepository.existsByKakaoId(kakaoId);
    }

}