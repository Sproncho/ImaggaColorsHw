package telran.imagga.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ColorDto {
    int r,g,b;
    String closest_palette_color;
    String closest_palette_color_html_code;
    String closest_palette_color_parent;
    Double closest_palette_distance;
    String html_code;
    Double percent;


}
