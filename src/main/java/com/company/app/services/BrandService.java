package com.company.app.services;


import com.company.app.model.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getBrands() throws Exception;

    Brand getBrandById(Long id) throws Exception;

    Brand insert(Brand brand) throws Exception;

    void updateBrand(Long id, Brand brand) throws Exception;

    void deleteBrand(Long brandId) throws Exception;
}
