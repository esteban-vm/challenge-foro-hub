package com.aluracursos.forohub.domains.topic;

import com.aluracursos.forohub.domains.course.CourseRepository;
import com.aluracursos.forohub.domains.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TopicRepository topicRepository;

    public TopicDetailData register(TopicRegisterData data) {
        var topic = new Topic(data);
        return null;
    }
}
