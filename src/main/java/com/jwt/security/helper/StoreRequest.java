package com.jwt.security.helper;

import com.jwt.security.model.Stores;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StoreRequest {
	
	Stores stores;

}
