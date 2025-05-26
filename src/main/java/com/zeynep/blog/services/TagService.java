package com.zeynep.blog.services;

import com.zeynep.blog.domain.entities.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getTags();
}
