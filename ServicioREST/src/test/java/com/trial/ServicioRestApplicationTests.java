package com.trial;

import com.trial.entities.Coche;
import com.trial.entities.ElMapper;
import com.trial.exceptions.MiExcepcion;
import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.nio.charset.Charset;
import java.util.Set;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Mockito.*;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.integers;
import static org.quicktheories.generators.SourceDSL.strings;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ServicioRestApplicationTests {
    @Autowired
    private MockMvc mockmvc;

    @Test
    public void contextLoads() {
    }

    @Test(timeout = 5000)
    public void whenRequestingAResourceThenLinksToResourcesMustBeReturned() {

        String body = RestAssured
                .given()
                .baseUri("http://swapi.co/api")
                .and()
                .queryParam("format", "json")
                .when()
                .get("/")
                .then()
                .log().all()
                .and().assertThat().statusCode(is(equalTo(200)))
                .and()
                .body("films", response -> notNullValue())
                .body("vehicles", response -> notNullValue())
                .body("people", response -> notNullValue())
                .body("starships", response -> notNullValue())
                .body("species", response -> notNullValue())
                .body("planets", response -> notNullValue())
                .and().extract().body().asString();
    }

    @Test
    public void validarCoche() throws Exception {
        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
        Coche toyota = new Coche("toyota", 200, 5);
        String elcoche = "{\"marca\":\"toyota\",\"caballos\":\"200\"}";
        mockmvc.perform(
                MockMvcRequestBuilders.post("/postc").content(elcoche).contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(elcoche));
    }

    private ElMapper mapper
            = Mappers.getMapper(ElMapper.class);

    @Test
    public void cocheDTO() throws MiExcepcion {
        Coche coche = new Coche(null, 12000, 213);
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Coche>> violaciones = validator.validate(coche);
        assert (violaciones != null);

        //valores de las validaciones desde un ficheroo la clase
        qt().forAll(strings().basicLatinAlphabet().ofLengthBetween(4, 21), integers().between(75, 1000),
                integers().between(3, 7)).as(Coche::new)
                .check(coche1 -> mapper.cocheToDTO(coche1).getNombreMarca().equalsIgnoreCase(coche1.getMarca()));
    }

    @Test
    public void assured() {
        get("/coche").then().statusCode(200).assertThat().body("marca",equalTo("mercedes"));
    }
    @Test
    public void refeq(){
        Coche coche = Mockito.mock(Coche.class);
        coche.pitar("ssss");
        verify(coche).pitar(Mockito.refEq("ssss"));

    }
}
