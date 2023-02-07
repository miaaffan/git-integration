package com.git.intergration.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.git.intergration.model.RepoResponse;
import com.git.intergration.model.UsersDto;

@Service
public class GitApiService {

	private final WebClient webClient;
	
	public GitApiService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("https://api.github.com").defaultHeader(HttpHeaders.USER_AGENT, "WebClient")
	            .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();
	}

	public UsersDto callApi(String userName) {
		return this.webClient.get().uri("/users/{userName}", userName)
				.retrieve().bodyToMono(UsersDto.class).block();
	}
	
	
	public List<RepoResponse> callReposApi(String userName) {
//		RestTemplate restTemplate = new RestTemplate();
//		List<LinkedHashMap<String,String>> repos = restTemplate.getForObject("https://api.github.com/users/srikanthpragada/repos", List.class);
        
       
        
        List<LinkedHashMap<String,String>> repos1 =  webClient.get().uri("/users/{userName}/repos", userName)
				.retrieve().bodyToMono(List.class).block();
        
        List<RepoResponse> repoResList = new ArrayList<RepoResponse>();
        for(LinkedHashMap<String,String>  repo : repos1)
        { 
        	RepoResponse rep = new RepoResponse();
        	rep.setName(repo.get("name"));
        	rep.setUrl(repo.get("html_url"));
        	repoResList.add(rep);
        }
       System.out.println(repoResList);
        
        return repoResList;
	}
	
	
	

}