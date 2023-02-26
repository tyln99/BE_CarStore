package com.company.app.services;

import com.company.app.model.Model;
import com.company.app.repositories.ModelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {
    ModelRepository modelRepository;
    Logger logger = LoggerFactory.getLogger(ModelServiceImpl.class);

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<Model> getModels() throws Exception {
        try {
            List<Model> models = new ArrayList<>();
            modelRepository.findAll().forEach(models::add);
            return models;
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            throw new Exception(exception);
        }
    }

    @Override
    public List<Model> getModelsByBrand(Integer brandId) throws Exception {
        try {
            List<Model> models = new ArrayList<>();
            modelRepository.findAllByBrandId(brandId).forEach(models::add);
            return models;
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            throw new Exception(exception);
        }
    }

    @Override
    public Model getModelById(Long id) throws Exception {
        try {
            Optional<Model> modelOpt = modelRepository.findById(id);
            if (modelOpt.isEmpty()) {
                throw new Exception(String.format("Model %s not found", id));
            }
            return modelOpt.get();
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            throw new Exception(exception);
        }
    }

    @Override
    public Model insert(Model model) throws Exception {
        try {
            return modelRepository.save(model);
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            throw new Exception(exception);
        }
    }

    @Override
    public Model updateModel(Long id, Model model) throws Exception {
        try {
            logger.info(String.format("Update model %s", id));
            Optional<Model> modelOpt = modelRepository.findById(id);
            if (modelOpt.isEmpty()) {
                throw new Exception(String.format("Model %s not found", id));
            }
            Model modelFromDb = modelOpt.get();
            modelFromDb.setStatus(model.getStatus());
            modelFromDb.setDescription(model.getDescription());
            modelFromDb.setName(model.getName());
            modelFromDb.setPrice(model.getPrice());
            modelFromDb.setLogo(model.getLogo());
            return modelRepository.save(modelFromDb);
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            throw new Exception(exception);
        }
    }

    @Override
    public void deleteModel(Long modelId) throws Exception {
        try {
            modelRepository.deleteById(modelId);
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            throw new Exception(exception);
        }
    }
}
