package com.example.user.service;

import com.example.user.VO.Department;
import com.example.user.VO.ResponseTemplateVO;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser : UserService");
        return userRepository.save(user);
    }

    public User getUserById(Long userId) {
        log.info("Inside getUserById : UserService");
        return userRepository.findByUserId(userId);
    }

    public ResponseTemplateVO getDepartmentForUser(Long userId) {
        log.info("inside getDepartmentForUser : UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        /* to get the department, we have another microservice
        * we will get department from there
        */
        if (user == null) {
            log.error("user not found");
        }
        Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(), Department.class);
        vo.setDepartment(department);
        vo.setUser(user);

        return vo;
    }
}
