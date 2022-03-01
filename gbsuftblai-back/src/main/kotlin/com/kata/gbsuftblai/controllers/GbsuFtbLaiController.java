package com.kata.gbsuftblai.controllers;

import com.kata.gbsuftblai.services.GbsuFtbLaiService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;;

@RestController
@RequestMapping("/gbsu-ftb-lai")
public class GbsuFtbLaiController {
	
	@Autowired
	public GbsuFtbLaiService gbsuFtbLaiService;

    @GetMapping(value="/{inputNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    //@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:4200"])
    public ResultDto convertNumber(@PathVariable(name = "inputNumber") Integer inputNumber) {
        return new ResultDto(gbsuFtbLaiService.convertNumber(inputNumber));
    }
	
	class ResultDto {
		public String result;
		
		public ResultDto(String result){
			this.result = result;
		}
	}
}
