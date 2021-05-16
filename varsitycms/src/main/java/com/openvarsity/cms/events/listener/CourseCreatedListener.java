package com.openvarsity.cms.events.listener;

import com.openvarsity.cms.db.dto.CourseDto;
import com.openvarsity.cms.events.CourseCreated;
import com.openvarsity.cms.index.CourseDocument;
import com.openvarsity.cms.index.repo.CourseIndexRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CourseCreatedListener implements ApplicationListener<CourseCreated> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CourseIndexRepository courseIndexRepository;

    @Override
    public void onApplicationEvent(CourseCreated courseCreated) {
        final Object obj = courseCreated.getSource();
        if(obj!=null) {
            final CourseDto dto = (CourseDto) obj;
            log.info("Dto to be published to elastic search::{}",dto);
            CourseDocument courseDocument = modelMapper.map(dto, CourseDocument.class);
            courseIndexRepository.save(courseDocument);
        }
    }
}
