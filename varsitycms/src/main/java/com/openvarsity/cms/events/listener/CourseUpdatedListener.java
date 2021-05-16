package com.openvarsity.cms.events.listener;

import com.openvarsity.cms.db.dto.CourseDto;
import com.openvarsity.cms.events.CourseUpdated;
import com.openvarsity.cms.index.CourseDocument;
import com.openvarsity.cms.index.repo.CourseIndexRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CourseUpdatedListener implements ApplicationListener<CourseUpdated> {

    @Autowired
    private CourseIndexRepository courseIndexRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void onApplicationEvent(CourseUpdated courseUpdated) {
        final Object obj = courseUpdated.getSource();
        if(obj!=null) {
            final CourseDto dto = (CourseDto) obj;
            log.info("Dto to be updated to elastic search::{}",dto);
            CourseDocument courseDocument = modelMapper.map(dto, CourseDocument.class);
            courseIndexRepository.save(courseDocument);
        }
    }
}
