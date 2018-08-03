package com.gzdx.test.spring.springboot.domain;

import com.gzdx.test.spring.springboot.entity.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResp implements Serializable{
	String id;
	
	String code;
	
	String name;
	
	StatusEnum status;

}
