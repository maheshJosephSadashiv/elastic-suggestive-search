package com.example.elasticsearchsuggestivesearch.repository;

import com.example.elasticsearchsuggestivesearch.domain.elasticsearch.Vehicle;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface TaskRepository extends ElasticsearchRepository<Vehicle, String> {

    @Query("  {\n" +
            "                \"bool\": {\n" +
            "                    \"must\": [\n" +
            "                        {\n" +
            "                            \"match_phrase_prefix\": {\n" +
            "                                \"licensePlate\": {\n" +
            "                                    \"query\": \"?0\"\n" +
            "                                }\n" +
            "                            }\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"filter\": [],\n" +
            "                    \"should\": [],\n" +
            "                    \"must_not\": []\n" +
            "                }\n" +
            "            }")

    List<Vehicle> autoCompleteVehicleLpNaiveApproach(String inputString);
}
