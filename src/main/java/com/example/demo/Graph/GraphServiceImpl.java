package com.example.demo.Graph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import lombok.Setter;
import lombok.extern.java.Log;

@Service
@Log
public class GraphServiceImpl implements GraphService {
	@Setter(onMethod_=@Autowired)
	private GraphMapper mapper;
	
	@Override
	public List<GraphVO> getGraph(){
		return mapper.getGraph();
	}
}
