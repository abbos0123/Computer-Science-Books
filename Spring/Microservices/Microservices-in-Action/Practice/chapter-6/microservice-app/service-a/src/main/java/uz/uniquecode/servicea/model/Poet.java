package uz.uniquecode.servicea.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Abbos Fayziboev
 * Date: 14/04/23
 * Email: abbosFayziboev@gmail.com
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Poet {
    private Integer id;
    private String name;
    private String text;
    private String author;
    private int year;
}
