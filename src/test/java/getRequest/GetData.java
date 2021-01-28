package getRequest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetData {

    @Test
    public void testResponseCode(){

        Response resp = get("http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=7eb8c4ae0df682ffe32eed392b2fc5e4");

        int statusCode = resp.getStatusCode();
        long respTime = resp.getTime();

        System.out.println("Status code: " + statusCode);
        Assert.assertEquals(statusCode, 200);

        System.out.println("Response time: "  + respTime);

    } // end method testResponseCode()

    @Test
    public void testResponseAllData(){

        Response resp = get("http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=7eb8c4ae0df682ffe32eed392b2fc5e4");

        String allData = resp.asString();

        System.out.println("Data is: " + allData);

    } // end method testResponseAllData

} // end method GetData
