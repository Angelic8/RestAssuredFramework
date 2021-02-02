package getRequest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

public class GetData {

    public static RegexStrings regexStringsObj;

    @Test(priority = 1)
    public void testResponseHourlyForecast() {

        // Rest Assured - assertThat()
        Response resp = given()
                .contentType(ContentType.JSON)
                .param("postId", "2")
                .when()
                .get("http://api.openweathermap.org/data/2.5/find?q=London&appid=7eb8c4ae0df682ffe32eed392b2fc5e4")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("list.name[0]", equalTo("London"))
                .assertThat().body("list.sys.country", hasItems("GB", "CA", "US", "US", "US"))
                .assertThat().body("list.id[0]", equalTo(2643743))
                .assertThat().body("list.main[0].temp", equalTo(282.03f))
                .assertThat().body("list.wind[0].speed", equalTo(5.14f))
                .extract().response();

        // AssertEquals()
        Map jsonAsMap = new HashMap<>();
        int statusCode = resp.getStatusCode();
        long respTime = resp.getTime();

        ArrayList<String> listCountry = new ArrayList<String>();
        listCountry.add("GB");
        listCountry.add("CA");
        listCountry.add("US");
        listCountry.add("US");
        listCountry.add("US");

        ArrayList<Integer> listID = new ArrayList<Integer>();
        listID.add(2643743);
        listID.add(6058560);
        listID.add(4517009);
        listID.add(4298960);
        listID.add(5367815);

        String listIDToString = listID.toString().replaceAll(regexStringsObj.regexSymbols, "");

        Assert.assertEquals(200, statusCode);
        Assert.assertEquals(resp.jsonPath().getString("list.id").replaceAll(regexStringsObj.regexSymbols, ""), listIDToString);
        Assert.assertEquals(resp.jsonPath().getString("list.name[0]"), "London");
        Assert.assertEquals(resp.jsonPath().getDouble("list.coord[0].lat"), 51.5085);
        Assert.assertEquals(resp.jsonPath().getInt("list.main[0].humidity"), 87);
        Assert.assertEquals(resp.jsonPath().getDouble("list.wind[0].speed"), 3.6);
        Assert.assertEquals(resp.jsonPath().getString("list.sys.country"), listCountry.toString());
        Assert.assertEquals(resp.jsonPath().getInt("list.clouds[0].all"), 90);
        Assert.assertEquals(resp.jsonPath().getString("list.weather[0].main").replaceAll(regexStringsObj.regexSymbols, ""), "Clouds");
        Assert.assertEquals(resp.jsonPath().getString("list.weather[0].description").replaceAll(regexStringsObj.regexSymbols, ""), "overcast clouds");
        Assert.assertEquals(resp.jsonPath().getString("list.weather[0].icon").replaceAll(regexStringsObj.regexSymbols, ""), "04d");

        System.out.println("Response Time: " + respTime);
        System.out.println(resp.jsonPath().prettyPrint());

    } // end method testResponseHourlyForecast()

    @Test(priority = 2)
    public void testResponseCodeOfFrance() {

        Response resp = given()
                .contentType(ContentType.JSON)
                .urlEncodingEnabled(false)
                .when()
                .get("http://api.openweathermap.org/data/2.5/find?q=France&appid=7eb8c4ae0df682ffe32eed392b2fc5e4")
                .then().contentType(ContentType.JSON)
                .assertThat().statusCode(200)
                .assertThat().body("list.name", hasItems("France", "Republic of France"))
                .assertThat().body("list.sys.country", hasItems("CI", "FR"))
                .assertThat().log().all().body("list.id", hasItems(2288873, 3017382))
                .assertThat().body("list.weather[1].main[0]", equalTo("Drizzle"))
                .assertThat().body("list.weather.description[0]", hasItem("scattered clouds"))
                .assertThat().body("list.weather.icon[0]", hasItem("03d"))
                .extract().response();

    } // end method testResponseFiveDayForecast()

    @Test(priority = 3)
    public void testLoopResponseCode() {

        Response resp = given().when().get("http://api.openweathermap.org/data/2.5/find?q=France&appid=7eb8c4ae0df682ffe32eed392b2fc5e4");
        JsonPath jPath = new JsonPath(resp.asString());
        int size = jPath.getInt("list.size()");

        System.out.println("JSON Path: " + jPath);
        System.out.println("Response size: " + size);

        for (int i = 0; i < 1; i++) {
            System.out.println("ID: " + jPath.getString("list.id"));
            System.out.println("Name: " + jPath.getString("list.name"));
            System.out.println("Temperature: " + jPath.getString("list.main.temp"));
            System.out.println("Humidity: " + jPath.getString("list.main.humidity"));
            System.out.println("Wind's speed: " + jPath.getString("list.wind.speed"));
            System.out.println("Wind's latitude" + jPath.getString("list.coord.lat")); // horizontal
            System.out.println("Wind's longitude" + jPath.getString("list.coord.lon")); // vertical
            System.out.println("Wind's degrees: " + jPath.getString("list.wind.deg"));
            System.out.println("Clouds: " + jPath.getString("list.clouds.all"));
            System.out.println("Main weather: " + jPath.getString("list.weather.main"));
            System.out.println("Rain: " + jPath.getString("list.sys.rain"));

        }

    } // end method testLoopResponseCode()

} // end method GetData
