package com.company.app.controllers;

import com.company.app.model.Brand;
import com.company.app.services.BrandService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brand")
public class BrandController {
    BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrands() {
        try {
            List<Brand> brands = brandService.getBrands();
            return new ResponseEntity<>(brands, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping({"/{brandId}"})
    public ResponseEntity<Brand> getBrand(@PathVariable Long brandId) {
        try {
            return new ResponseEntity<>(brandService.getBrandById(brandId), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Brand> saveBrand(@RequestBody Brand brand) {
        try {
            Brand brand1 = brandService.insert(brand);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("brand", "/api/v1/brand/" + brand1.getId().toString());
            return new ResponseEntity<>(brand1, httpHeaders, HttpStatus.CREATED);
        }  catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping({"/{brandId}"})
    public ResponseEntity<Brand> updateBrand(@PathVariable("brandId") Long brandId, @RequestBody Brand brand) {
        try {
            brandService.updateBrand(brandId, brand);
            return new ResponseEntity<>(brandService.getBrandById(brandId), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping({"/{brandId}"})
    public ResponseEntity<Brand> deleteBrand(@PathVariable("brandId") Long brandId) {
        try {
            brandService.deleteBrand(brandId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
