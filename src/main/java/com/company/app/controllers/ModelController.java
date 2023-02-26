package com.company.app.controllers;

import com.company.app.model.Model;
import com.company.app.services.ModelService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/model")
@CrossOrigin
public class ModelController {
    ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping
    public ResponseEntity<List<Model>> getAllModels() {
        try {
            List<Model> models = modelService.getModels();
            return new ResponseEntity<>(models, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/getByBrand"})
    public ResponseEntity<List<Model>> getModelsByBrand(@RequestParam("brandId") String brandId) {
        try {
            List<Model> models = modelService.getModelsByBrand(Integer.valueOf(brandId));
            return new ResponseEntity<>(models, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/{modelId}"})
    public ResponseEntity<Model> getModel(@PathVariable Long modelId) {
        try {
            return new ResponseEntity<>(modelService.getModelById(modelId), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Model> saveModel(@RequestBody Model model) {
        try {
            Model model1 = modelService.insert(model);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("model", "/api/v1/model/" + model1.getId().toString());
            return new ResponseEntity<>(model1, httpHeaders, HttpStatus.CREATED);
        }  catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping({"/{modelId}"})
    public ResponseEntity<Model> updateModel(@PathVariable("modelId") Long modelId, @RequestBody Model model) {
        try {
            modelService.updateModel(modelId, model);
            return new ResponseEntity<>(modelService.getModelById(modelId), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping({"/{modelId}"})
    public ResponseEntity<Model> deleteModel(@PathVariable("modelId") Long modelId) {
        try {
            modelService.deleteModel(modelId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
