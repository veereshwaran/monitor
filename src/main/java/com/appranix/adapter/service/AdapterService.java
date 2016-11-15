/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appranix.adapter.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author veeresh
 */
@Service
public interface AdapterService {
    public void adapterRead(int id) throws Exception;
    public int adapterCreate() throws Exception;
    public void adapterDelete(int id) throws Exception;
}
