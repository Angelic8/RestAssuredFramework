package getRequest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.*;

import org.junit.jupiter.api.BeforeAll;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.Strings;
import io.restassured.response.ResponseBody;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.MatcherAssert.assertThat;
import java.math.BigDecimal;
import org.hamcrest.MatcherAssert;

public class GetData {

    public static RegexStrings regexStringsObj;

    @BeforeAll
    public void setupAPI() {

        baseURI = "http://api.openweathermap.org/data/2.5/find?q=London&appid=7eb8c4ae0df682ffe32eed392b2fc5e4";

    } // end method setupAPI()

    @Test(priority = 1)
    public void testResponseCode() {

        Response resp = given()
                .contentType(ContentType.JSON)
                .param("postId", "2")
                .when()
                .get("http://api.openweathermap.org/data/2.5/find?q=London&appid=7eb8c4ae0df682ffe32eed392b2fc5e4")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("list.name[0]", equalTo("London"))
                .assertThat().body("list.sys.country", hasItems("GB", "CA", "US", "US", "US"))
                //.assertThat().body("list.id[0]", equalTo(2643743))
                //.assertThat().body("list.main[0].temp", equalTo(282.03f))
                //.assertThat().body("list.wind[0].speed", equalTo(5.14f))
                .extract().response();

        Map jsonAsMap = new HashMap<>();

        int statusCode = resp.getStatusCode();
        long respTime = resp.getTime();
        ArrayList<String> listCountry = new ArrayList<String>();
        listCountry.add("GB");
        listCountry.add("CA");
        listCountry.add("US");
        listCountry.add("US");
        listCountry.add("US");

        Assert.assertEquals(200, statusCode);
        Assert.assertEquals(resp.jsonPath().getString("list.name[0]"), "London");
        Assert.assertEquals(resp.jsonPath().getDouble("list.wind[0].speed"), 2.57);
        Assert.assertEquals(resp.jsonPath().getString("list.sys.country"), listCountry.toString());
        Assert.assertEquals(resp.jsonPath().getString("list.weather[0].main").replaceAll(regexStringsObj.regexSymbols,""), "Haze");
        Assert.assertEquals(resp.jsonPath().getString("list.weather[0].description").replaceAll(regexStringsObj.regexSymbols,""), "haze");
        Assert.assertEquals(resp.jsonPath().getString("list.weather[0].icon").replaceAll(regexStringsObj.regexSymbols, ""), "50d");

        
        System.out.println("Response Time: " + respTime);
        System.out.println(resp.jsonPath().prettyPrint());

    } // end method testResponseCode()

} // end method GetData
