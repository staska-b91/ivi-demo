package ivi;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * класс описывает спец-ции, общие для всех запросов(прописание логов rq и rs)
 */
public class SpecificationFactory {

    public static RequestSpecification reqSpec() {
        return new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
    public static ResponseSpecification respSpec() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}
