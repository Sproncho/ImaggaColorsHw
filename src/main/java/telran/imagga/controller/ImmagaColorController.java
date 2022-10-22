package telran.imagga.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import telran.imagga.dto.ColorDto;
import telran.imagga.dto.ResponseColorDto;

public class ImmagaColorController {
    static RestTemplate restTemplate = new RestTemplate();
    static final String TOKEN = "Basic YWNjXzU3ZjlmMWQwMGEzMjIwNDpkZjcwNWNjN2QxOGY0YjdjZTE5OTgxOWYyOTZlY2NjYQ==";
    static String img = "https://htstatic.imgsmail.ru/pic_original/009eb54838df2f01b3668834ea34f8e4/2180258/";
    static String baseUrl = "https://api.imagga.com/v2/colors";

    public static void main(String[] args) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, TOKEN);
        UriComponentsBuilder builder =  UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("image_url",img);
        RequestEntity<String> requestEntity = new RequestEntity<>(headers,HttpMethod.GET,
                builder.build().toUri());
        ResponseEntity<ResponseColorDto> responseEntity = restTemplate.exchange(requestEntity, ResponseColorDto.class);
        responseEntity.getBody().getResult().getColors().getBackground_colors().forEach(c -> printColor(c));
        responseEntity.getBody().getResult().getColors().getForeground_colors().forEach(c -> printColor(c));
        responseEntity.getBody().getResult().getColors().getImage_colors().forEach(c -> printColor(c));

    }
    public static void printColor(ColorDto color){
        System.out.println(color.getClosest_palette_color() + " " + color.getClosest_palette_color_parent() + " " +color.getPercent());
    }
}
