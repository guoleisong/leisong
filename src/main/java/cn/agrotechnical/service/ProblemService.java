package cn.agrotechnical.service;

import cn.agrotechnical.pojo.Problem;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface ProblemService {

    Page<Problem> newlitst(String labelid, int page, int size);

    Page<Problem> hotlitst(String labelid, int page, int size);

    Page<Problem> waitlitst(String labelid, int page, int size);

    public List<Problem> findAll();

    Problem findById(String id);

    Page<Problem> findSearch(Map searchMap, int page, int size);

    void add(Problem problem);

    void update(Problem problem);

    void deleteById(String id);


}
