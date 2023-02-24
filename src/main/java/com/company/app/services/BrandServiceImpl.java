package com.company.app.services;

import com.company.app.model.Brand;
import com.company.app.repositories.BrandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    BrandRepository brandRepository;
    Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getBrands() throws Exception {
        try {
            List<Brand> brands = new ArrayList<>();
            brandRepository.findAll().forEach(brands::add);
            return brands;
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            throw new Exception(exception);
        }
    }

    @Override
    public Brand getBrandById(Long id) throws Exception {
        try {
            Optional<Brand> brandOpt = brandRepository.findById(id);
            if (brandOpt.isEmpty()) {
                throw new Exception(String.format("Brand %s is not found", id));
            }
            return brandOpt.get();
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            throw new Exception(exception);
        }
    }

    @Override
    public Brand insert(Brand brand) throws Exception {
        try {
            return brandRepository.save(brand);
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            throw new Exception(exception);
        }
    }

    @Override
    public void updateBrand(Long id, Brand brand) throws Exception {
        try {
            logger.info(String.format("Update brand %s", id));
            Optional<Brand> brandOpt = brandRepository.findById(id);
            if (brandOpt.isEmpty()) {
                throw new Exception(String.format("Brand %s is not found", id));
            }
            Brand brandFromDb = brandOpt.get();
            brandFromDb.setStatus(brand.getStatus());
            brandFromDb.setDescription(brand.getDescription());
            brandFromDb.setName(brand.getName());
            brandFromDb.setLogo(brand.getLogo());
            brandRepository.save(brandFromDb);
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            throw new Exception(exception);
        }
    }

    @Override
    public void deleteBrand(Long brandId) throws Exception {
        try {
            brandRepository.deleteById(brandId);
        } catch (Exception exception) {
            logger.error(exception.getMessage(), exception);
            throw new Exception(exception);
        }
    }
}
