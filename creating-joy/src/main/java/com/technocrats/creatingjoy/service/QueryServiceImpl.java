package com.technocrats.creatingjoy.service;

import com.technocrats.creatingjoy.dao.QueryRepository;
import com.technocrats.creatingjoy.dto.QueryDTO;
import com.technocrats.creatingjoy.entity.Query;
import com.technocrats.creatingjoy.objectmapper.QueryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class QueryServiceImpl implements QueryService{

    private QueryRepository queryRepository;

    @Autowired
    private QueryMapper queryMapper;

    @Autowired
    public QueryServiceImpl(QueryRepository queryRepository) {

        this.queryRepository = queryRepository;
    }

    @Override
    @Transactional
    public List<QueryDTO> findAll() {

        List<Query> queries=new ArrayList<>();
        queries=queryRepository.findAll();

        List<QueryDTO> queryDTOS=new ArrayList<>();

        for(Query query:queries){

            queryDTOS.add(queryMapper.convertToDto(query));
        }

        return queryDTOS;
    }

    @Override
    @Transactional
    public List<QueryDTO> findByCategoryId(int id) {

        List<Query> queries=new ArrayList<>();
        queries=queryRepository.findByCategoryId(id);

        List<QueryDTO> queryDTOS = new ArrayList<>();
        for(Query query: queries) {
            queryDTOS.add(queryMapper.convertToDto(query));
        }

        return queryDTOS;
    }


    @Override
    @Transactional
    public List<QueryDTO> findByRequestorIdOrAcceptorId(int id1,int id2) {
        List<Query> queries=new ArrayList<>();
        queries=queryRepository.findByRequestorIdOrAcceptorId(id1,id2);

        List<QueryDTO> queryDTOS = new ArrayList<>();
        for(Query query: queries) {
            queryDTOS.add(queryMapper.convertToDto(query));
        }

        return queryDTOS;

    }

    @Override
    @Transactional
    public QueryDTO findById(int id) {
        Optional<Query> result=queryRepository.findById(id);


        if(result.isPresent()){
            return queryMapper.convertToDto(result.get());
        }
        else{
            throw new RuntimeException("Did not found Query with id "+id);
        }


    }


    @Override
    @Transactional
    public void save(QueryDTO queryDTO) {

        Query query=queryMapper.convertToEntity(queryDTO);
        queryRepository.save(query);

    }

    @Override
    @Transactional
    public void deleteById(int id) {

        if(id>0) {
            queryRepository.deleteById(id);
        }



    }


}
