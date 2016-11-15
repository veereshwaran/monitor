/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appranix.adapter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author veeresh
 */
@Service
public class AdapterServiceImpl implements AdapterService {
    

    @Override
    public void adapterRead(int id) throws Exception {
        try {
            final String uri = "http://localhost:9090/adapter/rest/cm/simple/cis/" + id;

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

            System.out.println(result);

        } catch (Exception e) {
            throw new Exception("Error in Read Operation");
        }
    }

    @Override
    public int adapterCreate() throws Exception {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode node = mapper.createObjectNode();
            node.put("nsPath", "/");
            node.put("ciClassName", "Component");
            node.put("ciName", "test");

            final String uri = "http://localhost:9090/adapter/rest/cm/simple/cis";

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> result = restTemplate.postForEntity(uri, node, String.class);

            Map<String, Integer> map = mapper.readValue(result.getBody(), Map.class);

            Integer id = map.get("ciId");

            return id;
        } catch (Exception e) {
            throw new Exception("Error in Write Operation");
        }
    }

    @Override
    public void adapterDelete(int id) throws Exception {
        final String uri = "http://localhost:9090/adapter/rest/cm/simple/cis/{id}";
        
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", id);
        
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri, params);
    }
}
