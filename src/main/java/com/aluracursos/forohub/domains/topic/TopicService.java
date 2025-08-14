package com.aluracursos.forohub.domains.topic;

import com.aluracursos.forohub.domains.course.CourseRepository;
import com.aluracursos.forohub.domains.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TopicRepository topicRepository;

    public Page<TopicDetailData> getAll(Pageable pageable) {
        return topicRepository.findAllByStatus(TopicStatus.ACTIVE, pageable).map(TopicDetailData::new);
    }

    public TopicDetailData getOne(Long id) {
        var topic = topicRepository.getReferenceById(id);
        return new TopicDetailData(topic);
    }

    public TopicDetailData register(TopicRegisterData data) {
        var author = userRepository.getReferenceById(data.authorId());
        var course = courseRepository.getReferenceById(data.courseId());
        var topic = new Topic(data, author, course);
        topicRepository.save(topic);
        return new TopicDetailData(topic);
    }

    public TopicDetailData update(Long id, TopicUpdateData data) {
        var optTopic = topicRepository.findById(id);

        if (optTopic.isPresent()) {
            var topic = optTopic.get();

            if (topic.getStatus() == TopicStatus.ACTIVE) {
                topic.update(data);
                return new TopicDetailData(topic);
            }
        }

        return null;
    }

    public void delete(Long id) {
        var optTopic = topicRepository.findById(id);
        optTopic.ifPresent(topic -> topicRepository.deleteById(topic.getId()));
    }

    public void close(Long id) {
        var optTopic = topicRepository.findById(id);

        if (optTopic.isPresent()) {
            var topic = optTopic.get();
            topic.setStatus(TopicStatus.CLOSED);
            topicRepository.save(topic);
        }
    }

}
