package com.openvarsity.cms.index.repo;

import com.openvarsity.cms.index.CourseDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CourseIndexRepository extends ElasticsearchRepository<CourseDocument,Long> {
}
