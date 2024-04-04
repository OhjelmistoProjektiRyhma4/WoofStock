package com.dogproductinventory.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.dogproductinventory.app.web.ManufacturerController;
import com.dogproductinventory.app.web.ProductController;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SmokeTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ManufacturerController manufacturerController;

    @Autowired
    private ProductController productController;

    @Test
    public void indexPageLoads() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class))
        .contains("etusivu");
    }

    @Test
    public void manufacturerListLoads() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/manufacturerlist", String.class))
        .contains("all manufacturers");
    }

    @Test
    public void productListLoads() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/productlist", String.class))
        .contains("all products");
    }

    @Test
    public void productControllerNotNull() {
        assertThat(productController).isNotNull();
    }

    @Test
    public void manufacturerControllerNotNull() {
        assertThat(manufacturerController).isNotNull();
    }
}


