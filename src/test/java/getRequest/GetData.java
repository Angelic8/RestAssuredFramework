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
    protected static Response resp;
    protected static JsonPath jPath;

    /*
        @Test(priority = 1)
        public void testResponseHourlyForecast() {

            // Rest Assured - assertThat()
            resp = given()
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
    *//*
    @Test(priority = 2)
    public void testResponseCodeOfFrance() {

        resp = given()
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
*//*
    @Test(priority = 3)
    public void testLoopResponseCode() {

        resp = given().when().get("http://api.openweathermap.org/data/2.5/find?q=France&appid=7eb8c4ae0df682ffe32eed392b2fc5e4");
        jPath = new JsonPath(resp.asString());
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
*/
    @Test(priority = 1)
    public void testReqresResponseCode() {

        // Get the endpoint's URL
        resp = given().get("https://reqres.in/api/users?page=2");
        resp.then()
                .statusCode(200)
                .log().all();

        // Call the jPath and convert the endpoint to a String
        jPath = new JsonPath(resp.asString());

        // Get the size of the endpoint
        int size = jPath.getInt("data.size()");
        System.out.println("API's size is: " + size);

        // Create an arraylist for assertEquals
        ArrayList<Integer> dataID = new ArrayList<Integer>();
        dataID.add(7);
        dataID.add(8);
        dataID.add(9);
        dataID.add(10);
        dataID.add(11);
        dataID.add(12);
        // Convert the Arraylist; Replace regex symbols to String - endpoint for assertion is a String not an integer
        String dataIDToString = dataID.toString().replaceAll(regexStringsObj.regexSymbols,"");

        ArrayList<String> datasEmail = new ArrayList<String>();
        datasEmail.add("michael.lawson@reqres.in");
        datasEmail.add("lindsay.ferguson@reqres.in");
        datasEmail.add("tobias.funke@reqres.in");
        datasEmail.add("byron.fields@reqres.in");
        datasEmail.add("george.edwards@reqres.in");
        datasEmail.add("rachel.howell@reqres.in");
        String datasEmailToString = datasEmail.toString().replaceAll(regexStringsObj.regexSymbols,"");

        ArrayList<String> dataFname = new ArrayList<String>();
        dataFname.add("Michael");
        dataFname.add("Lindsay");
        dataFname.add("Tobias");
        dataFname.add("Byron");
        dataFname.add("George");
        dataFname.add("Rachel");
        String dataFnameToString = dataFname.toString().replaceAll(regexStringsObj.regexSymbols,"");

        ArrayList<String> dataLname = new ArrayList<String>();
        dataLname.add("Lawson");
        dataLname.add("Ferguson");
        dataLname.add("Funke");
        dataLname.add("Fields");
        dataLname.add("Edwards");
        dataLname.add("Howell");
        String dataLnameToString = dataLname.toString().replaceAll(regexStringsObj.regexSymbols,"");

        // Loop through the endpoint's array; do assertions and print for display
        for(int i=0; i<6; i++){

            Assert.assertEquals(jPath.getString("data.id").replaceAll(regexStringsObj.regexSymbols,""), dataIDToString);
            Assert.assertEquals(jPath.getString("data.email").replaceAll(regexStringsObj.regexSymbols,""),datasEmailToString);
            Assert.assertEquals(jPath.getString("data.first_name").replaceAll(regexStringsObj.regexSymbols,""), dataFnameToString);
            Assert.assertEquals(jPath.getString("data.last_name").replaceAll(regexStringsObj.regexSymbols,""), dataLnameToString);

            System.out.println("\nIDs: " + jPath.getString("data.id").replaceAll(regexStringsObj.regexSymbols,""));
            System.out.println("Email addresses: " + jPath.getString("data.email").replaceAll(regexStringsObj.regexSymbols,""));
            System.out.println("Firstnames: " + jPath.getString("data.first_name").replaceAll(regexStringsObj.regexSymbols,""));
            System.out.println("Lastnames: " + jPath.getString("data.last_name").replaceAll(regexStringsObj.regexSymbols,""));

        } // end for-loop

    } // end method

} // end class GetData