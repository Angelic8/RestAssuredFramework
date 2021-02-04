package getRequest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

import javax.swing.*;

public class GetData {

    public static RegexStrings regexStringsObj;
    protected static Response resp;
    protected static JsonPath jPath;

    /*
            @Test(priority = 1)
            public void testResponseHourlyForecast() {

                Map jsonAsMap;
                int statusCode;
                long respTime;
                ArrayList<String> listCountry;
                ArrayList<Integer> listID;
                String listIDToString;

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

                jsonAsMap = new HashMap<>();
                statusCode = resp.getStatusCode();
                respTime = resp.getTime();

                listCountry = new ArrayList<String>();
                listCountry.add("GB");
                listCountry.add("CA");
                listCountry.add("US");
                listCountry.add("US");
                listCountry.add("US");

                listID = new ArrayList<Integer>();
                listID.add(2643743);
                listID.add(6058560);
                listID.add(4517009);
                listID.add(4298960);
                listID.add(5367815);
                listIDToString = listID.toString().replaceAll(regexStringsObj.regexSymbols, "");

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
    */ /*
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
*/ /*
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
*/ /*
    @Test(priority = 1)
    public void testReqresResponseCode() {

        String dataIDToString, datasEmailToString, dataFnameToString, dataLnameToString;
        int size;
        ArrayList<Integer> dataID;
        ArrayList<String> dataFname, dataLname, datasEmail;

        // Get the endpoint's URL
        resp = given().get("https://reqres.in/api/users?page=2");
        resp.then()
                .statusCode(200)
                .log().all();

        // Call the jPath and convert the endpoint to a String
        jPath = new JsonPath(resp.asString());

        // Get the size of the endpoint
        size = jPath.getInt("data.size()");
        System.out.println("API's size is: " + size);

        // Create an arraylist for assertEquals
        dataID = new ArrayList<Integer>();
        dataID.add(7);
        dataID.add(8);
        dataID.add(9);
        dataID.add(10);
        dataID.add(11);
        dataID.add(12);
        // Convert the Arraylist; Replace regex symbols with String - endpoint for assertion is a String not an integer
        dataIDToString = dataID.toString().replaceAll(regexStringsObj.regexSymbols,"");

        datasEmail = new ArrayList<String>();
        datasEmail.add("michael.lawson@reqres.in");
        datasEmail.add("lindsay.ferguson@reqres.in");
        datasEmail.add("tobias.funke@reqres.in");
        datasEmail.add("byron.fields@reqres.in");
        datasEmail.add("george.edwards@reqres.in");
        datasEmail.add("rachel.howell@reqres.in");
        datasEmailToString = datasEmail.toString().replaceAll(regexStringsObj.regexSymbols,"");

        dataFname = new ArrayList<String>();
        dataFname.add("Michael");
        dataFname.add("Lindsay");
        dataFname.add("Tobias");
        dataFname.add("Byron");
        dataFname.add("George");
        dataFname.add("Rachel");
        dataFnameToString = dataFname.toString().replaceAll(regexStringsObj.regexSymbols,"");

        dataLname = new ArrayList<String>();
        dataLname.add("Lawson");
        dataLname.add("Ferguson");
        dataLname.add("Funke");
        dataLname.add("Fields");
        dataLname.add("Edwards");
        dataLname.add("Howell");
        dataLnameToString = dataLname.toString().replaceAll(regexStringsObj.regexSymbols,"");

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
*/
    @Test(priority = 1)
    public void testCircuitsResponseCode() {

        int size;
        ArrayList<String> circuitIDs, circuitName, locality, country;
        ArrayList<Double> longLocation, latLocation;
        String circuitIDToString, circuitNameToString, latToString, longToString, localityToString, countryToString, circuitsCircID, circuitsCircName, circuitsLocationLat, circuitsLocationLong, circuitsLocationLocality, circuitsLocationCountry;

        resp = given().get("http://ergast.com/api/f1/2017/circuits.json");
        //resp.then().log().all();

        jPath = new JsonPath(resp.asString());
        size = jPath.getInt("MRData.CircuitTable.Circuits.size()");
        System.out.println("API's size: " + size);

        circuitIDs = new ArrayList<String>();
        circuitIDs.add("albert_park");
        circuitIDs.add("americas");
        circuitIDs.add("bahrain");
        circuitIDs.add("BAK");
        circuitIDs.add("catalunya");
        circuitIDs.add("hungaroring");
        circuitIDs.add("interlagos");
        circuitIDs.add("marina_bay");
        circuitIDs.add("monaco");
        circuitIDs.add("monza");
        circuitIDs.add("red_bull_ring");
        circuitIDs.add("rodriguez");
        circuitIDs.add("sepang");
        circuitIDs.add("shanghai");
        circuitIDs.add("silverstone");
        circuitIDs.add("sochi");
        circuitIDs.add("spa");
        circuitIDs.add("suzuka");
        circuitIDs.add("villeneuve");
        circuitIDs.add("yas_marina");
        circuitIDToString = circuitIDs.toString().replaceAll(regexStringsObj.regexSymbols, "");

        circuitName = new ArrayList<String>();
        circuitName.add("Albert Park Grand Prix Circuit");
        circuitName.add("Circuit of the Americas");
        circuitName.add("Bahrain International Circuit");
        circuitName.add("Baku City Circuit");
        circuitName.add("Circuit de Barcelona-Catalunya");
        circuitName.add("Hungaroring");
        circuitName.add("Autódromo José Carlos Pace");
        circuitName.add("Marina Bay Street Circuit");
        circuitName.add("Circuit de Monaco");
        circuitName.add("Autodromo Nazionale di Monza");
        circuitName.add("Red Bull Ring");
        circuitName.add("Autódromo Hermanos Rodríguez");
        circuitName.add("Sepang International Circuit");
        circuitName.add("Shanghai International Circuit");
        circuitName.add("Silverstone Circuit");
        circuitName.add("Sochi Autodrom");
        circuitName.add("Circuit de Spa-Francorchamps");
        circuitName.add("Suzuka Circuit");
        circuitName.add("Circuit Gilles Villeneuve");
        circuitName.add("Yas Marina Circuit");
        circuitNameToString = circuitName.toString().replaceAll(regexStringsObj.regexSymbols, "");

        latLocation = new ArrayList<Double>();
        latLocation.add(-37.8497);
        latLocation.add(30.1328);
        latLocation.add(26.0325);
        latLocation.add(40.3725);
        latLocation.add(41.57);
        latLocation.add(47.5789);
        latLocation.add(-23.7036);
        latLocation.add(1.2914);
        latLocation.add(43.7347);
        latLocation.add(45.6156);
        latLocation.add(47.2197);
        latLocation.add(19.4042);
        latLocation.add(2.76083);
        latLocation.add(31.3389);
        latLocation.add(52.0786);
        latLocation.add(43.4057);
        latLocation.add(50.4372);
        latLocation.add(34.8431);
        latLocation.add(45.5);
        latLocation.add(24.4672);
        latToString = latLocation.toString().replaceAll(regexStringsObj.regexSymbols, "");

        longLocation = new ArrayList<Double>();
        longLocation.add(144.968);
        longLocation.add(-97.6411);
        longLocation.add(50.5106);
        longLocation.add(49.8533);
        longLocation.add(2.26111);
        longLocation.add(19.2486);
        longLocation.add(-46.6997);
        longLocation.add(103.864);
        longLocation.add(7.42056);
        longLocation.add(9.28111);
        longLocation.add(14.7647);
        longLocation.add(-99.0907);
        longLocation.add(101.738);
        longLocation.add(121.22);
        longLocation.add(-1.01694);
        longLocation.add(39.9578);
        longLocation.add(5.97139);
        longLocation.add(136.541);
        longLocation.add(-73.5228);
        longLocation.add(54.6031);
        longToString = longLocation.toString().replaceAll(regexStringsObj.regexSymbols, "");

        locality = new ArrayList<String>();
        locality.add("Melbourne");
        locality.add("Austin");
        locality.add("Sakhir");
        locality.add("Baku");
        locality.add("Montmeló");
        locality.add("Budapest");
        locality.add("São Paulo");
        locality.add("Marina Bay");
        locality.add("Monte-Carlo");
        locality.add("Monza");
        locality.add("Spielburg");
        locality.add("Mexico City");
        locality.add("Kuala Lumpur");
        locality.add("Shanghai");
        locality.add("Silverstone");
        locality.add("Sochi");
        locality.add("Spa");
        locality.add("Suzuka");
        locality.add("Montreal");
        locality.add("Abu Dhabi");
        localityToString = locality.toString().replaceAll(regexStringsObj.regexSymbols, "");

        country = new ArrayList<String>();
        country.add("Australia");
        country.add("USA");
        country.add("Bahrain");
        country.add("Azerbaijan");
        country.add("Spain");
        country.add("Hungary");
        country.add("Brazil");
        country.add("Singapore");
        country.add("Monaco");
        country.add("Italy");
        country.add("Austria");
        country.add("Mexico");
        country.add("Malaysia");
        country.add("China");
        country.add("UK");
        country.add("Russia");
        country.add("Belgium");
        country.add("Japan");
        country.add("Canada");
        country.add("UAE");
        countryToString = country.toString().replaceAll(regexStringsObj.regexSymbols, "");

        circuitsCircID = jPath.getString("MRData.CircuitTable.Circuits.circuitId");
        circuitsCircName = jPath.getString("MRData.CircuitTable.Circuits.circuitName");
        circuitsLocationLat = jPath.getString("MRData.CircuitTable.Circuits.Location.lat");
        circuitsLocationLong = jPath.getString("MRData.CircuitTable.Circuits.Location.long");
        circuitsLocationLocality = jPath.getString("MRData.CircuitTable.Circuits.Location.locality");
        circuitsLocationCountry = jPath.getString("MRData.CircuitTable.Circuits.Location.country");

        for (int i=0; i<1; i++){

            Assert.assertEquals(circuitsCircID.replaceAll(regexStringsObj.regexSymbols, ""),circuitIDToString);
            Assert.assertEquals(circuitsCircName.replaceAll(regexStringsObj.regexSymbols, ""),circuitNameToString);
            Assert.assertEquals(circuitsLocationLat.replaceAll(regexStringsObj.regexSymbols, ""), latToString);
            Assert.assertEquals(circuitsLocationLong.replaceAll(regexStringsObj.regexSymbols, ""), longToString);
            Assert.assertEquals(circuitsLocationLocality.replaceAll(regexStringsObj.regexSymbols, ""), localityToString);
            Assert.assertEquals(circuitsLocationCountry.replaceAll(regexStringsObj.regexSymbols, ""), countryToString);

            System.out.println("\nCircuit ID: " + circuitsCircID.replaceAll(regexStringsObj.regexSymbols, ""));
            System.out.println("Circuit Name: " + circuitsCircName.replaceAll(regexStringsObj.regexSymbols, ""));
            System.out.println("Location's Latitude: " + circuitsLocationLat.replaceAll(regexStringsObj.regexSymbols, ""));
            System.out.println("Location's Longitude: " + circuitsLocationLong.replaceAll(regexStringsObj.regexSymbols, ""));
            System.out.println("Location's Locality: " + circuitsLocationLocality.replaceAll(regexStringsObj.regexSymbols, ""));
            System.out.println("Country: " + circuitsLocationCountry.replaceAll(regexStringsObj.regexSymbols, ""));

        } // end for-loop

    } // end method testCircuitsResponseCode

} // end class GetData