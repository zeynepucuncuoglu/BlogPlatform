package com.zeynep.blog.services.impl;

import com.zeynep.blog.domain.dtos.TagResponse;
import com.zeynep.blog.domain.entities.Tag;
import com.zeynep.blog.repositories.TagRepository;
import com.zeynep.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<Tag> getTags() {
        return tagRepository.findAllWithPostCount();
    }
}
