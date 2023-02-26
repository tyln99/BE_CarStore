package com.company.app.services;

import com.company.app.model.Model;

import java.util.List;

public interface ModelService {
    List<Model> getModels() throws Exception;

    List<Model> getModelsByBrand(Integer brandId) throws Exception;

    Model getModelById(Long id) throws Exception;

    Model insert(Model brand) throws Exception;

    Model updateModel(Long id, Model model) throws Exception;

    void deleteModel(Long brandId) throws Exception;
}
