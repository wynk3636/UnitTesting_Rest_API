package method;


import io.restassured.RestAssured;

//import static io.restassured.matcher.ResponseAwareMatcher.*;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

import org.json.JSONException;
import org.json.JSONObject;

public class Api_Testing {
	
	public void Api_Testing01(){

		String baseUri_val = "http://jsonplaceholder.typicode.com/";
		
		//givent()　で開始し、get(url)でGET Methodでアクセス、then()の後にその結果についての操作がかかれ、ここではbody()メソッドでResponseのJSONをパス式で解析してAssertionを実行しています。
		//bodyでJSONのキーを指定
		RestAssured.baseURI = baseUri_val;
			given()
				.get("/posts/2")
			.then();
			
		/*
		 * 
		 RestAssured.baseURI = baseUri_val;
			given()
				.get("/posts/2")
			.then()
				.body("userID",equalTo(1))
				.body("id", equalTo(2))
				.body("title", equalTo("qui est esse"));
		 * 
		 */
			
			//consoleに表示
			given()
				.get("/posts/2").prettyPrint();
			
			//１回受け取る
			String response = get("/posts/2").asString();
			System.out.println(response);
			
			//JSONで取得箇所指定
			try {
				JSONObject obj = new JSONObject(response);
				System.out.println(obj.get("title"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			String baseUri_val2 = "http://ergast.com/api/f1/2017/";
			RestAssured.baseURI = baseUri_val2;
				given().
				when().
					get("/circuits.json").
				then().
					assertThat().
					statusCode(200);
			
			try {
				String response2 = get("/circuits.json").asString();
				JSONObject obj2 = new JSONObject(response2);
				//System.out.println(obj2.get("MRData.CircuitTable.Circuits.circuitId[0]"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
