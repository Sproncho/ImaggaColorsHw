package telran.imagga.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class ColorsDto {
    List<ColorDto> background_colors;
    List<ColorDto> foreground_colors;
    List<ColorDto> image_colors;

}
