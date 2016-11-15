/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appranix.adapter.controller;

import com.appranix.adapter.service.AdapterService;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author veeresh
 */
@RestController
@Component
public class AdapterMonitoring {

    @Autowired
    private AdapterService adapterServie;

    @RequestMapping("/adapter")
    public void TestAdapter(HttpServletResponse response) throws IOException {

        try {

            int id = adapterServie.adapterCreate();
            
            adapterServie.adapterRead(id);
            
            adapterServie.adapterDelete(id);

            System.out.println(id);

        } catch (Exception e) {
            response.sendError(400, e.getMessage());
        }
    }
}
