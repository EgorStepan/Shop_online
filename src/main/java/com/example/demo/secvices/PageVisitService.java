package com.example.demo.secvices;

import com.example.demo.models.PageVisit;
import com.example.demo.repositories.PageVisitRepository;
import org.springframework.stereotype.Service;

@Service
public class PageVisitService {
    private final PageVisitRepository pageVisitRepository;

    public PageVisitService(PageVisitRepository pageVisitRepository) {
        this.pageVisitRepository = pageVisitRepository;
    }


    public int incrementVisitCount(String pageName) {
        PageVisit pageVisit = pageVisitRepository.findById(pageName).orElse(new PageVisit());
        pageVisit.setPageName(pageName);
        pageVisit.setVisitCount(pageVisit.getVisitCount() + 1);
        pageVisitRepository.save(pageVisit);
        return pageVisit.getVisitCount();
    }
}