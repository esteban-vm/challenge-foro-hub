package com.aluracursos.forohub.domains.topic;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService service;

    @GetMapping
    public ResponseEntity<Page<TopicDetailData>> getAll(@PageableDefault(size = 15, sort = {"createdAt"}) Pageable pageable) {
        var topics = service.getAll(pageable);
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDetailData> getOne(@PathVariable Long id) {
        var topic = service.getOne(id);
        return ResponseEntity.ok(topic);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<TopicDetailData> register(@RequestBody @Valid TopicRegisterData data, UriComponentsBuilder builder) {
        var topic = service.register(data);
        var uri = builder.path("/topics/{id}").buildAndExpand(topic.id()).toUri();
        return ResponseEntity.created(uri).body(topic);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<TopicDetailData> update(@PathVariable Long id, @RequestBody @Valid TopicUpdateData data) {
        var topic = service.update(id, data);

        if (topic == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(topic);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @DeleteMapping("/close/{id}")
    public ResponseEntity<Void> close(@PathVariable Long id) {
        service.close(id);
        return ResponseEntity.noContent().build();
    }

}
