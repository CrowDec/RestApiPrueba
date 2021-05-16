package com.manuel.drugstore.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication	
@org.springframework.stereotype.Controller
public class Controller {
	
	public static void main(String[] args) {
		SpringApplication.run(Controller.class, args);
	}
	
	@PostMapping(value = "/compara", 
					consumes = "application/json",
					produces = "application/json")
	public ResponseEntity<String> compara(@RequestBody Map<String,String[]> recetas) {
		
		String[] receta1= recetas.get("receta1");
		String[] list2 = recetas.get("receta2");
		String res = "";
		String rec = "";
		Map<String, String[]> result = new HashMap<>();
		for(int i=0;i<receta1.length;i++) {
			rec+= receta1[i] +" ";
		}
		
		
		for(int i = 0; i<list2.length; i++) {
			if(rec.indexOf(list2[i])!= -1){
				res += list2[i]+" ";
			}
		}
		
		result.put("coincidentes", res.split(" "));
		JSONObject json =  new JSONObject(result);
		return ResponseEntity.ok(json.toString());
	}
	
	
}
